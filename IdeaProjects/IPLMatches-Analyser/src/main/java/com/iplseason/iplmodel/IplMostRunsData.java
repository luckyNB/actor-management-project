package com.iplseason.iplmodel;

import com.opencsv.bean.CsvBindByName;

public class IplMostRunsData {
    @CsvBindByName(column = "POS")
    public int position;
    @CsvBindByName(column = "PLAYER")
    public String playerName;
    @CsvBindByName(column = "Mat")
    public int matchesPlayed;
    @CsvBindByName(column = "Inns")
    public int innings;
    @CsvBindByName(column = "Runs")
    public int runs;
    @CsvBindByName(column = "Avg")
    public double average;
    @CsvBindByName(column = "4s")
    public int fours;
    @CsvBindByName(column = "6s")
    public int sixes;
    @CsvBindByName(column = "NO")
    public int notOut;
    @CsvBindByName(column = "HS")
    public int highestScore;
    @CsvBindByName(column = "BF")
    public int BF;
    @CsvBindByName(column = "SR")
    public double strikeRate;
    @CsvBindByName(column = "100s")
    public int centuries;
    @CsvBindByName(column = "50s")
    public int fifties;

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }

    public int getPosition() {
        return position;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public int getInnings() {
        return innings;
    }

    public int getRuns() {
        return runs;
    }

    public int getNotOut() {
        return notOut;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public int getBF() {
        return BF;
    }

    public double getStrikeRate() {
        return strikeRate;
    }

    public int getCenturies() {
        return centuries;
    }

    public int getFifties() {
        return fifties;
    }

    public double getAverage() {
        return average;
    }

    public IplMostRunsData() {
    }

    @Override
    public String toString() {
        return "IplMostRunsData{" +
                "position=" + position +
                ", playerName='" + playerName + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", innings=" + innings +
                ", runs=" + runs +
                ", average=" + average +
                ", fours=" + fours +
                ", sixes=" + sixes +
                ", notOut=" + notOut +
                ", highestScore=" + highestScore +
                ", BF=" + BF +
                ", strikeRate=" + strikeRate +
                ", centuries=" + centuries +
                ", fifties=" + fifties +
                '}';
    }
}
