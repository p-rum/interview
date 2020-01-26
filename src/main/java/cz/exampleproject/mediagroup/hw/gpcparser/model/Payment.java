package cz.exampleproject.mediagroup.hw.gpcparser.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;


/**
 * The type Payment.
 */
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
				"paymentId='" + id + '\'' +
				", accountNumber=" + accountNumber +
				", accountOwner='" + accountOwner + '\'' +
				", fromDate=" + fromDate + '\'' +
				", paymentDate=" + paymentDate +
				", firstAccountBalance=" + firstAccountBalance +
				", finalAccountBalance=" + finalAccountBalance +
				", debetSum=" + debetSum +
				", creditSum=" + creditSum +
				", transactions= \n" + serializeTransactions() +
				'}';
	}

	private String serializeTransactions ( ) {
		return transactions.stream().map(Transaction::toString).collect(Collectors.joining());
	}

	/**
	 * Gets id.
	 *
	 * @return the id
	 */
	public String getId ( ) {
		return id;
	}

	/**
	 * Sets id.
	 *
	 * @param id the id
	 */
	public void setId (String id) {
		this.id = id;

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
	 * Gets account owner.
	 *
	 * @return the account owner
	 */
	public String getAccountOwner ( ) {
		return accountOwner;
	}

	/**
	 * Sets account owner.
	 *
	 * @param accountOwner the account owner
	 */
	public void setAccountOwner (String accountOwner) {
		this.accountOwner = accountOwner;

	}

	@Id
	private String id;
	@Field
	private String accountNumber;
	@Field
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
	private Collection<Transaction> transactions;

	/**
	 * Gets from date.
	 *
	 * @return the from date
	 */
	public LocalDate getFromDate ( ) {
		return fromDate;
	}

	/**
	 * Sets from date.
	 *
	 * @param fromDate the from date
	 */
	public void setFromDate (LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	/**
	 * Gets first account balance.
	 *
	 * @return the first account balance
	 */
	public BigDecimal getFirstAccountBalance ( ) {
		return firstAccountBalance;
	}

	/**
	 * Sets first account balance.
	 *
	 * @param firstAccountBalance the first account balance
	 */
	public void setFirstAccountBalance (BigDecimal firstAccountBalance) {
		this.firstAccountBalance = firstAccountBalance;
	}

	/**
	 * Gets first account balance sign.
	 *
	 * @return the first account balance sign
	 */
	public String getFirstAccountBalanceSign ( ) {
		return firstAccountBalanceSign;
	}

	/**
	 * Sets first account balance sign.
	 *
	 * @param firstAccountBalanceSign the first account balance sign
	 */
	public void setFirstAccountBalanceSign (String firstAccountBalanceSign) {
		this.firstAccountBalanceSign = firstAccountBalanceSign;
	}

	/**
	 * Gets final account balance.
	 *
	 * @return the final account balance
	 */
	public BigDecimal getFinalAccountBalance ( ) {
		return finalAccountBalance;
	}

	/**
	 * Sets final account balance.
	 *
	 * @param finalAccountBalance the final account balance
	 */
	public void setFinalAccountBalance (BigDecimal finalAccountBalance) {
		this.finalAccountBalance = finalAccountBalance;
	}

	/**
	 * Gets final account balance sign.
	 *
	 * @return the final account balance sign
	 */
	public String getFinalAccountBalanceSign ( ) {
		return finalAccountBalanceSign;
	}

	/**
	 * Sets final account balance sign.
	 *
	 * @param finalAccountBalanceSign the final account balance sign
	 */
	public void setFinalAccountBalanceSign (String finalAccountBalanceSign) {
		this.finalAccountBalanceSign = finalAccountBalanceSign;
	}

	/**
	 * Gets debet sum.
	 *
	 * @return the debet sum
	 */
	public BigDecimal getDebetSum ( ) {
		return debetSum;
	}

	/**
	 * Sets debet sum.
	 *
	 * @param debetSum the debet sum
	 */
	public void setDebetSum (BigDecimal debetSum) {
		this.debetSum = debetSum;
	}

	/**
	 * Gets credit sum.
	 *
	 * @return the credit sum
	 */
	public BigDecimal getCreditSum ( ) {
		return creditSum;
	}

	/**
	 * Sets credit sum.
	 *
	 * @param creditSum the credit sum
	 */
	public void setCreditSum (BigDecimal creditSum) {
		this.creditSum = creditSum;
	}

	/**
	 * Gets payment date.
	 *
	 * @return the payment date
	 */
	public LocalDate getPaymentDate ( ) {
		return paymentDate;
	}

	/**
	 * Sets payment date.
	 *
	 * @param paymentDate the payment date
	 */
	public void setPaymentDate (LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * Gets transactions.
	 *
	 * @return the transactions
	 */
	public Collection<Transaction> getTransactions ( ) {
		return transactions;
	}

	/**
	 * Sets transactions.
	 *
	 * @param transactions the transactions
	 */
	public void setTransactions (Collection<Transaction> transactions) {
		this.transactions = transactions;
	}
}
