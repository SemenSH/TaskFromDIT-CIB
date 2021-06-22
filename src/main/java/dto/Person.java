package dto;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Person implements Serializable {
    private String firstName;
    private String lastName;

    public static final Comparator<Person> COMPARE_BY_PERSON = new Comparator<Person>() {
        @Override
        public int compare(Person lhs, Person rhs) {
            return lhs.getLastName().compareTo(rhs.getLastName());
        }
    };

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
