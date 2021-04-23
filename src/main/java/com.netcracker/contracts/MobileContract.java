package com.netcracker.contracts;

import com.netcracker.person.Person;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

/**
 * public class for creating objects of mobile contract with special parameters: number of sms, number of GB, number of minutes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class MobileContract extends Contract {

    /**
     * field smsNumber is a number of sms for mobile contract
     */
    @XmlElement(name = "smsNum")
    private int smsNumber;
    /**
     * field gbNumber is a number of GB for mobile contract
     */
    @XmlElement(name = "gbNum")
    private int gbNumber;
    /**
     * field minutesNumber is a number of minutes for mobile contract
     */
    @XmlElement(name = "minNum")
    private int minutesNumber;

    /**
     * constructor - create new object with specific parameters
     * @param id - unique identifier for Internet contract
     * @param startingDate - it's a date when contract was made
     * @param endingDate - it's a date when contract will finish exist
     * @param contractNumber - it's a number of contract
     * @param owner - it's  entity of contract's owner
     * @param smsNumber - is a number of sms for mobile contract
     * @param gbNumber - is a number of GB for mobile contract
     * @param minutesNumber - is a number of minutes for mobile contract
     */
    public MobileContract(int id, LocalDate startingDate, LocalDate endingDate, int contractNumber, Person owner, int smsNumber, int gbNumber, int minutesNumber) {
        super(id,startingDate, endingDate, contractNumber, owner);
        this.smsNumber = smsNumber;
        this.gbNumber = gbNumber;
        this.minutesNumber = minutesNumber;
    }

    /**
     * constructor without parameters
     */
    public MobileContract() {
        super();
    }

    /**
     * Method for getting a number of sms for mobile contract
     * @return number of sms for mobile contract
     */
    public int getSmsNumber() {
        return smsNumber;
    }

    /**
     * Method for setting a number of sms for mobile contract
     * @param smsNumber - number of sms for mobile contract
     */
    public void setSmsNumber(int smsNumber) {
        this.smsNumber = smsNumber;
    }

    /**
     * Method for getting a number of GB for mobile contract
     * @return number of GB for mobile contract
     */
    public int getGbNumber() {
        return gbNumber;
    }

    /**
     * Method for setting a number of GB for mobile contract
     * @param gbNumber - is a number of GB for mobile contract
     */
    public void setGbNumber(int gbNumber) {
        this.gbNumber = gbNumber;
    }

    /**
     * Method for getting a number of minutes for mobile contract
     * @return number of minutes for mobile contract
     */
    public int getMinutesNumber() {
        return minutesNumber;
    }

    /**
     *  Method for setting a number of minutes for mobile contract
     * @param minutesNumber - number of minutes for mobile contract
     */
    public void setMinutesNumber(int minutesNumber) {
        this.minutesNumber = minutesNumber;
    }

    /**
     *Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "MobileContract{" +
                "smsNumber=" + smsNumber +
                ", gbNumber=" + gbNumber +
                ", minutesNumber=" + minutesNumber +
                ", id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", contractNumber=" + contractNumber +
                ", owner=" + owner +
                '}';
    }
}
