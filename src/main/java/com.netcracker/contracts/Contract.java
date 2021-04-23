package com.netcracker.contracts;

import com.netcracker.person.Person;
import com.netcracker.utils.jaxb.LocalDateAdapterForXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;

/**
 * abstract class Contract with properties id, startingDate, endingDate, contractNumber and owner
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Contract {

    /**
     * field id is an unique identifier for contract
     */
    @XmlElement(name = "id")
    protected int id;

    /**
     * field startingDate it's a date when contract was made
     */
    @XmlElement(name = "startingDate")
    @XmlJavaTypeAdapter(value = LocalDateAdapterForXML.class)
    protected LocalDate startingDate;

    /**
     * field endingDate - it's a date when contract will finish exist
     */
    @XmlElement(name = "endingDate")
    @XmlJavaTypeAdapter(value = LocalDateAdapterForXML.class)
    protected LocalDate endingDate;

    /**
     * field contractNumber is a number of contract
     */
    @XmlElement(name = "contractNumber")
    protected int contractNumber;

    /**
     * field owner is entity of contract's owner
     */
    @XmlElement(name = "owner")
    protected Person owner;

    /**
     * constructor - create new object with specific parameters
     * @param id - unique identifier
     * @param startingDate - date when contract was made
     * @param endingDate - date when contract will finish exist
     * @param contractNumber - is a number of contract
     * @param owner - entity of contract's owner
     */
    public Contract(int id, LocalDate startingDate, LocalDate endingDate, int contractNumber, Person owner) {
        this.id = id;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.contractNumber = contractNumber;
        this.owner = owner;
    }

    /**
     * constructor without parameters
     */
    public Contract() {
    }

    /**
     * Method for getting value of field id
     * @return id  - unique identifier of object
     */
    public int getId() {
        return this.id;
    }

    /**
     * Method for setting value of field id
     * @param id - unique identifier of object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method for getting value of field startingDate
     * @return startingDate - date when contract was made
     */
    public LocalDate getStartingDate() {
        return startingDate;
    }

    /**
     *  Method for setting value of field startingDate
     * @param startingDate - date when contract was made
     */
    public void setStartingDate(LocalDate startingDate) {
        this.startingDate = startingDate;
    }

    /**
     * Method for getting value of field endingDate
     * @return endingDate - date when contract will finish exist
     */
    public LocalDate getEndingDate() {
        return endingDate;
    }

    /**
     * Method for setting value of field endingDate
     * @param endingDate - date when contract will finish exist
     */
    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    /**
     * Method for getting value of field contractNumber
     * @return contractNumber
     */
    public int getContractNumber() {
        return contractNumber;
    }

    /**
     * Method for setting value of field contractNumber
     * @param contractNumber
     */
    public void setContractNumber(int contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * Method for getting value of field owner
     * @return owner - entity of contract's owner
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Method for setting value of field owner
     * @param owner - entity of contract's owner
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

    /**
     * Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", contractNumber=" + contractNumber +
                ", owner=" + owner +
                '}';
    }
}
