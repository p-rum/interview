package cz.exampleproject.mediagroup.hw.gpcparser.controller;

import cz.exampleproject.mediagroup.hw.gpcparser.PaymentRepository;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;
import cz.exampleproject.mediagroup.hw.gpcparser.parser.gpc.GPCParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.InputStream;


/**
 * Controller for adding new Payments, only CREATES new document, if exists, exception is thrown
 */

@Controller
public class PaymentController {

	@Autowired
	PaymentRepository paymentRepository;

	@Autowired
	GPCParser parser;

	@PostMapping(path = "/addpayment", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Payment> addPayment (InputStream file) {
		Payment payment;
		try {
			payment = paymentRepository.insert(parser.parseFile(file));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.ok(payment);
	}
}
