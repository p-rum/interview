package cz.exampleproject.mediagroup.hw.gpcparser.format;

public enum GPCPaymentDetails {

	accountNumber(3, 16),

	counterpartyAccountNumber(19, 16),

	transactionIdentifier(35, 13),

	transactionAmount(48, 12),

	accountingType(60, 1),

	variableCode(61, 10),

	counterpartyBankCode(71, 2),

	constantCode(77, 4),

	specificCode(81, 10),

	valueDate(91, 6),

	transactionDescription(97, 20),

	currencyCode(117, 5),

	postingDate(122, 6),

	transactionIdentification(3, 26),

	dateOfDebitingFromCounterparty(29, 6),

	comment(35, 92),

	mixedTransactionInfo1(3, 35),

	mixedTransactionInfo2(38, 35),

	mixedTransactionInfo3(73, 54),

	mixedTransactionInfo4(3, 35),

	mixedTransactionInfo5(38, 35),

	mixedTransactionInfo6(74, 35),

	accountOwner(19, 20),

	fromDate(39, 6),

	firstAccountBalance(45, 14),

	firstAccountBalanceSign(59, 1),

	finalAccountBalance(60, 14),

	finalAccountBalanceSign(74, 1),

	debetSum(75, 14),

	creditSum(89, 1),

	paymentId(90, 14),

	paymentDate(108, 6);

	public final int start;
	public final int end;

	GPCPaymentDetails (int start, int length) {
		this.start = start;
		this.end = (this.start + length);
	}

}
