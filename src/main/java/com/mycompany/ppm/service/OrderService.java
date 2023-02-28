package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Order;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface OrderService {

    /**
     * This Method will save the order of user in database and update container
     *
     * @param o order contain user provided value
     */
    public void save(Order o);

    /**
     * This method delete single order by its orderId
     *
     * @param oId
     */
    public void delete(Integer oId);

    /**
     * This method delete multiple order by its order ids
     *
     * @param oIds
     */
    public void delete(Integer[] oIds);

    /**
     * This method find all record present in order list and return it.
     *
     * @return this method return list of orders
     */
    public List<Order> findAll();

    /**
     * This method return orders which contain 'propValue' in 'propName' column
     * in database :-this method search in specific column
     *
     * @param propName this is column name in which search will be performed
     * @param propValue this contain value which have been searched in column
     * @return return list of orders which is matched with above property
     */
    public List<Order> findByProperty(String propName, Object propValue);

    /**
     * This method will find orders which having the date between the given date
     * range
     *
     * @param date starting of date range
     * @param date1 end of date range
     * @return
     */
    public List<Order> findByDate(Date date, Date date1);

    /**
     *
     * @param date This method return the list of order which having this date of
     * enrollment
     * @return
     */
    public List<Order> findByDay(Date date);

    /**
     * this method search randomly or free text search in orders among any
     * column
     *
     * @param txt this if free text given by user
     * @return return matched order in list form
     */
    public List<Order> findByTxt(String txt);
}
