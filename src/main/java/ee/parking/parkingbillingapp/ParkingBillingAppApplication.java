package ee.parking.parkingbillingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableAutoConfiguration
@EnableTransactionManagement
@ComponentScan
public class ParkingBillingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingBillingAppApplication.class, args);
    }

}
