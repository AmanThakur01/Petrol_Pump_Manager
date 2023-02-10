package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.service.OrderServiceImpl;
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
        OrderServiceImpl order = ctx.getBean(OrderServiceImpl.class);
        Date date=Date.valueOf("2023-01-01");
        Date date2=Date.valueOf("2023-02-10");
        List<Order> o = order.findByDate(date,date2 );
        for (Order order1 : o) {
            System.out.println(order1.getDate());
        }
    }
}
