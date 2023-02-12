package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import com.mycompany.ppm.service.ReportServiceImpl;
import java.sql.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestFindByDate {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        ReportServiceImpl order = ctx.getBean(ReportServiceImpl.class);
        Date date=Date.valueOf("2023-02-10");
        Date date2=Date.valueOf("2023-02-13");
        List<Sales> o = order.findByDate(date,date2 );
        for (Sales order1 : o) {
            System.out.println(""+order1.getFuel());
        }
    }
}
