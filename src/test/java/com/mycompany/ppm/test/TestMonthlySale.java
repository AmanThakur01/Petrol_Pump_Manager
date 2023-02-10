
package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import com.mycompany.ppm.dao.OrderDAO;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import com.mycompany.ppm.service.ReportService;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestMonthlySale {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ReportService orderDAO = ctx.getBean(ReportService.class);
        List<Sales> l = orderDAO.monthlySale(1);
        for (Sales o : l) {
            System.out.println("year ="+o.getYear());
            System.out.println("month ="+o.getMonth());
            System.out.println("total ="+o.getTotal());
        }
    }
}
