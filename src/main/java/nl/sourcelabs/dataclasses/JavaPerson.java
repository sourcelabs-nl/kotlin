package nl.sourcelabs.dataclasses;

/**
 * Java Person Pojo, containing comparable functionality to the Kotlin data class.
 */
public final class JavaPerson {

    private final String firstname;
    private final String lastname;
    private String email;
    private int age;

    public JavaPerson(final String firstname, final String lastname, final String email, final int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.age = age;
    }

    public JavaPerson(final JavaPerson source) {
        this.firstname = source.firstname;
        this.lastname = source.lastname;
        this.email = source.email;
        this.age = source.age;
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

    protected JavaPerson copy() {
        return new JavaPerson(this);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final JavaPerson that = (JavaPerson) o;

        if (age != that.age) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
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
        return "JavaPerson{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws Exception {
        final JavaPerson person = new JavaPerson("Some", "Guy", "someguy@someplace.com", 21);
        final JavaPerson copy = person.copy();
        if (person.equals(copy) && person != copy) {
            System.out.println("Equal but not the same instance");
        }
        System.out.println(person.toString());
    }
}
