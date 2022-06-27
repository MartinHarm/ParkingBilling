package ee.parking.parkingbillingapp.usecase.report.repository;

import ee.parking.parkingbillingapp.usecase.report.model.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report, Long> {
    Report findByCustomerId(Long customerId);
}
