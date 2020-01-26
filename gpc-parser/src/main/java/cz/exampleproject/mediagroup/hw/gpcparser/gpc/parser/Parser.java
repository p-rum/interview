package cz.exampleproject.mediagroup.hw.gpcparser.parser;

import cz.exampleproject.mediagroup.hw.gpcparser.exception.BadFormatException;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;

import java.io.IOException;


/**
 * Parser interface
 */
public interface Parser {

	Payment parseFile (String path) throws IOException;

	Payment parseText (String text) throws BadFormatException;
}
