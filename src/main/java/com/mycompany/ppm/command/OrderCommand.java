package com.mycompany.ppm.command;

/**
 *
 * @author amanm
 */
public class OrderCommand {
    private Double value;
    private String byType;
    private Integer fuelid;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getByType() {
        return byType;
    }

    public void setByType(String byType) {
        this.byType = byType;
    }

    public Integer getFuelid() {
        return fuelid;
    }

    public void setFuelid(Integer fuelid) {
        this.fuelid = fuelid;
    }

    
}
