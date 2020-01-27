package cz.exampleproject.mediagroup.hw.gpcparser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


public class Transaction implements Serializable {

	@Override
	public int hashCode ( ) {
		return new HashCodeBuilder(17, 37)
				.append(getAccountNumber())
				.append(getTransactionIdentifier())
				.toHashCode();
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Transaction that = (Transaction) o;
		return new EqualsBuilder()
				.append(getAccountNumber(), that.getAccountNumber())
				.append(getTransactionIdentifier(), that.getTransactionIdentifier())
				.isEquals();
	}

	@Override
	public String toString ( ) {
		return "Transaction:{" +
				"variableCode:" + variableCode + ",\n" +
				"counterpartyBankCode:" + counterpartyBankCode + ",\n" +
				"constantCode:" + constantCode + ",\n" +
				"specificCode:" + specificCode + ",\n" +
				"valueDate:" + valueDate + ",\n" +
				"transactionDescription:" + transactionDescription + ",\n" +
				"currencyCode:" + currencyCode + ",\n" +
				"postingDate:" + postingDate + ",\n" +
				"accountNumber:" + accountNumber + ",\n" +
				"counterpartyAccountNumber:" + counterpartyAccountNumber + ",\n" +
				"transactionIdentifier:" + transactionIdentifier + ",\n" +
				"transactionAmount:" + transactionAmount + ",\n" +
				"accountingType=" + accountingType +
				"transactionIdentification:" + transactionIdentification + ",\n" +
				"dateOfDebitingFromCounterparty:" + dateOfDebitingFromCounterparty + ",\n" +
				"comment:" + comment + ",\n" +
				"mixedInfo1:" + mixedInfo1 + ",\n" +
				"mixedInfo2:" + mixedInfo2 + ",\n" +
				"mixedInfo3:" + mixedInfo3 + ",\n" +
				"mixedInfo4:" + mixedInfo4 + ",\n" +
				"mixedInfo5:" + mixedInfo5 + ",\n" +
				"mixedInfo6:" + mixedInfo6 + "\n" +
				"}";
	}

	public String getAccountNumber ( ) {
		return accountNumber;
	}

	public void setAccountNumber (String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTransactionIdentifier ( ) {
		return transactionIdentifier;
	}

	public void setTransactionIdentifier (String transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
	}
	private String transactionIdentifier;
	private String variableCode;
	private String counterpartyBankCode;
	private String constantCode;
	private String specificCode;
	private LocalDate valueDate;
	private String transactionDescription;
	private String currencyCode;
	private LocalDate postingDate;
	private String accountNumber;
	private String counterpartyAccountNumber;
	private BigDecimal transactionAmount;
	private String accountingType;
	private String transactionIdentification;
	private LocalDate dateOfDebitingFromCounterparty;
	private String comment;
	private String mixedInfo1;
	private String mixedInfo2;
	private String mixedInfo3;
	private String mixedInfo4;
	private String mixedInfo5;
	private String mixedInfo6;

	public String getMixedInfo1 ( ) {
		return mixedInfo1;
	}

	public void setMixedInfo1 (String mixedInfo1) {
		this.mixedInfo1 = mixedInfo1;
	}

	public String getMixedInfo2 ( ) {
		return mixedInfo2;
	}

	public void setMixedInfo2 (String mixedInfo2) {
		this.mixedInfo2 = mixedInfo2;
	}

	public String getMixedInfo3 ( ) {
		return mixedInfo3;
	}

	public void setMixedInfo3 (String mixedInfo3) {
		this.mixedInfo3 = mixedInfo3;
	}

	public String getMixedInfo4 ( ) {
		return mixedInfo4;
	}

	public void setMixedInfo4 (String mixedInfo4) {
		this.mixedInfo4 = mixedInfo4;
	}

	public String getMixedInfo5 ( ) {
		return mixedInfo5;
	}

	public void setMixedInfo5 (String mixedInfo5) {
		this.mixedInfo5 = mixedInfo5;
	}

	public String getMixedInfo6 ( ) {
		return mixedInfo6;
	}

	public void setMixedInfo6 (String mixedInfo6) {
		this.mixedInfo6 = mixedInfo6;
	}

	public String getVariableCode ( ) {
		return variableCode;
	}

	public void setVariableCode (String variableCode) {
		this.variableCode = variableCode;
	}

	public String getCounterpartyBankCode ( ) {
		return counterpartyBankCode;
	}

	public void setCounterpartyBankCode (String counterpartyBankCode) {
		this.counterpartyBankCode = counterpartyBankCode;
	}

	public String getConstantCode ( ) {
		return constantCode;
	}

	public void setConstantCode (String constantCode) {
		this.constantCode = constantCode;
	}

	public String getSpecificCode ( ) {
		return specificCode;
	}

	public void setSpecificCode (String specificCode) {
		this.specificCode = specificCode;
	}

	public LocalDate getValueDate ( ) {
		return valueDate;
	}

	public void setValueDate (LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	public String getTransactionDescription ( ) {
		return transactionDescription;
	}

	public void setTransactionDescription (String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	public String getCurrencyCode ( ) {
		return currencyCode;
	}

	public void setCurrencyCode (String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public LocalDate getPostingDate ( ) {
		return postingDate;
	}

	public void setPostingDate (LocalDate postingDate) {
		this.postingDate = postingDate;
	}

	public String getCounterpartyAccountNumber ( ) {
		return counterpartyAccountNumber;
	}

	public void setCounterpartyAccountNumber (String counterpartyAccountNumber) {
		this.counterpartyAccountNumber = counterpartyAccountNumber;
	}

	public BigDecimal getTransactionAmount ( ) {
		return transactionAmount;
	}

	public void setTransactionAmount (BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount.movePointLeft(2);
	}

	public String getAccountingType ( ) {
		return accountingType;
	}

	public void setAccountingType (String accountingType) {
		this.accountingType = accountingType;
	}

	public String getTransactionIdentification ( ) {
		return transactionIdentification;
	}

	public void setTransactionIdentification (String transactionIdentification) {
		this.transactionIdentification = transactionIdentification;
	}

	public LocalDate getDateOfDebitingFromCounterparty ( ) {
		return dateOfDebitingFromCounterparty;
	}

	public void setDateOfDebitingFromCounterparty (LocalDate dateOfDebitingFromCounterparty) {
		this.dateOfDebitingFromCounterparty = dateOfDebitingFromCounterparty;
	}

	public String getComment ( ) {
		return comment;
	}

	public void setComment (String comment) {
		this.comment = comment;
	}
}
