package ee.parking.parkingbillingapp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class ParkingBillingAppApplicationTests {

    @Test
    void contextLoads() {
    }

	/*
	REGULAR TEST CASE
		{
			"parkingStarted": "2022-06-26 08:12:00",
			"parkingEnded": "2022-06-26 10:45:00",
			"regNumber": "042TJW"
		}
		{
			"parkingStarted": "2022-06-26 19:40:00",
			"parkingEnded": "2022-06-26 20:35:00",
			"regNumber": "042TJW"
		}
		Total invoice: 9.00 + 2.00 = 11.00 EUR

	PREMIUM TEST CASE
	 	{
			"parkingStarted": "2022-06-26 08:12:00",
			"parkingEnded": "2022-06-26 10:45:00",
			"regNumber": "511BXX"
		}
		{
			"parkingStarted": "2022-06-26 07:02:00",
			"parkingEnded": "2022-06-26 11:56:00",
			"regNumber": "511BXX"
		}
		{
			"parkingStarted": "2022-06-26 22:10:00",
			"parkingEnded": "2022-06-26 22:35:00",
			"regNumber": "511BXX"
		}
		{
			"parkingStarted": "2022-06-26 19:40:00",
			"parkingEnded": "2022-06-26 20:35:00",
			"regNumber": "511BXX"
		}
		Total invoice: 6.00 + 10.00 + 0.75 + 1.50 + 20.00 = 38.25 EUR
	* */
}
