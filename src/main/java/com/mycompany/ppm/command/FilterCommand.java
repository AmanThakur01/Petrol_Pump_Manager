package com.mycompany.ppm.command;

import java.sql.Date;

/**
 *
 * @author amanm
 */
public class FilterCommand {
    Date from;
    Date to;
    String filter;

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
    
}
