package netcracker.repository;

import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import com.netcracker.utils.comparators.ContractIdComparator;
import com.netcracker.utils.reflection.InjectionException;
import com.netcracker.utils.reflection.Injector;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.function.Predicate;


class RepositoryTest {

    Person firstPerson = new Person(2, "Gerald Battler", LocalDate.of(1971,7,7), Gender.MALE, 567890, 2000);
    Person secondPerson = new Person(1, "Leila Murphy", LocalDate.of(1984,6,23), Gender.FEMALE, 342670, 2005);
    Person thirdPerson = new Person(3, "Din Chester", LocalDate.of(1999,2,1), Gender.MALE, 874256, 2018);

    Contract internetContract = new InternetContract(3, LocalDate.of(2020, 10, 12), LocalDate.of(2020,12,12), 10, firstPerson, 100);
    Contract mobileContract = new MobileContract(1, LocalDate.of(2019, 1, 1), LocalDate.of(2021,1,1), 12, secondPerson, 200, 10, 200);
    Contract televisionContract = new TelevisionContract(2, LocalDate.of(2015, 3, 26), LocalDate.of(2019,9,26), 17, thirdPerson, ChannelPackage.ULTRAHD);
    Contract televisionContract2 = new TelevisionContract(4, LocalDate.of(2018, 8, 9), LocalDate.of(2022,8,9), 23, firstPerson, ChannelPackage.BASE);

    Contract[] contracts = new Contract[]{internetContract, mobileContract, televisionContract};
    Repository testRepository = new Repository(contracts, 3);

    @Test
    void add() {
        testRepository.add(televisionContract2);
    }


    @Test
    void getContract() {
        testRepository.getContract(1);
        testRepository.getContract(2);
    }

    @Test
    void getSize() {
        testRepository.getSize();
    }

    @Test
    void delete() {
        testRepository.delete(1);
    }


    @Test
    void sort() throws IllegalAccessException, InjectionException {
        Injector injector = new Injector();
        injector.inject(testRepository);
        System.out.println(testRepository.toString());
        testRepository.sort(new ContractIdComparator());
        System.out.println(testRepository.toString());
    }

    @Test
    void searchBy() {
        Predicate<Contract> contractId = x -> x.getId() == 1;
        System.out.println(testRepository.searchBy(contractId));
    }
}