package com.iplsession;

import com.iplseason.IPLMatchAnalyserException;
import com.iplseason.analyser.FieldType;
import com.iplseason.analyser.IPLMatchesAnalyzer;
import com.iplseason.comparator.FoursComparator;
import com.iplseason.comparator.SixesComparator;
import com.iplseason.comparator.StrikeRateComparator;
import com.iplseason.iplmodel.IplMostRunsData;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPL2019SessionTest {

    private String IPL_MATCH_RUNS_DATA = "/home/lucky/IdeaProjects/IPLMatches-Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String WRONG_IPL_MATCH_DATA = "/home/lucky/IdeaProjects/IPLMatches-Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";
    private String EmptyIPL_MATCH_DATA = "/home/lucky/IdeaProjects/IPLMatches-Analyser/src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIPL2019FactSheetsMostRuns_WhenBindedCorrectly_ThenShould_ReturnTotalRecords() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        int result = 0;
        try {
            result = iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            Assert.assertEquals(101, result);
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetsMostRuns_WhenWrongDelimeter_ThenShould_ThrowIPLAnalyserException() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            int result = iplMatchesAnalyzer.loadIplMatchesData(WRONG_IPL_MATCH_DATA);
            Assert.assertEquals(101, result);
        } catch (IPLMatchAnalyserException e) {
            Assert.assertEquals(IPLMatchAnalyserException.ExceptionType.WRONG_DELIMETER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenIPL2019FactSheetsMostRuns_WhenEmptyFile_ThenShouldThrow_IPLAnalyserException() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        int result = 0;
        try {
            result = iplMatchesAnalyzer.loadIplMatchesData(EmptyIPL_MATCH_DATA);
            Assert.assertEquals(101, result);
        } catch (IPLMatchAnalyserException e) {
            Assert.assertEquals(IPLMatchAnalyserException.ExceptionType.WRONG_DELIMETER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenWrongHeader_ShouldThrowIPLMatchAnalyserException() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        int result = 0;
        try {
            result = iplMatchesAnalyzer.loadIplMatchesData(WRONG_IPL_MATCH_DATA);
            Assert.assertEquals(101, result);
        } catch (IPLMatchAnalyserException e) {
            Assert.assertEquals(IPLMatchAnalyserException.ExceptionType.WRONG_DELIMETER_OR_HEADER, e.type);
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByAverage_Should_ReturnMS_DhoniAsFirstPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.AVERAGE);
            Assert.assertEquals("MS Dhoni", list.get(0).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByAverage_Should_ReturnTimSoutheeAsLarstPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.AVERAGE);
            Assert.assertEquals("Tim Southee", list.get(list.size() - 1).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByStrikeRate_Should_ReturnIshantSharmaAsLarstPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.STRIKERATE);
            Assert.assertEquals("Ishant Sharma", list.get(0).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByStrikeRate_Should_ReturnPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.STRIKERATE);
            Assert.assertEquals("Bhuvneshwar Kumar", list.get(list.size() - 1).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByMost6sAns4s_ThenShould_ReturnTim_Southee_AsLarstPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.STRIKERATE, FieldType.AVERAGE);
            Assert.assertEquals("Tim Southee", list.get(list.size() - 1).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByMost6sAns4s_ThenShould_ReturnAndre_Russell_AsFirstPlayerInList() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(FieldType.STRIKERATE, FieldType.AVERAGE);
            Assert.assertEquals("Andre Russell", list.get(0).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIPL2019FactSheetMostRuns_WhenSortedByBestStrikeRatesWith_6sAnd4s_ThenShould_ReturnSortedListAsResult() {
        IPLMatchesAnalyzer iplMatchesAnalyzer = new IPLMatchesAnalyzer();
        StrikeRateComparator rateComparator = new StrikeRateComparator();
        FoursComparator foursComparator = new FoursComparator();
        SixesComparator sixesComparator = new SixesComparator();
        try {
            iplMatchesAnalyzer.loadIplMatchesData(IPL_MATCH_RUNS_DATA);
            List<IplMostRunsData> list = iplMatchesAnalyzer.getSortedList(rateComparator, sixesComparator, foursComparator);
            Assert.assertEquals("Ishant Sharma", list.get(list.size()-1).playerName.trim());
        } catch (IPLMatchAnalyserException e) {
            e.printStackTrace();
        }

    }
}
