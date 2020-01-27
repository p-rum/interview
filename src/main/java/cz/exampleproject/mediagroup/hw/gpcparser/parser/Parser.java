package cz.exampleproject.mediagroup.hw.gpcparser.parser;

import cz.exampleproject.mediagroup.hw.gpcparser.exception.WrongDataFormatException;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;

import java.io.InputStream;


/**
 * Parser interface
 */
public interface Parser {

	Payment parseFile (InputStream file) throws WrongDataFormatException;
}
