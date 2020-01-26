package cz.exampleproject.mediagroup.hw.gpcparser.controller;

import cz.exampleproject.mediagroup.hw.gpcparser.PaymentRepository;
import cz.exampleproject.mediagroup.hw.gpcparser.exception.BadFormatException;
import cz.exampleproject.mediagroup.hw.gpcparser.parser.gpc.GPCParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class ParserController {

	@Autowired
	GPCParser parser;
	@Autowired
	PaymentRepository repository;

	@PostMapping(path = "/GPC/parseFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, params = "file")
	public void parsePayment (@RequestParam("file") String file) throws IOException {
		repository.save(parser.parseFile(file));
	}

	@PostMapping(path = "/GPC/parseText", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void parsePaymentRaw (String text) throws BadFormatException {
		repository.save(parser.parseText(text));
	}

	@DeleteMapping(path = "/delete/{paymentId}")
	public void deletePayment (@PathVariable("paymentId") String paymentId) {
		repository.deleteById(paymentId);
	}

}
