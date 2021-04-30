package com.netcracker.utils.jdbc;

import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import com.netcracker.utils.dataLoader.DataLoader;
import com.netcracker.utils.reflection.AutoInjectable;
import com.netcracker.utils.validator.Message;
import com.netcracker.utils.validator.Status;
import com.netcracker.utils.validator.Validator;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class made for load data from database to repository
 */

public class JDBCDataLoader {

    private static Logger logger = Logger.getLogger(DataLoader.class.getName());
    /**
     * field contain current person readied from file
     */
    private Person person;
    /**
     * list that contain unique person from file
     */
    private List<Person> personList = new ArrayList<>();
    /**
     * field contain current contract readied from file
     */
    private Contract contract;
    /**
     * field repository for creating repository
     */
    private Repository repository = new Repository();
    /**
     * jdbcPostgresql - an object which contain properties for db connections
     */
    private JDBCPostgresql jdbcPostgresql = new JDBCPostgresql();

    /**
     * List contain the massages with as the result of validation
     */
    private List<Message> validateMessage;

    @AutoInjectable(clazz = Validator.class)
    private List<Validator> validators = new ArrayList<>();

    /**
     * Mothod for reading all information from database to repository
     * using validation for correct adding contracts to repository.
     * @return full repository with information which reade from file
     * @throws IOException
     */
    public Repository readAll () throws SQLException, ClassNotFoundException {
        jdbcPostgresql.getNewConnection();
        ResultSet resultSet = jdbcPostgresql.getAllDataFromDB();


        int lineNumber = 1;

        logger.log(Level.INFO, "Data load from file is started.");

        while (resultSet.next()) {

            int personId = resultSet.getInt(8);
            person = new Person(personId,
                    resultSet.getString(9),
                    resultSet.getDate(10).toLocalDate(),
                    Gender.valueOf(resultSet.getString(11).toUpperCase()),
                    resultSet.getInt(12),
                    resultSet.getInt(13)
            );
            personId++;

            logger.log(Level.INFO,"Read " + lineNumber + " line from db");

            if (1 == resultSet.getInt(8)) {
                personList.add(person);
            }

            for (int i = 0; i <personList.size(); i++) {
                if (!(personList.get(i).getId() == person.getId())) {
                    personList.add(person);
                }
            }


            String[] addInfo = resultSet.getString(6).split(" ");
            if (resultSet.getString(5).equals("Mobile Contract")) {
                contract = new MobileContract(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getInt(4),
                        person,
                        Integer.parseInt(addInfo[0]),
                        Integer.parseInt(addInfo[1]),
                        Integer.parseInt(addInfo[2]));
            }
            else if (resultSet.getString(5).equals("Internet Contract")) {
                contract = new InternetContract(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getInt(4),
                        person,
                        Integer.parseInt(addInfo[0]));
            }
            else if (resultSet.getString(5).equals("Television Contract")) {
                contract = new TelevisionContract(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getDate(3).toLocalDate(),
                        resultSet.getInt(4),
                        person,
                        ChannelPackage.valueOf(addInfo[0]));
            }
            validateMessage = new ArrayList<>();
            validateMessage = validate(contract, validators);
            int errorCount = 0;
            for (Message m: validateMessage) {
                if (!m.getStatus().equals(Status.OK)) {
                    logger.log(Level.WARNING, m.getComponent());
                    errorCount++;
                    logger.log(Level.INFO, "Contract from db cant be added in repository");
                }

            }
            if (errorCount == 0) {
                logger.log(Level.INFO, "Adding contract from db to repository");
                repository.add(contract);
            }
            lineNumber += 1;
        }
        jdbcPostgresql.closeConnection();
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
