package com.netcracker.contracts;


import com.netcracker.person.Person;

import java.time.LocalDate;

/**
 * public class for creating objects of television contract with special parameter - channel package
 */
public class TelevisionContract extends Contract {

    /**
     * field contain enumeration of channel package for Television contract
     */
    private ChannelPackage channelPackage;

    /**
     constructor - create new object with specific parameters
     * @param id - unique identifier for Internet contract
     * @param startingDate - it's a date when contract was made
     * @param endingDate - it's a date when contract will finish exist
     * @param contractNumber - it's a number of contract
     * @param owner - it's  entity of contract's owner
     * @param channelPackage - enumeration of channel package for Television contract
     */
    public TelevisionContract(int id, LocalDate startingDate, LocalDate endingDate, int contractNumber, Person owner, ChannelPackage channelPackage) {
        super(id,startingDate, endingDate, contractNumber, owner);
        this.channelPackage = channelPackage;
    }

    /**
     * Method for getting an enumeration of channel package for Television contract
     * @return enumeration of channel package
     */
    public ChannelPackage getChannelPackage() {
        return channelPackage;
    }

    /**
     * Method for setting an enumeration of channel package for Television contract
     * @param channelPackage - enumeration of channel package
     */
    public void setChannelPackage(ChannelPackage channelPackage) {
        this.channelPackage = channelPackage;
    }

    /**
     *Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "TelevisionContract{" +
                "channelPackage=" + channelPackage +
                ", id=" + id +
                ", startingDate=" + startingDate +
                ", endingDate=" + endingDate +
                ", contractNumber=" + contractNumber +
                ", owner=" + owner +
                '}';
    }
}
