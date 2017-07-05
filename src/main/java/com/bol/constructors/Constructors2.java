package com.bol.constructors;

import java.time.LocalDate;
import java.time.Period;

public class Constructors2 {
    public static void main(String[] args) {
        final Person person = new Person("Jay", LocalDate.of(1980, 6, 6));
        System.out.println(person.getAge());
    }
}

class JavaPerson {

    private String name;
    private LocalDate dateOfBirth;
    private int age;

    public JavaPerson(final String name, final LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.age = Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }
}
