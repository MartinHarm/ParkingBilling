package ee.parking.parkingbillingapp.pricelist.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PricelistController {

    @GetMapping("hello")
    public String hello() {
        return "invoice";
    }
}
