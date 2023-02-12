package com.mycompany.ppm.rm;

import com.mycompany.ppm.domain.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author amanm
 */
public class TotalSaleMapper implements RowMapper<Sales>{
    
    @Override
    public Sales mapRow(ResultSet rs, int i) throws SQLException {
        Sales s = new Sales();
        try{
        s.setQty(rs.getInt("sum(`quantity`)"));
        s.setTotal(rs.getString("sum(`total`)"));
            if (rs.getInt("fuelid") <2) {
            System.out.println("fuelid = "+rs.getInt("fuelid"));
                s.setFuel("Petrol");
            }else{
                s.setFuel("Diesel");
            }
        
        }catch(Exception e){
            System.out.println("Exception - "+e);
        }
        return s;
    }
}
