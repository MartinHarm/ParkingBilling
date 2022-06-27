package ee.parking.parkingbillingapp.usecase.parkinglog.api;

import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLogDTO;
import ee.parking.parkingbillingapp.usecase.parkinglog.service.ParkingLogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/parking")
public class ParkingLogController {

    private final ParkingLogService parkingLogService;

    public ParkingLogController(ParkingLogService parkingLogService) {
        this.parkingLogService = parkingLogService;
    }

    @PostMapping("/log")
    ResponseEntity<String> parkingLog(@RequestBody ParkingLogDTO parkingLogDTO) {

        if (parkingLogService.persistParkingLog(parkingLogDTO) != null) {
            return new ResponseEntity<>(
                    "ParkingLog created", HttpStatus.OK);
        }
        return new ResponseEntity<>(
                "Error creating ParkingLog", HttpStatus.BAD_REQUEST);
    }


}
