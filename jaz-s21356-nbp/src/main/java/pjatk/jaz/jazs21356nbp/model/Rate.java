package pjatk.jaz.jazs21356nbp.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("Data from nbp")
public class Rate {
    @ApiModelProperty("Number of currency rates array")
    public String no;
    @ApiModelProperty("Date of publication")
    public String effectiveDate;
    @ApiModelProperty("Counted medium currency rate")
    public double mid;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}
