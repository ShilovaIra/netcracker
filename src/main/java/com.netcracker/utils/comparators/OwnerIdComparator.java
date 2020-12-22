package com.netcracker.utils.comparators;

import com.netcracker.contracts.Contract;
import java.util.Comparator;

/**
 * Class allow using comparator to sorting repository by the special parameter - owner id
 */
public class OwnerIdComparator implements Comparator<Contract> {
    @Override
    /**
     * Method for comparing parameters
     * @param firstContract first parameter for comparing
     * @param secondContract second parameter for comparing
     * @return integer value 1, if first parameter larger than second, or integer value 0 if parameters are equal, else -1
     */
    public int compare(Contract firstContract, Contract secondContract) {
        if (firstContract.getOwner().getId() > secondContract.getOwner().getId())
            return 1;
        else if (firstContract.getOwner().getId() < secondContract.getOwner().getId())
            return -1;
        else
            return 0;
    }
}
