package com.mycompany.ppm.dao;

import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import com.mycompany.ppm.rm.MonthelySaleMapper;
import com.mycompany.ppm.rm.OrderRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amanm
 */
@Repository
public class OrderDAOImpl extends BaseDAO implements OrderDAO {


    @Override
    public void save(Order o) {
        String sql = "INSERT INTO `order` (`quantity`, `rate`, `total`, `fuelid`) VALUES ('"+o.getQty()+"', '"+o.getRate()+"', '"+o.getTotal()+"','"+o.getFuelId()+"');";
        getJdbcTemplate().update(sql);
    }

    @Override
    public void update(Order o) {
        String sql = "UPDATE order "
                + " SET quantity=:quantity, "
                + " rate=:rate,"
                + " total=:total,"
                + " fuelid=:fuelid"
                + " WHERE orderid=:orderid";
        Map m = new HashMap();
        m.put("quantity", o.getQty());
        m.put("rate", o.getRate());
        m.put("total", o.getTotal());
        m.put("fuelid", o.getFuelId());
        m.put("orderid", o.getOrderId());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Order o) {
        this.delete(o.getOrderId());
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM order WHERE orderid=?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public Order findByfId(Integer id) {
        String sql = "SELECT `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid` FROM order WHERE fuelid=?";
        return getJdbcTemplate().queryForObject(sql, new OrderRowMapper(), id);
    }

    @Override
    public List<Order> findAll() {
        String sql = "SELECT * FROM `order`";
        return getJdbcTemplate().query(sql, new OrderRowMapper());
    }

    @Override
    public List<Order> findByProperty(String propName, Object propValue) {
        String sql = "SELECT `orderid`, `date`, `quantity`, `rate`, `total`, `fuelid` FROM `order` WHERE (`" + propName + "` LIKE '%"+propValue+"%') ";
        return getJdbcTemplate().query(sql, new OrderRowMapper());
    }
}
