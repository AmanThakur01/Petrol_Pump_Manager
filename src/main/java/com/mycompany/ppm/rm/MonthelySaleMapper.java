package com.mycompany.ppm.rm;

import com.mycompany.ppm.domain.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author amanm
 */
public class MonthelySaleMapper implements RowMapper<Sales>{
     

    @Override
    public Sales mapRow(ResultSet rs, int i) throws SQLException {
        Sales s = new Sales();
        try{
        s.setQty(rs.getInt("sum(`quantity`)"));
        s.setYear(rs.getString("year(`date`)"));
        s.setMonth(rs.getString("month(`date`)"));
        s.setTotal(rs.getString("sum(`total`)"));
        s.setDay(rs.getString("day(`date`)"));
        }catch(Exception e){
            System.out.println("Exception - "+e);
        }
        return s;
    }

    
}
