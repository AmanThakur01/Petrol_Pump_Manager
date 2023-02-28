package com.mycompany.ppm.service;

import com.mycompany.ppm.dao.BaseDAO;
import com.mycompany.ppm.dao.OrderDAO;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.rm.OrderRowMapper;
import com.mycompany.ppm.util.StringUtil;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amanm
 */
@Service
public class OrderServiceImpl extends BaseDAO implements OrderService {
//`orderid`, `date`, `quantity`, `rate`, `total`, `fuelid`

    @Autowired
    private OrderDAO orderDAO;

    @Override
    public void save(Order o) {
        orderDAO.save(o);
    }

    @Override
    public void delete(Integer oId) {
        orderDAO.delete(oId);
    }

    @Override
    public void delete(Integer[] oIds) {
        String ids = StringUtil.toCommaSeparatedString(oIds);
        String sql = "DELETE FROM order WHERE orderid IN (" + ids + ")";
        getJdbcTemplate().update(sql);
    }

    @Override
    public List<Order> findByDate(Date date, Date date1) {
        String sql2 = "SELECT `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid` FROM `order` WHERE `date` BETWEEN '" + date + "' AND '" + date1 + "'";

        return getJdbcTemplate().query(sql2, new OrderRowMapper());
    }

    @Override
    public List<Order> findByDay(Date date) {
        String sql = "SELECT `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid` FROM `order` WHERE date = ?";
        return getJdbcTemplate().query(sql, new OrderRowMapper(), date);
    }

    @Override
    public List<Order> findByTxt(String txt) {
        String sql = "SELECT `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid`"
                + " FROM `order` WHERE (orderid LIKE '%" + txt + "%' OR date LIKE '%" + txt + "%'"
                + " OR quantity LIKE '%" + txt + "%' OR rate LIKE '%" + txt + "%'"
                + " OR total LIKE '%" + txt + "%' OR fuelid LIKE '%" + txt + "%')";
        return getJdbcTemplate().query(sql, new OrderRowMapper());
    }

    @Override
    public List<Order> findAll() {
        return orderDAO.findAll();
    }

    @Override
    public List<Order> findByProperty(String string, Object o) {
        return orderDAO.findByProperty(string, o);
    }

}
