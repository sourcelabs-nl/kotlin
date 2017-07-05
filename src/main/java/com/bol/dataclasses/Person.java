package com.bol.dataclasses;

public class Person implements Cloneable {

    private String firstname;
    private String lastname;
    private String email;
    private int age;

    public Person(final String firstname, final String lastname, final String email, final int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return new Person(this.getFirstname(), this.getLastname(), this.getEmail(), this.getAge());
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Person person = (Person) o;

        if (age != person.age) return false;
        if (firstname != null ? !firstname.equals(person.firstname) : person.firstname != null) return false;
        if (lastname != null ? !lastname.equals(person.lastname) : person.lastname != null) return false;
        return email != null ? email.equals(person.email) : person.email == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
        final Person person = new Person("Some", "Guy", "someguy@someplace.com", 21);
        final Person copy = person.clone();
        if(person.equals(copy) && person != copy) {
            System.out.println("Equal but not the same instance");
        }
        System.out.println(person.toString());
    }
}
