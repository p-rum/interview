package cz.exampleproject.mediagroup.hw.gpcparser.exception;

public class BadFormatException extends Exception {

	private static final String MESSAGE = "Wrong format of %s. Exiting.";

	@SuppressWarnings("rawtypes")
	public BadFormatException (Class clazz) {
		super(String.format(MESSAGE, clazz.getSimpleName()));

	}
}
