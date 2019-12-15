package com.iplseason.comparator;

import com.iplseason.iplmodel.IplMostRunsData;

import java.util.Comparator;

public class SixesComparator implements Comparator<IplMostRunsData> {
    @Override
    public int compare(IplMostRunsData object1, IplMostRunsData object2) {
        return (int) (object2.getSixes() - object1.getSixes());

    }
}
