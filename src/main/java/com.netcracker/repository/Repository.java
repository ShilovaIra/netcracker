package com.netcracker.repository;


import com.netcracker.contracts.Contract;
import com.netcracker.utils.sort.Sorter;
import com.netcracker.utils.reflection.AutoInjectable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 * public class for creating objects Repository of contracts with special parameters
 */
public class Repository {

    /**
     * field contract is an array which contain objects of Contract class
     */
   private Contract[] contract = new Contract[1];

    /**
     * Object for performed sorting in repository
     */
    @AutoInjectable
   private Sorter sorter;

    /**
     * field size contain the size of repository - number of contracts, which contain in it.
     * Default value is 0
     */
   private int size;


    /**
     * Constructor for creating repository with special parameters
     * @param contract is a contract which need to be include in repository
     * @param size - starting size of repository
     */
    public Repository(Contract[] contract, int size) {
        this.contract = contract;
        this.size = size;
    }

    /**
     * Constructor for creating repository without parameters
     */
    public Repository() {
    }

    /**
     * Method for getting contract searched by id
     * @param id  is an unique identifier for contract
     * @return contract with designated id ,
     * if contract could not found then
     * @return null value
     */
    public Contract getContract(int id) {
        for (Contract c : contract) {
            if (c.getId() == id) {
                System.out.println(c.toString());
                return c;
            }
        }
        return null;
    }

    /**
     * Method for deleting contract by id
     * @param id is an unique identifier for contract
     */
    public void delete (int id) {
        for (int i = 0; i < this.contract.length; i++) {
            if (this.contract[i].getId() == id) {
                for (int j = i; j < contract.length - 1; j++) {
                    contract[j] = contract[j + 1];
                }
                size--;
                contract[contract.length - 1] = null;
                break;
            }
        }
    }

    /**
     * Method for getting size of repository
     * @return current size of repository
     */
    public int getSize() {
        return size;
    }


    /**
     * Method for adding new contract in repository
     * @param c - is a contract which need to be added in repository
     */
    public void add (Contract c) {
        if (this.contract.length == size) {
            Contract[] newContract = new Contract[size+4];
            System.arraycopy(contract, 0, newContract, 0, size);
            contract = newContract;
        }
        this.contract[size] = c;
        size++;
    }

    /**
     * Method for sorting contracts in repository by the special parameter
     * @param comparator it is a field for sorting contracts in repository
     */
    public void sort (Comparator<Contract> comparator) {

        sorter.sort(this.contract, comparator);
    }

    /**
     * Method allow find contracts by the condition
     * @param predicate condition for searching in repository
     * @return repository which contain suitable contracts
     */
    public Repository searchBy(Predicate<Contract> predicate){
        Repository result = new Repository();

        for(int i=0;i<this.size;i++){
            if (predicate.test(this.contract[i])){
                result.add(this.contract[i]);
            }
        }
        return result;
    }

    /**
     *Returns a string representation of the object like the specified array
     * @return a string representation of object
     */
    @Override
    public String toString() {
        return "Repository{" +
                "contract=" + Arrays.toString(contract) +
                ", size=" + size +
                '}';
    }
}
