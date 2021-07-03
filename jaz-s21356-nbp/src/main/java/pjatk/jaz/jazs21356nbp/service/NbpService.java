package pjatk.jaz.jazs21356nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz.jazs21356nbp.model.Rate;
import pjatk.jaz.jazs21356nbp.model.Root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class NbpService {

    private RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Double getAvarageRate(String currency, LocalDate startDate, LocalDate endDate) throws ParseException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startFormatDate = dateTimeFormatter.format(startDate);
        String endFormatDate = dateTimeFormatter.format(endDate);
        double daysCount = ChronoUnit.DAYS.between(startDate, endDate);

        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startFormatDate + "/" + "/" + endFormatDate;
        Root root = restTemplate.getForObject(url, Root.class);
        List<Rate> tableOfCurrencyValues = root.getRates();

        double sumaricRate = 0.0;
        for(Rate currencies :tableOfCurrencyValues){
            sumaricRate += currencies.getMid();
        }
        return sumaricRate/daysCount;
    }
}
