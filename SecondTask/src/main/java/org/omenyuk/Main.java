package org.omenyuk;
import org.omenyuk.model.Fines;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * The program parses several JSON files,
 * sorts fine_amont and writes them to the output file
 * @author Omenyuk Vyacheslav .
 */

public class Main {
    private static String PathFines2020 = "fines2020.json";
    private static String PathFines2021 = "fines2021.json";

    public static void main(String[] args) throws IOException {

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get("output.xml"))) {
            Map<String, Double> FinesAllYears = new LinkedHashMap<>();
            File JsonFines2020;
            File JsonFines2021;
            //
            // byte[] mapData = Files.readAllBytes(Paths.get("fines2021.json"));

            FinesAllYears = getStatsFines(JsonFines2020 = new File(PathFines2020), FinesAllYears);
            FinesAllYears = getStatsFines(JsonFines2021 = new File(PathFines2021), FinesAllYears);

            writeStatsFines(FinesAllYears, bufferedWriter);

        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
    * Sorting method LinkedHashMap<>()
     */
    private static Map<String, Double> getStatsFines(File FinesAllYears, Map<String, Double> Fines) {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Double> sortedFines = new LinkedHashMap<>();
        Fines[] fine;
        String key;
        double value;
        try {
            fine = objectMapper.readValue(FinesAllYears, Fines[].class);
            for (Fines fines : fine) {
                key = fines.getType();
                value = fines.getFine_amount();
                if (Fines.containsKey(key)) {
                    Fines.put(key, Fines.get(key) + value);
                } else {
                    Fines.put(key, value);
                }
                System.out.println(key + " : " + value);
            }

            Fines.entrySet().stream()
                    .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                    .forEach(entry -> sortedFines.put(entry.getKey(), entry.getValue()));

            return sortedFines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writing the sorted map to the output file
     */
    public static void writeStatsFines(Map<String, Double> fines, BufferedWriter bufferedWriter) throws IOException {

        bufferedWriter.write("<fines>\n");
            fines.forEach((key, value) -> {
            try {
                bufferedWriter.write("\t<fines type=\"" + key + "\" fine_amount=\"" + value + "\" />\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        bufferedWriter.write("</fines>\n");
    }
}
