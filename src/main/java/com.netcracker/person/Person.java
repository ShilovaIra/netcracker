package com.netcracker.person;

import java.time.LocalDate;

/**
 * public class for creating objects of person with special parameters speedConnection
 */
public class Person {

    /**
     * field id is an unique identifier for person
     */
    private int id;
    /**
     * field fullName contain full name of person
     */
    private String fullName;
    /**
     * field birthDay contain value of person's birthday
     */
    private LocalDate birthDay;
    /**
     * field contain value of person's gender
     */
    private Gender gender;
    /**
     * field contain passport number of person
     */
    private int passportNumber;
    /**
     * field contain series of passport of person
     */
    private int passportSeries;

    /**
     * constructor - create new object without parameters
     */
    public Person() {
    }

    /**
     * constructor - create new object with specific parameters
     * @param id - is an unique identifier for person
     * @param fullName - full name of person
     * @param birthDay - value of person's birthday
     * @param gender - person's gender
     * @param passportNumber - passport number of person
     * @param passportSeries - series of passport of person
     */
    public Person(int id,String fullName, LocalDate birthDay, Gender gender, int passportNumber, int passportSeries) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.gender = gender;
        this.passportNumber = passportNumber;
        this.passportSeries = passportSeries;
    }

    /**
     * Method for getting value of field id
     * @return id  - an unique identifier of object
     */
    public int getId() {
        return id;
    }

    /**
     * Method for setting value of field id
     * @param id - an unique identifier of object
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method for getting value of field fullName
     * @return full name of person
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *  Method for setting value of field fullName
     * @param fullName - full name of person
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * Method for getting value of field birthDay
     * @return value of person's birthday
     */
    public LocalDate getBirthDay() {
        return birthDay;
    }

    /**
     * Method for setting value of field birthDay
     * @param birthDay person's birthday
     */
    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * Method for getting value of field gender
     * @return person's gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Method for setting value of field gender
     * @param gender - person's gender
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * Method for getting value of field passportNumber
     * @return field contain passport number of person
     */
    public int getPassportNumber() {
        return passportNumber;
    }

    /**
     * Method for setting value of field passportNumber
     * @param passportNumber - passport number of person
     */
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    /**
     * Method for getting value of field passportSeries
     * @return series of passport of person
     */
    public int getPassportSeries() {
        return passportSeries;
    }

    /**
     * Method for setting value of field passportSeries
     * @param passportSeries - series of passport
     */
    public void setPassportSeries(int passportSeries) {
        this.passportSeries = passportSeries;
    }

    /**
     * Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", birthDay=" + birthDay +
                ", gender=" + gender +
                ", passportNumber=" + passportNumber +
                ", passportSeries=" + passportSeries +
                '}';
    }
}
