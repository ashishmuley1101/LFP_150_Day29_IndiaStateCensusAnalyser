package com.bridgelab.indiacensusanalyser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianCensusAnalyzer {

	public String PATH = "D:\\JavaPratice\\Day29\\resource\\IndiaStateCensusData.csv";
	
	public int loadIndiaCensusData() throws CensusAnalyserException {

		try {
			Reader reader = Files.newBufferedReader(Paths.get(PATH));
			CsvToBeanBuilder<IndiaCensusCSV> csvCsvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
			csvCsvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvCsvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}

	public static void main(String[] args) {
		System.out.println("******************Indian Census Analyzer******************");
		
		try {
			IndianCensusAnalyzer census = new IndianCensusAnalyzer();
			int records = census.loadIndiaCensusData();
			System.out.println(records+ " records in india state  census analyser csv file.");
		} catch (CensusAnalyserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}