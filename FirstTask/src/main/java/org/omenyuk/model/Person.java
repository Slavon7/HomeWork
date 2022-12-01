package org.omenyuk.model;

public class Person {
    private String name;
    private String surname;
    private String birthDate;

    public Person(String name, String surname, String birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;

    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getBirthDate() {
        return birthDate;
    }


    @Override
    public String toString() {
        return "<person " +
                "name=\"" + name + ' ' +
                surname +
                "\" birthDate=\"" + birthDate + '\"' +
                '/'+'>';
    }


}
