package com.mycompany.ppm.dao;

import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface OrderDAO {

    //    `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid`
    public void save(Order o);

    public void update(Order o);

    public void delete(Order o);

    public void delete(Integer id);

    public Order findByfId(Integer id);

    public List<Order> findAll();

    public List<Order> findByProperty(String propName, Object propValue);
}
