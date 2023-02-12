package com.mycompany.ppm.controller;

import com.mycompany.ppm.service.ReportService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        m.addAttribute("pNetSale", reportService.netSale());
        return "analysis_report";//jsp

    }
    @RequestMapping(value = "/netSale_filter")
    public String filterReport(@RequestParam("val") Date val,@RequestParam("val2") Date val2,Model m) {
        
        m.addAttribute("pMonthList", reportService.monthlySale(1));
        m.addAttribute("dMonthList", reportService.monthlySale(2));
        m.addAttribute("pDayList", reportService.dailySale(1));
        m.addAttribute("dDayList", reportService.dailySale(2));
        m.addAttribute("pNetSale", reportService.findByDate(val,val2));
        System.out.println("inside netSale");
        return "analysis_report";//jsp

    }
    
    
}
