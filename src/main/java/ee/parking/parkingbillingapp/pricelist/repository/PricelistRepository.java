package ee.parking.parkingbillingapp.pricelist.repository;

import ee.parking.parkingbillingapp.customer.model.CustomerType;
import ee.parking.parkingbillingapp.pricelist.model.FeeType;
import ee.parking.parkingbillingapp.pricelist.model.Pricelist;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricelistRepository extends CrudRepository<Pricelist, Long> {
    @Query("from Pricelist p where p.feeType=:feeType AND p.customerType=:customerType AND p.validFrom < CURRENT_DATE AND p.validTo > CURRENT_DATE")
    Pricelist findByFeeTypeAndCustomerType(FeeType feeType, CustomerType customerType);
}

