package com.netcracker.utils.sort;

import com.netcracker.contracts.Contract;
import java.util.Comparator;

/**
 * class allow use bubble sort for sorting repository
 */


public class BubbleSorter implements Sorter {

    /**
     * Method realize bubble sort for array by the special parameter
     * @param data - array that contain data for sorting
     * @param comparator parameter for sorting by
     * @return sorted array
     */
    @Override
    public Object[] sort(Object[] data, Comparator<Contract> comparator) {
        boolean sorted = false;
        Contract sortedData;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < data.length - 1; i++) {
                if (comparator.compare((Contract)data[i], (Contract)data[i + 1]) >= 1) {
                    sorted = false;
                    sortedData = (Contract)data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = sortedData;

                }
            }
        }
        return data;
    }

}
