package org.omenyuk;
import org.omenyuk.model.Person;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The program parses the xml file using the dom library
 * and records the result in which the surname element is deleted
 * @author Omenyuk Vyacheslav .
 */

public class Task1 implements Serializable {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        String inputFile = "input.xml";
        String outputFile = "output.xml";
        ArrayList<Person> people = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // Get the factory to get the document builder later.
        DocumentBuilder builder = factory.newDocumentBuilder();// We received a builder from the factory that parses XML, creates a Document structure in the form of a hierarchical tree.
        Document document = builder.parse(new File(inputFile));// Parsed the XML, created the Document structure. Now we have access to all the elements we need.
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("person"); // Getting the list of all employee elements within the root element (getDocumentElement returns the ROOT element of the XML file).

        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);
            NamedNodeMap attributes = employee.getAttributes();// Getting the attributes of each element
            // Adding an employee. The attribute is also a Node, so we need to get the value of the attribute using the getNodeValue() method
            people.add(new Person(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("surname").getNodeValue(), attributes.getNamedItem("birthDate").getNodeValue()));
        }

        // Write it in a file
            try (BufferedReader in = Files.newBufferedReader(Paths.get(inputFile));
                 BufferedWriter writer = Files.newBufferedWriter(Paths.get(outputFile))) {
                {
                    writer.write("<persons>\n");
                    for (Person person : people) {
                    System.out.println(String.format(String.valueOf(person)));
                    writer.write(person.toString() + "\n");
                }
                    writer.write("</persons>");
            }
        }
    }
}