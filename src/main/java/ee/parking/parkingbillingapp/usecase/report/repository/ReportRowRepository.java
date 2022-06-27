package ee.parking.parkingbillingapp.usecase.report.repository;

import ee.parking.parkingbillingapp.usecase.report.model.ReportRow;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRowRepository extends CrudRepository<ReportRow, Long> {
}
