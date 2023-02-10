package com.mycompany.ppm.domain;

/**
 *
 * @author amanm
 */
public class Fuel {

    private Integer fuelid;
    private String fuelname;
    private Double rate;
    private Integer maxsize;
    private Integer avaliablesize;
    private Integer minstocklevel;

    public Integer getFuelid() {
        return fuelid;
    }

    public void setFuelid(Integer fuelid) {
        this.fuelid = fuelid;
    }

    public String getFuelname() {
        return fuelname;
    }

    public void setFuelname(String fuelname) {
        this.fuelname = fuelname;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(Integer maxsize) {
        this.maxsize = maxsize;
    }

    public Integer getAvaliablesize() {
        return avaliablesize;
    }

    public void setAvaliablesize(Integer avaliablesize) {
        this.avaliablesize = avaliablesize;
    }

    public Integer getMinstocklevel() {
        return minstocklevel;
    }

    public void setMinstocklevel(Integer minstocklevel) {
        this.minstocklevel = minstocklevel;
    }

    }
