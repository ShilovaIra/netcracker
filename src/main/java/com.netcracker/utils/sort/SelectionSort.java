package com.netcracker.utils.sort;

import com.netcracker.contracts.Contract;
import java.util.Comparator;

/**
 * class allow use selection sort for sorting repository
 */


public class SelectionSort implements Sorter {

    /**
     * Method realize selection sort for array by the special parameter
     * @param data - array that contain data for sorting
     * @param comparator parameter for sorting by
     * @return sorted array
     */
    @Override
    public Object[] sort(Object[] data, Comparator<Contract> comparator) {

            for (int i = 0; i < data.length; i++) {
                Contract min =(Contract) data[i];
                int minId = i;
                for (int j = i+1; j < data.length; j++) {
                    if (comparator.compare(min, (Contract) data[i]) >= 1) {
                        min = (Contract) data[j];
                        minId = j;
                    }
                }
                Contract temp =(Contract) data[i];
                data[i] = min;
                data[minId] = temp;
            }
            return data;
    }
}
