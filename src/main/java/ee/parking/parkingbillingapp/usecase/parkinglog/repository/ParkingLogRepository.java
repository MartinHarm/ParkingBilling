package ee.parking.parkingbillingapp.usecase.parkinglog.repository;

import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingLogRepository extends CrudRepository<ParkingLog, Long> {
}
