package com.mycompany.ppm.command;

/**
 *
 * @author amanm
 */
public class FuelCommand {
    Integer fuelid;
    Integer avaliablesize;
    Double rate;

    public Integer getFuelid() {
        return fuelid;
    }

    public void setFuelid(Integer fuelid) {
        this.fuelid = fuelid;
    }

   

    public Integer getAvaliablesize() {
        return avaliablesize;
    }

    public void setAvaliablesize(Integer avaliablesize) {
        this.avaliablesize = avaliablesize;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
    
}
