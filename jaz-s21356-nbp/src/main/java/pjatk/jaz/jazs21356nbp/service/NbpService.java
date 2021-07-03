package pjatk.jaz.jazs21356nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pjatk.jaz.jazs21356nbp.model.Rate;
import pjatk.jaz.jazs21356nbp.model.Root;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class NbpService {

    private RestTemplate restTemplate;

    public NbpService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Double getAvarageRate(String currency, String sDateFrom, String sDateTo) throws ParseException {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + sDateFrom + sDateTo;
        Root root = restTemplate.getForObject(url, Root.class);
        List<Rate> tableOfCurrencyValues = root.getRates();
        //SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        //Date dateFrom = format1.parse(sDateFrom);
        //Date dateTo = format1.parse(sDateTo);
         //long daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo);
        LocalDate dateBefore = LocalDate.parse(sDateFrom);
        LocalDate dateAfter = LocalDate.parse(sDateTo);

        long daysCount = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        double sumaricRate = 0.0;
        for(Rate currencies :tableOfCurrencyValues){
            sumaricRate += currencies.getMid();
        }
        return sumaricRate/daysCount;
    }
}
