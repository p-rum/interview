package cz.exampleproject.mediagroup.hw.gpcparser.exception;

import java.io.IOException;


public class WrongDataFormatException extends IOException {

	public WrongDataFormatException (String message) {
		super(message);
	}
}
