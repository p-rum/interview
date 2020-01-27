package cz.exampleproject.mediagroup.hw.gpcparser.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;


@Document
public class Payment implements Serializable {

	@Override
	public int hashCode ( ) {
		return new HashCodeBuilder(17, 37)
				.append(getId())
				.append(getAccountNumber())
				.append(getAccountOwner())
				.toHashCode();
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Payment payment = (Payment) o;
		return new EqualsBuilder()
				.append(getId(), payment.getId())
				.append(getAccountNumber(), payment.getAccountNumber())
				.append(getAccountOwner(), payment.getAccountOwner())
				.isEquals();
	}

	@Override
	public String toString ( ) {
		return "Payment{" +
				"paymentId:" + id + '\n' +
				", accountNumber:" + accountNumber + '\n' +
				", accountOwner:" + accountOwner + '\n' +
				", fromDate:" + fromDate + '\n' +
				", paymentDate:" + paymentDate + '\n' +
				", firstAccountBalance:" + firstAccountBalance + '\n' +
				", finalAccountBalance:" + finalAccountBalance + '\n' +
				", debetSum:" + debetSum + '\n' +
				", creditSum:" + creditSum + '\n' +
				", transactions: { \n" + serializeTransactions() +
				'}';
	}

	private String serializeTransactions ( ) {
		return transactions.stream().map(Transaction::toString).collect(Collectors.joining());
	}

	public String getId ( ) {
		return id;
	}

	public void setId (String id) {
		this.id = id;

	}

	public String getAccountNumber ( ) {
		return accountNumber;
	}

	public void setAccountNumber (String accountNumber) {
		this.accountNumber = accountNumber;

	}

	public String getAccountOwner ( ) {
		return accountOwner;
	}

	public void setAccountOwner (String accountOwner) {
		this.accountOwner = accountOwner;

	}

	@Id
	private String id;
	private String accountNumber;
	private String accountOwner;
	@DateTimeFormat
	private LocalDate fromDate;
	private BigDecimal firstAccountBalance;
	private String firstAccountBalanceSign;
	private BigDecimal finalAccountBalance;
	private String finalAccountBalanceSign;
	private BigDecimal debetSum;
	private BigDecimal creditSum;
	private LocalDate paymentDate;

	@JsonSerialize
	private Collection<Transaction> transactions;

	public LocalDate getFromDate ( ) {
		return fromDate;
	}

	public void setFromDate (LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public BigDecimal getFirstAccountBalance ( ) {
		return firstAccountBalance;
	}

	public void setFirstAccountBalance (BigDecimal firstAccountBalance) {
		this.firstAccountBalance = firstAccountBalance;
	}

	public String getFirstAccountBalanceSign ( ) {
		return firstAccountBalanceSign;
	}

	public void setFirstAccountBalanceSign (String firstAccountBalanceSign) {
		this.firstAccountBalanceSign = firstAccountBalanceSign;
	}

	public BigDecimal getFinalAccountBalance ( ) {
		return finalAccountBalance;
	}

	public void setFinalAccountBalance (BigDecimal finalAccountBalance) {
		this.finalAccountBalance = finalAccountBalance;
	}

	public String getFinalAccountBalanceSign ( ) {
		return finalAccountBalanceSign;
	}

	public void setFinalAccountBalanceSign (String finalAccountBalanceSign) {
		this.finalAccountBalanceSign = finalAccountBalanceSign;
	}

	public BigDecimal getDebetSum ( ) {
		return debetSum;
	}

	public void setDebetSum (BigDecimal debetSum) {
		this.debetSum = debetSum;
	}

	public BigDecimal getCreditSum ( ) {
		return creditSum;
	}

	public void setCreditSum (BigDecimal creditSum) {
		this.creditSum = creditSum;
	}

	public LocalDate getPaymentDate ( ) {
		return paymentDate;
	}

	public void setPaymentDate (LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Collection<Transaction> getTransactions ( ) {
		return transactions;
	}

	public void setTransactions (Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
}
