package pjatk.jaz.jazs21356nbp.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel("Data from nbp")
public class Root {
    @ApiModelProperty("Type of currency rates array")
    public String table;
    @ApiModelProperty("Currency name")
    public String currency;
    @ApiModelProperty("Currency code")
    public String code;
    @ApiModelProperty("List of currency rates")
    public List<Rate> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
