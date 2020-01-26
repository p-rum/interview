package cz.exampleproject.mediagroup.hw.gpcparser.controller;

import cz.exampleproject.mediagroup.hw.gpcparser.PaymentRepository;
import cz.exampleproject.mediagroup.hw.gpcparser.exception.BadFormatException;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;
import cz.exampleproject.mediagroup.hw.gpcparser.gpc.parser.GPCParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace.Response;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;


@Controller
public class ParserController {

	@Autowired
	GPCParser parser;
	@Autowired
	PaymentRepository repository;

	@PostMapping(path = "/GPC/parseFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, params = "file")
	public Payment parsePayment (@RequestParam("file") String file) throws IOException {
		return repository.save(parser.parseFile(file));

	}

	@PostMapping(path = "/GPC/parse", consumes = MediaType.TEXT_PLAIN_VALUE, params = "text")
	public Response parsePaymentRaw (@RequestBody String text) throws BadFormatException {
		repository.save(parser.parseText(text));
		return new Response(200, null);
	}

	@DeleteMapping(path = "/delete/{paymentId}")
	public Response deletePayment (@PathVariable("paymentId") String paymentId) {
		repository.deleteById(paymentId);
		return new Response(200, new HashMap<>());
	}

}
