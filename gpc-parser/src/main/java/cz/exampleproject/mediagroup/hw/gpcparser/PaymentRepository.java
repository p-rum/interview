package cz.exampleproject.mediagroup.hw.gpcparser;

import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;


/**
 * The interface Payment repository.
 */
@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

	Payment save (Payment payment);

	void deleteById (String paymentId);

	/**
	 * Find payments by account number collection.
	 *
	 * @param accountNumber the account number
	 * @return the collection
	 */
	Collection<Payment> findPaymentsByAccountNumber (String accountNumber);

	/**
	 * Find payments by account owner collection.
	 *
	 * @param accountOwner the account owner
	 * @return the collection
	 */
	Collection<Payment> findPaymentsByAccountOwner (String accountOwner);
}
