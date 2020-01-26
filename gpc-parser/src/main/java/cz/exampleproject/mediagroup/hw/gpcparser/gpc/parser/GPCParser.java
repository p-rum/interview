package cz.exampleproject.mediagroup.hw.gpcparser.parser;

import cz.exampleproject.mediagroup.hw.gpcparser.config.AppConfigProperties;
import cz.exampleproject.mediagroup.hw.gpcparser.exception.BadFormatException;
import cz.exampleproject.mediagroup.hw.gpcparser.exception.FileException;
import cz.exampleproject.mediagroup.hw.gpcparser.parser.gpc.GPCPaymentDetails;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;
import cz.exampleproject.mediagroup.hw.gpcparser.model.Transaction;
import javafx.util.converter.BigDecimalStringConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Gpc parser.
 */
@Component
public class GPCParser implements Parser {

	@Override
	public Payment parseFile (String path) throws FileException {
		LOGGER.info(String.format("Parsing file: %s", path));
		try {
			FileInputStream stream = new FileInputStream(path);
			InputStreamReader streamReader = new InputStreamReader(stream, properties.getCharset());
			BufferedReader reader = new BufferedReader(streamReader);
			return parse(reader);
		} catch (FileNotFoundException e) {
			throw new FileException(String.format("File %s not found, please check, if you filled valid path", path));
		} catch (UnsupportedEncodingException ex) {
			throw new FileException(String.format("Wrong file encoding! (should be %s)", properties.getCharset()));
		} catch (BadFormatException | IOException e) {
			throw new FileException(e.getMessage());
		}
	}

	public Payment parseText (String inputStream) throws BadFormatException {
		try {
			StringReader inputStreamReader = new StringReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			return parse(reader);
		} catch (Exception ex) {
			throw new BadFormatException(inputStream.getClass());
		}
	}

	private Payment parse (BufferedReader reader) throws IOException, BadFormatException {
		Payment payment = parseLine074(reader.readLine());
		String s;
		List<Transaction> transactions = new ArrayList<>();
		while ((s = reader.readLine()) != null) {
			if (s.trim().isEmpty()) {
				continue;
			}
			String type = s.substring(0, 3);
			LOGGER.info(String.format("Parsing record type: %s", type));
			switch (type) {
				case "075":
					transactions.add(parseLine075(s));
					break;
				case "076":
					parseLine076(s, transactions.get(transactions.size() - 1));
					break;
				case "078":
					parseLine078(s, transactions.get(transactions.size() - 1));
					break;
				case "079":
					parseLine079(s, transactions.get(transactions.size() - 1));
				default:
					throw new BadFormatException(Payment.class);
			}
		}
		payment.setTransactions(transactions);
		LOGGER.debug(String.format("Parsing finished: \n %s", payment.toString()));
		return payment;
	}

	private Payment parseLine074 (String header) {
		Payment payment = new Payment();
		payment.setAccountNumber(parseString(header, GPCPaymentDetails.accountNumber));
		payment.setAccountOwner(parseString(header, GPCPaymentDetails.accountOwner));
		payment.setCreditSum(parseNumber(header, GPCPaymentDetails.creditSum).movePointLeft(2));
		payment.setDebetSum(parseNumber(header, GPCPaymentDetails.debetSum).movePointLeft(2));
		payment.setFinalAccountBalanceSign(parseString(header, GPCPaymentDetails.finalAccountBalanceSign));
		payment.setFirstAccountBalanceSign(parseString(header, GPCPaymentDetails.firstAccountBalanceSign));
		payment.setFinalAccountBalance(parseNumber(header, payment.getFinalAccountBalanceSign(),
				GPCPaymentDetails.finalAccountBalance).movePointLeft(2));
		payment.setFirstAccountBalance(parseNumber(header, payment.getFirstAccountBalanceSign(),
				GPCPaymentDetails.firstAccountBalance).movePointLeft(2));
		payment.setFromDate(parseDate(header, GPCPaymentDetails.fromDate));
		payment.setPaymentDate(parseDate(header, GPCPaymentDetails.paymentDate));
		payment.setId(StringUtils
				.trimLeadingCharacter(parseString(header, GPCPaymentDetails.paymentId), '0'));
		return payment;
	}

	private Transaction parseLine075 (String details) {
		Transaction transaction = new Transaction();
		transaction.setAccountNumber(parseString(details, GPCPaymentDetails.accountNumber));
		transaction.setAccountingType(parseString(details, GPCPaymentDetails.accountingType));
		transaction.setConstantCode(parseString(details, GPCPaymentDetails.constantCode));
		transaction.setCounterpartyAccountNumber(parseString(details, GPCPaymentDetails.counterpartyAccountNumber));
		transaction.setCounterpartyBankCode(parseString(details, GPCPaymentDetails.counterpartyBankCode));
		transaction.setCurrencyCode(parseString(details, GPCPaymentDetails.currencyCode));
		transaction.setPostingDate(parseDate(details, GPCPaymentDetails.postingDate));
		transaction.setSpecificCode(parseString(details, GPCPaymentDetails.specificCode));
		transaction.setTransactionDescription(parseString(details, GPCPaymentDetails.transactionDescription));
		transaction.setTransactionIdentifier(parseString(details, GPCPaymentDetails.transactionIdentifier));
		transaction.setValueDate(parseDate(details, GPCPaymentDetails.valueDate));
		transaction.setTransactionAmount(parseNumber(details, GPCPaymentDetails.transactionAmount));
		transaction.setVariableCode(parseString(details, GPCPaymentDetails.variableCode));
		return transaction;
	}

	private void parseLine076 (String details, Transaction transaction) {
		transaction.setTransactionIdentification(parseString(details, GPCPaymentDetails.transactionIdentification));
		transaction.setDateOfDebitingFromCounterparty(parseDate(details, GPCPaymentDetails.dateOfDebitingFromCounterparty));
		transaction.setComment(parseString(details, GPCPaymentDetails.comment));
	}

	private void parseLine078 (String details, Transaction transaction) {
		transaction.setMixedInfo1(parseString(details, GPCPaymentDetails.mixedTransactionInfo1));
		transaction.setMixedInfo2(parseString(details, GPCPaymentDetails.mixedTransactionInfo2));
		transaction.setMixedInfo3(parseString(details, GPCPaymentDetails.mixedTransactionInfo3));
	}

	private void parseLine079 (String details, Transaction transaction) {
		transaction.setMixedInfo4(parseString(details, GPCPaymentDetails.mixedTransactionInfo4));
		transaction.setMixedInfo5(parseString(details, GPCPaymentDetails.mixedTransactionInfo5));
		transaction.setMixedInfo6(parseString(details, GPCPaymentDetails.mixedTransactionInfo6));
	}

	private String parseString (String line, GPCPaymentDetails paymentDetails) {
		return line.substring(paymentDetails.start, paymentDetails.end);
	}

	private BigDecimal parseNumber (String line, GPCPaymentDetails paymentDetails) {
		BigDecimal decimal = bigDecimalConverter
				.fromString(StringUtils
						.trimLeadingCharacter(line
								.substring(paymentDetails.start, paymentDetails.end).trim(), '0'));
		if (decimal == null) {
			decimal = BigDecimal.ZERO;
		}
		return decimal;
	}

	private BigDecimal parseNumber (String line, String sign, GPCPaymentDetails paymentDetails) {
		BigDecimal number = parseNumber(line, paymentDetails);
		switch (sign) {
			case "+":
				return number;
			case "-":
				return number.negate();
			default:
				throw new IllegalArgumentException();
		}
	}

	private LocalDate parseDate (String line, GPCPaymentDetails paymentDetails) {
		String date = line.substring(paymentDetails.start, paymentDetails.end);
		return LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyy"));
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(GPCParser.class);
	private static final BigDecimalStringConverter bigDecimalConverter = new BigDecimalStringConverter();

	@Autowired
	AppConfigProperties properties;
}

