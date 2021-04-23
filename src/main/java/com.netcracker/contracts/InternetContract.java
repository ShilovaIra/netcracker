package com.netcracker.contracts;

import com.netcracker.person.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

/**
 * public class for creating objects of Internet contract with special parameters speedConnection
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InternetContract extends Contract {

    /**
     * field contain value of Internet connection for current contract
     */
    @XmlElement(name = "speedConnection")
    private int speedConnection;

    /**
     * constructor - create new object with specific parameters
     * @param id - unique identifier for Internet contract
     * @param startingDate - it's a date when contract was made
     * @param endingDate - it's a date when contract will finish exist
     * @param contractNumber - it's a number of contract
     * @param owner - it's  entity of contract's owner
     * @param speedConnection  - value of Internet connection
     */
    public InternetContract(int id, LocalDate startingDate, LocalDate endingDate, int contractNumber, Person owner, int speedConnection) {
        super(id,startingDate, endingDate, contractNumber, owner);
        this.speedConnection = speedConnection;
    }

    /**
     * constructor without parameters
     */
    public InternetContract() {
        super();
    }

    /**
     * Method for getting speed connection of contract
     * @return value of speedConnection parameter
     */
    public int getSpeedConnection() {
        return speedConnection;
    }


    /**
     *  Method for setting speed connection of contract
     * @param speedConnection - value of speedConnection
     */
    public void setSpeedConnection(int speedConnection) {
        this.speedConnection = speedConnection;
    }

    /**
     *Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "InternetContract{" +
                "speedConnection=" + speedConnection +
                ", id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", contractNumber=" + contractNumber +
                ", owner=" + owner +
                '}';
    }
}
