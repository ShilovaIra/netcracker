package com.netcracker.utils.comparators;

import com.netcracker.contracts.Contract;
import java.util.Comparator;

/**
 * Class allow using comparator to sorting repository by the special parameter - contract id
 */
public class ContractIdComparator implements Comparator<Contract> {

    /**
     * Method for comparing parameters
     * @param firstContract first parameter for comparing
     * @param secondContract second parameter for comparing
     * @return integer value 1, if first parameter larger than second, or integer value 0 if parameters are equal, else -1
     */
    @Override
    public int compare(Contract firstContract, Contract secondContract) {
        if (firstContract.getId() > secondContract.getId())
            return 1;
        else if (firstContract.getId() < secondContract.getId())
            return -1;
        else
            return 0;
    }
}
