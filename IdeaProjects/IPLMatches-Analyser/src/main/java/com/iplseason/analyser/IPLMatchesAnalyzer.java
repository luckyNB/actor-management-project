package com.iplseason.analyser;

import com.bridgelabz.CSVBuilderException;
import com.bridgelabz.CSVBuilderFactory;
import com.bridgelabz.ICSVBuilder;
import com.iplseason.IPLMatchAnalyserException;
import com.iplseason.comparator.FoursComparator;
import com.iplseason.comparator.GroupBySorter;
import com.iplseason.comparator.SixesComparator;
import com.iplseason.comparator.StrikeRateComparator;
import com.iplseason.iplmodel.IplMostRunsData;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class IPLMatchesAnalyzer {

    List<IplMostRunsData> iplRunsList = null;
    Map<FieldType, Comparator> comparatorMap = null;
    Comparator<IplMostRunsData> iplMostRunsDataComparator = null;

    public IPLMatchesAnalyzer() {
        iplRunsList = new ArrayList<>();
        comparatorMap = new HashMap<>();
        comparatorMap.put(FieldType.AVERAGE, (iplMostRunsDataComparator = Comparator.comparing(iplMostRunsData -> iplMostRunsData.average)));
        comparatorMap.put(FieldType.STRIKERATE, iplMostRunsDataComparator = Comparator.comparing(iplMostRunsData -> iplMostRunsData.strikeRate));

    }

    public int loadIplMatchesData(String ipl_match_runs_data) throws IPLMatchAnalyserException {

        ICSVBuilder builder = CSVBuilderFactory.createCSVBuilder();
        try (Reader reader = Files.newBufferedReader(Paths.get(ipl_match_runs_data))) {
            Iterator<IplMostRunsData> csvFileIterator = builder.getCSVFileIterator(reader, IplMostRunsData.class);
            Iterable<IplMostRunsData> csvFileIterable = () -> csvFileIterator;
            StreamSupport.stream(csvFileIterable.spliterator(), false)
                    .forEach(iplMostRunsData -> iplRunsList.add(iplMostRunsData));

            int count = iplRunsList.size();
            return count;
        } catch (IOException e) {
            throw new IPLMatchAnalyserException("Error While Reading file", IPLMatchAnalyserException.ExceptionType.UNABLE_TO_PARSE);
        } catch (CSVBuilderException e) {
            throw new IPLMatchAnalyserException("Error While Binding CSV file", IPLMatchAnalyserException.ExceptionType.CSV_BIND_ERROR);
        } catch (RuntimeException e) {
            throw new IPLMatchAnalyserException("given delimeter or header", IPLMatchAnalyserException.ExceptionType.WRONG_DELIMETER_OR_HEADER);
        }
    }

    public List<IplMostRunsData> getSortedList(FieldType fieldType) {
        Comparator<IplMostRunsData> comparator = Comparator.comparing(data -> data.average);
        List<IplMostRunsData> sortedPlayer = (List<IplMostRunsData>) iplRunsList.stream()
                .sorted(this.comparatorMap.get(fieldType).reversed())
                .collect(Collectors.toList());
        sortedPlayer.forEach(System.out::print);
        return sortedPlayer;
    }

    public List<IplMostRunsData> getSortedList(FieldType fieldType, FieldType fieldType2) {
        Comparator<IplMostRunsData> comparator = Comparator.comparing(IplMostRunsData::getSixes, Comparator.reverseOrder()).thenComparing(IplMostRunsData::getFours, Comparator.reverseOrder());
        Collections.sort(iplRunsList, comparator);
        return iplRunsList;
    }


    public List<IplMostRunsData> getSortedList(Comparator<IplMostRunsData>... comparatorsList) {

        Collections.sort(iplRunsList, new GroupBySorter(comparatorsList[0], comparatorsList[1], comparatorsList[2]));
        return iplRunsList;
    }
}