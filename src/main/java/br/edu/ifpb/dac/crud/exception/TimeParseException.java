package br.edu.ifpb.dac.crud.exception;

public class TimeParseException extends Exception {

	public TimeParseException(String date) {
		super("Não foi possível converter a data " + date);
	}
}
