package ee.parking.parkingbillingapp.parkinglog;

import ee.parking.parkingbillingapp.usecase.parkinglog.api.ParkingLogController;
import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLog;
import ee.parking.parkingbillingapp.usecase.parkinglog.model.ParkingLogDTO;
import ee.parking.parkingbillingapp.usecase.parkinglog.service.ParkingLogService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest(classes = ParkingLogController.class)
public class ParkingLogControllerTest {

    @MockBean
    private ParkingLogService parkingLogService;


    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    ParkingLogDTO parkingLogDTO = new ParkingLogDTO();

    ParkingLog parkingLog = new ParkingLog();

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Mockito.when(parkingLogService.persistParkingLog(parkingLogDTO)).thenReturn(parkingLog);
    }

    @Test
    public void createParkingLog() throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        parkingLogDTO.setParkingStarted(LocalDateTime.now());
        parkingLogDTO.setParkingEnded(LocalDateTime.now().plusHours(2));
        parkingLogDTO.setRegNumber("511BXX");

        String jsonPayload = "{\n" +
                "  \"parkingStarted\": \"2019-10-24 07:58:25\",\n" +
                "  \"parkingEnded\": \"2019-10-24 02:28:25\",\n" +
                "  \"regNumber\": \"2019-10-25\",\n" +
                "}";

        mockMvc.perform(MockMvcRequestBuilders
                .post("/parking/log")
                .content(jsonPayload)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
    }

}
