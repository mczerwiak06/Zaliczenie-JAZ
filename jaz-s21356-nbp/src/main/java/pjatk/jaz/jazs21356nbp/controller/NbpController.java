package pjatk.jaz.jazs21356nbp.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.jaz.jazs21356nbp.service.NbpService;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

@RestController
@RequestMapping("/nbp")
public class NbpController {
    private NbpService nbpService;
    public NbpController(NbpService nbpService){
        this.nbpService = nbpService;
    }
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Everything ok"),
            @ApiResponse(code = 404, message = "Currency not found"),
            @ApiResponse(code = 504, message = "SSomething's wrong with server")}
            )
    @ApiOperation(value = "Get average rate of currency beetween two dates", notes = "Provide your cuurnecy start date and end date")
    @GetMapping("/{currency}/{dateFrom}/{dateTo}")
    public ResponseEntity<Double> getAvarageRateBetweenDays(
            @ApiParam(value = "Currency you want to retrieve", example = "eur")
            @PathVariable String currency,
            @ApiParam(value = "Start date", example = "2021-04-22")
            @PathVariable LocalDate dateFrom,
            @ApiParam(value = "End date", example = "2021-06-23")
            @PathVariable LocalDate dateTo) throws ParseException {
        return ResponseEntity.ok(nbpService.getAvarageRate(currency, dateFrom, dateTo));
    }

}
