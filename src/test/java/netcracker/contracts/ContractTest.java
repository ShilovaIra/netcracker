package netcracker.contracts;

import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ContractTest {

    Person firstPerson = new Person(1, "Gerald Battler", LocalDate.of(1971,7,7), Gender.MALE, 567890, 2000);
    Person secondPerson = new Person(2, "Leila Murphy", LocalDate.of(1984,6,23), Gender.FEMALE, 342670, 2005);
    Person thirdPerson = new Person(3, "Din Chester", LocalDate.of(1999,2,1), Gender.MALE, 874256, 2018);

    Contract internetContract = new InternetContract(1, LocalDate.of(2020, 10, 12), LocalDate.of(2020,12,12), 10, firstPerson, 100);
    Contract mobileContract = new MobileContract(2, LocalDate.of(2019, 1, 1), LocalDate.of(2021,1,1), 12, secondPerson, 200, 10, 200);
    Contract televisionContract = new TelevisionContract(2, LocalDate.of(2015, 3, 26), LocalDate.of(2019,9,26), 17, thirdPerson, ChannelPackage.ULTRAHD);

    @Test
    void getId() {
        internetContract.getId();
        mobileContract.getId();
        televisionContract.getId();
    }

    @Test
    void getStartingDate() {
        internetContract.getStartingDate();
        mobileContract.getStartingDate();
        televisionContract.getStartingDate();
    }

    @Test
    void getEndingDate() {
        internetContract.getEndingDate();
        mobileContract.getEndingDate();
        televisionContract.getEndingDate();
    }

    @Test
    void getContractNumber() {
        internetContract.getContractNumber();
        mobileContract.getContractNumber();
        televisionContract.getContractNumber();
    }

    @Test
    void getOwner() {
        internetContract.getOwner();
        mobileContract.getOwner();
        televisionContract.getOwner();
    }

    @Test
    void testToString() {
        internetContract.toString();
        mobileContract.toString();
        televisionContract.toString();
    }
}