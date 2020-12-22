package com.netcracker.utils.dataLoader;

import com.opencsv.*;
import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import com.netcracker.utils.reflection.AutoInjectable;
import com.netcracker.utils.validator.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * public class for load data from csv file to repository
 */
public class DataLoader {

    private static Logger logger = Logger.getLogger(DataLoader.class.getName());
    /**
     * field format contain data format for correct reading from file
     */
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    /**
     * field contain current person readied from file
     */
    private Person person;
    /**
     * list that contain unique person from file
     */
    private List <Person> personList = new ArrayList<>();
    /**
     * field contain current contract readed from file
     */
    private Contract contract;
    /**
     * field repository for creating repository
     */
    private Repository repository = new Repository();
    /**
     * object for reading and processing csv file
     */
    private CSVReader csvReader;
    /**
     * parser for processing csv file
     */
    private CSVParser parser = new CSVParserBuilder()
            .withSeparator(';')
            .withIgnoreQuotations(true)
            .build();

    private List<Message> validateMesage;

    @AutoInjectable(clazz = Validator.class)
    private List<Validator> validators = new ArrayList<>();

    /**
     * constructor without parameters
     */
    public DataLoader() {

    }

    /**
     * Mothod for reading all information from csv file to repository
     * using validation for correct add contracts to repository.
     * @param reader a reader, given the name of the file to read from.
     * @return full repository with information which readed from file
     * @throws IOException
     */
    public Repository readAll (Reader reader) throws IOException, ClassNotFoundException {
//        validators.add(new ContractDateValidator());
//        validators.add(new ContractIdValidator());
//        validators.add(new MobileContractValidate());
//        validators.add(new TelevisionContractValidate());
//        validators.add(new ContractNumberValidator());
//        validators.add(new PersonAgeValidator());
//        validators.add(new InternetContractValidator());

        csvReader = new CSVReaderBuilder(new FileReader("csvnetcracker.csv"))
                .withCSVParser(parser)
                .withSkipLines(0)
                .build();

        String[] line;
        line = csvReader.readNext();
        int personId = 1;
        int lineNumber = 1;

        logger.log(Level.INFO, "Data load from file is started.");

        while ((line = csvReader.readNext()) != null) {

            person = new Person(personId,
                    line[4],
                    LocalDate.parse(line[5], format),
                    Gender.valueOf(line[6].toUpperCase()),
                    Integer.parseInt(line[7]),
                    Integer.parseInt(line[8])
            );
            personId++;

            logger.log(Level.INFO,"Read " + lineNumber + " line");

            if (1 == Integer.parseInt(line[0])) {
                personList.add(person);
            }

            for (int i = 0; i <personList.size(); i++){
                if (!(personList.get(i).getFullName().equals(person.getFullName()))) {
                    personList.add(person);
                } else {
                    person.setId(personList.get(i).getId());
                }
            }


            String[] addInfo = line[line.length - 1].split(" ");
            if (line[9].equals("Mobile Contract")) {
                contract = new MobileContract(Integer.parseInt(line[0]),
                        LocalDate.parse(line[1], format),
                        LocalDate.parse(line[2], format),
                        Integer.parseInt(line[3]),
                        person,
                        Integer.parseInt(addInfo[0]),
                        Integer.parseInt(addInfo[1]),
                        Integer.parseInt(addInfo[2]));
            }
            else if (line[9].equals("Internet Contract")) {
                contract = new InternetContract(Integer.parseInt(line[0]),
                        LocalDate.parse(line[1], format),
                        LocalDate.parse(line[2], format),
                        Integer.parseInt(line[3]),
                        person,
                        Integer.parseInt(addInfo[0]));
            }
            else if (line[9].equals("Television Contract")) {
                contract = new TelevisionContract(Integer.parseInt(line[0]),
                        LocalDate.parse(line[1], format),
                        LocalDate.parse(line[2], format),
                        Integer.parseInt(line[3]),
                        person,
                        ChannelPackage.valueOf(addInfo[0]));
            }
            validateMesage = new ArrayList<>();
            validateMesage = validate(contract, validators);
            int errorCount = 0;
            for (Message m: validateMesage) {
                if (!m.getStatus().equals(Status.OK)) {
                    logger.log(Level.WARNING, m.getComponent());
                    errorCount++;
                    logger.log(Level.INFO, "Contract cant be added in repository");
                }

            }
            if (errorCount == 0) {
                logger.log(Level.INFO, "Adding contract in repository");
                repository.add(contract);
            }
            lineNumber += 1;
        }
        reader.close();
        csvReader.close();
        return repository;
    }

    public static List<Message> validate (Contract contract, List<Validator> validatorList) throws ClassNotFoundException {
        List<Message> messages = new ArrayList<>();
        for (Validator validator: validatorList) {
            if (validator.getApplicableFor().isInstance(contract))
                messages.add(validator.validate(contract));
        }
        return messages;
    }
}

