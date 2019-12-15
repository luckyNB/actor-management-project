package com.iplseason.comparator;

import com.iplseason.iplmodel.IplMostRunsData;

import java.util.Comparator;

public class StrikeRateComparator implements Comparator<IplMostRunsData> {
    @Override
    public int compare(IplMostRunsData object1, IplMostRunsData object2) {
        return (int) (object2.getStrikeRate() - object1.getStrikeRate());

    }
}
