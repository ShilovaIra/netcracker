package com.netcracker.utils.jaxb;

import com.netcracker.contracts.Contract;
import com.netcracker.contracts.InternetContract;
import com.netcracker.contracts.MobileContract;
import com.netcracker.contracts.TelevisionContract;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.logging.Logger;

/**
 * class for creating and parsing xml file
 */
public class ParserXML {

    private static Logger logger = Logger.getLogger(ParserXML.class.getName());

    /**
     * Method create xml file by existing repository using jaxb context and marshaller
     * @param repository that need to be converted to xml file
     */
    public void createXML (Repository repository) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class,
                    Contract.class, InternetContract.class, MobileContract.class,
                    TelevisionContract.class, Person.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            logger.info("Creating xml-file ...");
            marshaller.marshal(repository, new File("repository.xml"));
            logger.info("Xml-file created successfully.");
        } catch (JAXBException e) {
            logger.warning("Throws JAXBException while creating xml");
        }
    }

    /**
     * method parse existing xml-file using jaxb context and unmarshaller
     * @param path to file in root directory
     * @return repository object with data from xml file
     * @throws FileNotFoundException in case when file in directory not found
     */
    public Repository readXML (String path) throws FileNotFoundException {
        Repository repository = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Repository.class,
                    Contract.class, InternetContract.class, MobileContract.class,
                    TelevisionContract.class, Person.class);
            FileReader xmlFile = new FileReader(path);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            logger.info("Parsing xml-file ...");
            repository = (Repository) unmarshaller.unmarshal(xmlFile);
            if (repository !=  null)
                logger.info("Xml-file parsed successfully.");
            else
                logger.info("Xml-file created nullable repository.");
        } catch (JAXBException e) {
            logger.warning("Throws JAXBException while parsing xml");
        }
        return repository;
    }
}
