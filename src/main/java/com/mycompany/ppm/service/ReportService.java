package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface ReportService {
    public List<Sales> monthlySale(Integer fId);
    public List<Sales> dailySale(Integer fId);
    public List<Sales> netSale();
    public List<Sales> findByDate(Date date, Date date1);
}
