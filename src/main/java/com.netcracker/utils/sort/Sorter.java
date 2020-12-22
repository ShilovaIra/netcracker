package com.netcracker.utils.sort;

import com.netcracker.contracts.Contract;
import java.util.Comparator;

public interface Sorter {

    /**
     * Method sort allow to sort values that contain in array
     * @param data - array that contain data
     */
    Object[] sort(Object[] data, Comparator<Contract> comparator);
}
