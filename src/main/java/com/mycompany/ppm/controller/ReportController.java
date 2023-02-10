package com.mycompany.ppm.controller;

import com.mycompany.ppm.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author amanm
 */
@Controller
public class ReportController {
    
    @Autowired
    ReportService reportService;
    
    @RequestMapping(value = "/report_analysis")
    public String reportAnalysis(Model m) {
        
        m.addAttribute("pMonthList", reportService.monthlySale(1));
        m.addAttribute("dMonthList", reportService.monthlySale(2));
        m.addAttribute("pDayList", reportService.dailySale(1));
        m.addAttribute("dDayList", reportService.dailySale(2));
        return "analysis_report";//jsp

    }
    
    
}
