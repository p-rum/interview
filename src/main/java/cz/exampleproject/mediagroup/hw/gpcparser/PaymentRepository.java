package cz.exampleproject.mediagroup.hw.gpcparser;

import cz.exampleproject.mediagroup.hw.gpcparser.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * The interface Payment repository.
 */
public interface PaymentRepository extends MongoRepository<Payment, String> {

}
