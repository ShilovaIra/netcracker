package netcracker.person;

import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PersonTest {

    Person firstPerson = new Person(1, "Gerald Battler", LocalDate.of(1971,7,7), Gender.MALE, 567890, 2000);
    Person secondPerson = new Person(2, "Leila Murphy", LocalDate.of(1984,6,23), Gender.FEMALE, 342670, 2005);
    Person thirdPerson = new Person(3, "Din Chester", LocalDate.of(1999,2,1), Gender.MALE, 874256, 2018);

    @Test
    void getId() {
        firstPerson.getId();
        secondPerson.getId();
        thirdPerson.getId();
    }

    @Test
    void getFullName() {
        firstPerson.getFullName();
        secondPerson.getFullName();
        thirdPerson.getFullName();
    }

    @Test
    void getBirthDay() {
        firstPerson.getBirthDay();
        secondPerson.getBirthDay();
        thirdPerson.getBirthDay();
    }

    @Test
    void getGender() {
        firstPerson.getGender();
        secondPerson.getGender();
        thirdPerson.getGender();
    }

    @Test
    void getPassportNumber() {
        firstPerson.getPassportNumber();
        secondPerson.getPassportNumber();
        thirdPerson.getPassportNumber();
    }

    @Test
    void getPassportSeries() {
        firstPerson.getPassportSeries();
        secondPerson.getPassportSeries();
        thirdPerson.getPassportSeries();
    }

    @Test
    void testToString() {
        firstPerson.toString();
        secondPerson.toString();
        thirdPerson.toString();
    }
}