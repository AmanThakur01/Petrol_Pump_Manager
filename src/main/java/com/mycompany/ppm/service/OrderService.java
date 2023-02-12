package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Order;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface OrderService {

    public void save(Order o);

//    public void update(Order o);
    public void delete(Integer oId);

    public void delete(Integer[] oIds);

    public Order findByfId(Integer oId);

    public List<Order> findAll();
    public List<Order> findByProperty(String propName, Object propValue);
    
    public List<Order> findByDate(Date date, Date date1);

    public List<Order> findByDay(Date date);
    public List<Order> findByTxt(String txt);
}
