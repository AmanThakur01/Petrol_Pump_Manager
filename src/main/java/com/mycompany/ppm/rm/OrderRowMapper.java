
package com.mycompany.ppm.rm;

import com.mycompany.ppm.domain.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author amanm
 */
public class OrderRowMapper implements RowMapper<Order>{

    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        Order o = new Order();
        o.setOrderId(rs.getInt("orderid"));
        o.setDate(rs.getDate("date"));
        o.setQty(rs.getInt("quantity"));
        o.setRate(rs.getDouble("rate"));
        o.setTotal(rs.getDouble("total"));
        o.setFuelId(rs.getInt("fuelid"));
        return o;
    }
    
}
