package com.netcracker.utils.jdbc;

import com.netcracker.contracts.*;
import com.netcracker.person.Gender;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class JDBCPostgresqlTest {

    public static JDBCPostgresql jdbcPostgresql;


    @Test
    void testSavePersonDataToDB() throws SQLException {
        jdbcPostgresql = new JDBCPostgresql();
        try(Connection connection = jdbcPostgresql.getNewConnection()) {
            assertTrue(connection.isValid(1));
            assertFalse(connection.isClosed());
        }

        Person firstPerson = new Person(6, "Gerald Batwdtler", LocalDate.of(1971,7,7), Gender.MALE, 567890, 2000);
        Person secondPerson = new Person(7, "Leila Murphy", LocalDate.of(1984,6,23), Gender.FEMALE, 342670, 2005);
        Person thirdPerson = new Person(8, "Din Chester", LocalDate.of(1999,2,1), Gender.MALE, 874256, 2018);

        Contract internetContract = new InternetContract(1, LocalDate.of(2020, 10, 12), LocalDate.of(2020,12,12), 10, firstPerson, 100);
        Contract mobileContract = new MobileContract(2, LocalDate.of(2019, 1, 1), LocalDate.of(2021,1,1), 12, secondPerson, 200, 10, 200);
        Contract televisionContract = new TelevisionContract(3, LocalDate.of(2015, 3, 26), LocalDate.of(2019,9,26), 17, thirdPerson, ChannelPackage.ULTRAHD);
        Repository testRepository = new Repository();
        testRepository.add(internetContract);
        testRepository.add(mobileContract);
        testRepository.add(televisionContract);
        jdbcPostgresql.savePersonDataToDB(testRepository);
    }
}