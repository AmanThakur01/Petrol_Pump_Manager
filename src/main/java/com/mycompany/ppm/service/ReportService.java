package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Sales;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface ReportService {
    public List<Sales> monthlySale(Integer fId);
    public List<Sales> dailySale(Integer fId);
}
