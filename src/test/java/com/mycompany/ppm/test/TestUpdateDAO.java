package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import com.mycompany.ppm.dao.FuelDAO;
import com.mycompany.ppm.dao.OrderDAO;
import com.mycompany.ppm.domain.Fuel;
import com.mycompany.ppm.domain.Order;
import java.sql.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author amanm
 */
public class TestUpdateDAO {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        FuelDAO orderDAO = ctx.getBean(FuelDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
//        `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid`
        Fuel f = new Fuel();
        f.setAvaliablesize(2000);
        f.setFuelid(1);
        f.setFuelname("Petrol");
        f.setMaxsize(10000);
        f.setMinstocklevel(5000);
        f.setRate(120.0);
        orderDAO.update(f);
        System.out.println("--------Data Updated------");
    }
}
