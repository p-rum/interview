package cz.exampleproject.mediagroup.hw.gpcparser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 * The type Transaction.
 */
@Document
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
		return "Transaction{" +
				"variableCode='" + variableCode + '\'' +
				", counterpartyBankCode='" + counterpartyBankCode + '\'' +
				", constantCode='" + constantCode + '\'' +
				", specificCode='" + specificCode + '\'' +
				", valueDate='" + valueDate + '\'' +
				", transactionDescription='" + transactionDescription + '\'' +
				", currencyCode='" + currencyCode + '\'' +
				", postingDate='" + postingDate + '\'' +
				", accountNumber='" + accountNumber + '\'' +
				", counterpartyAccountNumber='" + counterpartyAccountNumber + '\'' +
				", transactionIdentifier='" + transactionIdentifier + '\'' +
				", transactionAmount='" + transactionAmount + '\'' +
				", accountingType=" + accountingType +
				", transactionIdentification='" + transactionIdentification + '\'' +
				", dateOfDebitingFromCounterparty='" + dateOfDebitingFromCounterparty + '\'' +
				", comment='" + comment + '\'' +
				", mixedInfo1='" + mixedInfo1 + '\'' +
				", mixedInfo2='" + mixedInfo2 + '\'' +
				", mixedInfo3='" + mixedInfo3 + '\'' +
				", mixedInfo4='" + mixedInfo4 + '\'' +
				", mixedInfo5='" + mixedInfo5 + '\'' +
				", mixedInfo6='" + mixedInfo6 + '\'' +
				'}';
	}

	/**
	 * Gets account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber ( ) {
		return accountNumber;
	}

	/**
	 * Sets account number.
	 *
	 * @param accountNumber the account number
	 */
	public void setAccountNumber (String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets transaction identifier.
	 *
	 * @return the transaction identifier
	 */
	public String getTransactionIdentifier ( ) {
		return transactionIdentifier;
	}

	/**
	 * Sets transaction identifier.
	 *
	 * @param transactionIdentifier the transaction identifier
	 */
	public void setTransactionIdentifier (String transactionIdentifier) {
		this.transactionIdentifier = transactionIdentifier;
	}

	@Id
	private String transactionIdentifier;
	@Field
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

	/**
	 * Gets mixed info 1.
	 *
	 * @return the mixed info 1
	 */
	public String getMixedInfo1 ( ) {
		return mixedInfo1;
	}

	/**
	 * Sets mixed info 1.
	 *
	 * @param mixedInfo1 the mixed info 1
	 */
	public void setMixedInfo1 (String mixedInfo1) {
		this.mixedInfo1 = mixedInfo1;
	}

	/**
	 * Gets mixed info 2.
	 *
	 * @return the mixed info 2
	 */
	public String getMixedInfo2 ( ) {
		return mixedInfo2;
	}

	/**
	 * Sets mixed info 2.
	 *
	 * @param mixedInfo2 the mixed info 2
	 */
	public void setMixedInfo2 (String mixedInfo2) {
		this.mixedInfo2 = mixedInfo2;
	}

	/**
	 * Gets mixed info 3.
	 *
	 * @return the mixed info 3
	 */
	public String getMixedInfo3 ( ) {
		return mixedInfo3;
	}

	/**
	 * Sets mixed info 3.
	 *
	 * @param mixedInfo3 the mixed info 3
	 */
	public void setMixedInfo3 (String mixedInfo3) {
		this.mixedInfo3 = mixedInfo3;
	}

	/**
	 * Gets mixed info 4.
	 *
	 * @return the mixed info 4
	 */
	public String getMixedInfo4 ( ) {
		return mixedInfo4;
	}

	/**
	 * Sets mixed info 4.
	 *
	 * @param mixedInfo4 the mixed info 4
	 */
	public void setMixedInfo4 (String mixedInfo4) {
		this.mixedInfo4 = mixedInfo4;
	}

	/**
	 * Gets mixed info 5.
	 *
	 * @return the mixed info 5
	 */
	public String getMixedInfo5 ( ) {
		return mixedInfo5;
	}

	/**
	 * Sets mixed info 5.
	 *
	 * @param mixedInfo5 the mixed info 5
	 */
	public void setMixedInfo5 (String mixedInfo5) {
		this.mixedInfo5 = mixedInfo5;
	}

	/**
	 * Gets mixed info 6.
	 *
	 * @return the mixed info 6
	 */
	public String getMixedInfo6 ( ) {
		return mixedInfo6;
	}

	/**
	 * Sets mixed info 6.
	 *
	 * @param mixedInfo6 the mixed info 6
	 */
	public void setMixedInfo6 (String mixedInfo6) {
		this.mixedInfo6 = mixedInfo6;
	}

	/**
	 * Gets variable code.
	 *
	 * @return the variable code
	 */
	public String getVariableCode ( ) {
		return variableCode;
	}

	/**
	 * Sets variable code.
	 *
	 * @param variableCode the variable code
	 */
	public void setVariableCode (String variableCode) {
		this.variableCode = variableCode;
	}

	/**
	 * Gets counterparty bank code.
	 *
	 * @return the counterparty bank code
	 */
	public String getCounterpartyBankCode ( ) {
		return counterpartyBankCode;
	}

	/**
	 * Sets counterparty bank code.
	 *
	 * @param counterpartyBankCode the counterparty bank code
	 */
	public void setCounterpartyBankCode (String counterpartyBankCode) {
		this.counterpartyBankCode = counterpartyBankCode;
	}

	/**
	 * Gets constant code.
	 *
	 * @return the constant code
	 */
	public String getConstantCode ( ) {
		return constantCode;
	}

	/**
	 * Sets constant code.
	 *
	 * @param constantCode the constant code
	 */
	public void setConstantCode (String constantCode) {
		this.constantCode = constantCode;
	}

	/**
	 * Gets specific code.
	 *
	 * @return the specific code
	 */
	public String getSpecificCode ( ) {
		return specificCode;
	}

	/**
	 * Sets specific code.
	 *
	 * @param specificCode the specific code
	 */
	public void setSpecificCode (String specificCode) {
		this.specificCode = specificCode;
	}

	/**
	 * Gets value date.
	 *
	 * @return the value date
	 */
	public LocalDate getValueDate ( ) {
		return valueDate;
	}

	/**
	 * Sets value date.
	 *
	 * @param valueDate the value date
	 */
	public void setValueDate (LocalDate valueDate) {
		this.valueDate = valueDate;
	}

	/**
	 * Gets transaction description.
	 *
	 * @return the transaction description
	 */
	public String getTransactionDescription ( ) {
		return transactionDescription;
	}

	/**
	 * Sets transaction description.
	 *
	 * @param transactionDescription the transaction description
	 */
	public void setTransactionDescription (String transactionDescription) {
		this.transactionDescription = transactionDescription;
	}

	/**
	 * Gets currency code.
	 *
	 * @return the currency code
	 */
	public String getCurrencyCode ( ) {
		return currencyCode;
	}

	/**
	 * Sets currency code.
	 *
	 * @param currencyCode the currency code
	 */
	public void setCurrencyCode (String currencyCode) {
		this.currencyCode = currencyCode;
	}

	/**
	 * Gets posting date.
	 *
	 * @return the posting date
	 */
	public LocalDate getPostingDate ( ) {
		return postingDate;
	}

	/**
	 * Sets posting date.
	 *
	 * @param postingDate the posting date
	 */
	public void setPostingDate (LocalDate postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * Gets counterparty account number.
	 *
	 * @return the counterparty account number
	 */
	public String getCounterpartyAccountNumber ( ) {
		return counterpartyAccountNumber;
	}

	/**
	 * Sets counterparty account number.
	 *
	 * @param counterpartyAccountNumber the counterparty account number
	 */
	public void setCounterpartyAccountNumber (String counterpartyAccountNumber) {
		this.counterpartyAccountNumber = counterpartyAccountNumber;
	}

	/**
	 * Gets transaction amount.
	 *
	 * @return the transaction amount
	 */
	public BigDecimal getTransactionAmount ( ) {
		return transactionAmount;
	}

	/**
	 * Sets transaction amount.
	 *
	 * @param transactionAmount the transaction amount
	 */
	public void setTransactionAmount (BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount.movePointLeft(2);
	}

	/**
	 * Gets accounting type.
	 *
	 * @return the accounting type
	 */
	public String getAccountingType ( ) {
		return accountingType;
	}

	/**
	 * Sets accounting type.
	 *
	 * @param accountingType the accounting type
	 */
	public void setAccountingType (String accountingType) {
		this.accountingType = accountingType;
	}

	/**
	 * Gets transaction identification.
	 *
	 * @return the transaction identification
	 */
	public String getTransactionIdentification ( ) {
		return transactionIdentification;
	}

	/**
	 * Sets transaction identification.
	 *
	 * @param transactionIdentification the transaction identification
	 */
	public void setTransactionIdentification (String transactionIdentification) {
		this.transactionIdentification = transactionIdentification;
	}

	/**
	 * Gets date of debiting from counterparty.
	 *
	 * @return the date of debiting from counterparty
	 */
	public LocalDate getDateOfDebitingFromCounterparty ( ) {
		return dateOfDebitingFromCounterparty;
	}

	/**
	 * Sets date of debiting from counterparty.
	 *
	 * @param dateOfDebitingFromCounterparty the date of debiting from counterparty
	 */
	public void setDateOfDebitingFromCounterparty (LocalDate dateOfDebitingFromCounterparty) {
		this.dateOfDebitingFromCounterparty = dateOfDebitingFromCounterparty;
	}

	/**
	 * Gets comment.
	 *
	 * @return the comment
	 */
	public String getComment ( ) {
		return comment;
	}

	/**
	 * Sets comment.
	 *
	 * @param comment the comment
	 */
	public void setComment (String comment) {
		this.comment = comment;
	}
}
