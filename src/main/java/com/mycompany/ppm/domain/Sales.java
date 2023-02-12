package com.mycompany.ppm.domain;

/**
 *
 * @author amanm
 */
public class Sales{
    String fuel;
    Integer qty;
    String year;
    String day;
    String month;
    String total;

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
     
}

