package ee.parking.parkingbillingapp.pricelist.service;

import ee.parking.parkingbillingapp.customer.model.CustomerType;
import ee.parking.parkingbillingapp.pricelist.model.FeeType;
import ee.parking.parkingbillingapp.pricelist.repository.PricelistRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class PricelistService {

    public static final int TWO_PHASE_INTERVAL = 30;

    final PricelistRepository repository;

    public PricelistService(PricelistRepository repository) {
        this.repository = repository;
    }


    public BigDecimal getFixedPrice(FeeType feeType, CustomerType customerType) {
        return repository.findByFeeTypeAndCustomerType(feeType, customerType).getCost();
    }

    public BigDecimal getPriceForParkingLog(FeeType feeType, LocalDateTime startDate, LocalDateTime endDate, CustomerType customerType) {
        int dailyAmount = 0;
        int nightlyAmount = 0;

        for (LocalDateTime date = startDate; date.isBefore(endDate); date = date.plusMinutes(TWO_PHASE_INTERVAL)) {
            if (date.getHour() >= 7) {
                if (date.getHour() <= 18) {
                    dailyAmount++;
                }
            }

            if (date.getHour() >= 19 || date.getHour() < 7) {
                nightlyAmount++;
            }
        }

        return repository.findByFeeTypeAndCustomerType(feeType, customerType).getCost().multiply(BigDecimal.valueOf(feeType.equals(FeeType.DAILY) ? dailyAmount : nightlyAmount));

    }

}
