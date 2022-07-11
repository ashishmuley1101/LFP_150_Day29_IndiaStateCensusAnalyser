package com.bridgelab.indiacensusanalyser;

public class CensusAnalyserException extends Throwable {

	private final String message;
    private ExceptionType type;

    enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }

    public CensusAnalyserException(String message, ExceptionType type) {
        this.message = message;
        this.setType(type);
    }

	public ExceptionType getType() {
		return type;
	}

	public void setType(ExceptionType type) {
		this.type = type;
	}
}
