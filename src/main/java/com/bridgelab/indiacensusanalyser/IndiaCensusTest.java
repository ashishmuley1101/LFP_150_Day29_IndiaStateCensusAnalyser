package com.bridgelab.indiacensusanalyser;

import org.junit.Assert;
import org.junit.Test;

public class IndiaCensusTest {

	private static final String INDIA_CENSUS_PATH_FILE = "D:\\JavaPratice\\Day29\\resource\\IndiaStateCensusData.csv";
	
	@Test
    public void givenIndiaCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecords() {
		IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
        try {
            int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_PATH_FILE);
            Assert.assertEquals(29, numOfRecord);
        } catch (CensusAnalyserException e) {

        }
    }
}