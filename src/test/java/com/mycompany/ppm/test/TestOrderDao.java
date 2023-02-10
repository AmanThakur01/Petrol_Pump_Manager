package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import com.mycompany.ppm.dao.OrderDAO;
import com.mycompany.ppm.domain.Order;
import java.sql.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestOrderDao {

    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        OrderDAO orderDAO = ctx.getBean(OrderDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
//        `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid`
        Order ord = new Order();
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);

//        ord.setDate(date);
        ord.setFuelId(1);
        ord.setQty(2);
        ord.setRate(120.0);
        ord.setTotal(240.0);
        orderDAO.save(ord);
        System.out.println("--------Data Saved------");
    }
}
