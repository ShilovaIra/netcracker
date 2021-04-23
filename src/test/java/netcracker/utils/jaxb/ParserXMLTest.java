package netcracker.utils.jaxb;

import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import com.netcracker.utils.jaxb.ParserXML;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class ParserXMLTest {

    private ParserXML parserXML = new ParserXML();
    private static Logger logger = Logger.getLogger(ParserXML.class.getName());

    @Test
    void createXML() {

        Person firstPerson = new Person(2, "Gerald Battler", LocalDate.of(1971,7,7), Gender.MALE, 567890, 2000);
        Person secondPerson = new Person(1, "Leila Murphy", LocalDate.of(1984,6,23), Gender.FEMALE, 342670, 2005);
        Person thirdPerson = new Person(3, "Din Chester", LocalDate.of(1999,2,1), Gender.MALE, 874256, 2018);

        Contract internetContract = new InternetContract(3, LocalDate.of(2020, 10, 12), LocalDate.of(2020,12,12), 10, firstPerson, 100);
        Contract mobileContract = new MobileContract(1, LocalDate.of(2019, 1, 1), LocalDate.of(2021,1,1), 12, secondPerson, 200, 10, 200);
        Contract televisionContract = new TelevisionContract(2, LocalDate.of(2015, 3, 26), LocalDate.of(2019,9,26), 17, thirdPerson, ChannelPackage.ULTRAHD);

        Contract[] contracts = new Contract[]{internetContract, mobileContract, televisionContract};
        Repository testRepository = new Repository(contracts, 3);

        parserXML.createXML(testRepository);

    }

    @Test
    void readXML() throws FileNotFoundException {

        Repository repository = parserXML.readXML("repository.xml");
        logger.info("Parsing results: ");
        logger.info(repository.toString());

    }
}