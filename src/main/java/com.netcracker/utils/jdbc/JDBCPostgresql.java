package com.netcracker.utils.jdbc;

import com.netcracker.contracts.Contract;
import com.netcracker.contracts.InternetContract;
import com.netcracker.contracts.MobileContract;
import com.netcracker.contracts.TelevisionContract;
import com.netcracker.person.Person;
import com.netcracker.repository.Repository;

import java.sql.*;
import java.time.LocalDate;

public class JDBCPostgresql {

    private Connection connection;

    public JDBCPostgresql() {

    }

    public Connection getNewConnection () throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found.");
            e.printStackTrace();
            return null;
        }
        String url = "jdbc:postgresql://localhost:5433/RepositoryDB";
        String user = "postgres";
        String pass = "root";
        this.connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }

    public ResultSet getAllDataFromDB () throws SQLException {
        Statement statement = this.connection.createStatement();
        String query = "select c.*, " +
                              "p.* " +
                        "from contract c " +
                             "left join people p on " +
                                   "p.id = c.person_id;";
        ResultSet rs = statement.executeQuery(query);
        return rs;
    }

    public void savePersonDataToDB (Repository contractsRepository) {

        try {
            getNewConnection();
            PreparedStatement statementForPeopleInserting = connection.prepareStatement("INSERT INTO public.people " +
                        "(id, full_name, birthdate, gender, passport_num, passport_series) VALUES (?,?,?,?,?,?);");
            PreparedStatement statementForContract = connection.prepareStatement("INSERT INTO public.contract " +
                    "(id, begin_date, end_date, contract_num, contract_type, add_info, person_id) VALUES (?,?,?,?,?,?,?);");
                for (int i = 0; i < contractsRepository.getSize(); i++) {
                    Contract contract = contractsRepository.getContract(i+1);
                    Person person = contract.getOwner();
                    statementForPeopleInserting.setInt(1, person.getId());
                    statementForPeopleInserting.setString(2, person.getFullName());
                    statementForPeopleInserting.setDate(3, Date.valueOf(person.getBirthDay()));
                    statementForPeopleInserting.setString(4, String.valueOf(person.getGender()));
                    statementForPeopleInserting.setInt(5, person.getPassportNumber());
                    statementForPeopleInserting.setInt(6, person.getPassportSeries());
                    statementForPeopleInserting.executeUpdate();

                    statementForContract.setInt(1, contract.getId());
                    statementForContract.setDate(2, Date.valueOf(contract.getStartingDate()));
                    statementForContract.setDate(3, Date.valueOf(contract.getEndingDate()));
                    statementForContract.setInt(4, contract.getContractNumber());
                    statementForContract.setInt(7, contract.getOwner().getId());

                    if (contract instanceof MobileContract) {
                        statementForContract.setString(5, "Mobile contract");
                        statementForContract.setString(6, ((MobileContract) contract).getSmsNumber() + " "
                                                                         + ((MobileContract) contract).getGbNumber() + " "
                                                                         + ((MobileContract) contract).getMinutesNumber());
                    } else if ( contract instanceof TelevisionContract) {
                        statementForContract.setString(5, "TelevisionContract");
                        statementForContract.setString(6, ((TelevisionContract) contract).getChannelPackage().toString());
                    } else if (contract instanceof InternetContract) {
                        statementForContract.setString(5, "InternetContract");
                        Integer speed = ((InternetContract) contract).getSpeedConnection();
                        statementForContract.setString(6, speed.toString());
                    }
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void closeConnection () throws SQLException {
        connection.close();
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
