package com.mycompany.ppm.rm;

import com.mycompany.ppm.domain.Fuel;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author amanm
 */
public class FuelRowMapper  implements RowMapper<Fuel>{

    @Override
    public Fuel mapRow(ResultSet rs, int i) throws SQLException {
        Fuel f = new Fuel();
        f.setFuelid(rs.getInt("fuelid"));
        f.setFuelname(rs.getString("fuelname"));
        f.setRate(rs.getDouble("rate"));
        f.setMaxsize(rs.getInt("maxsize"));
        f.setAvaliablesize(rs.getInt("avaliablesize"));
        f.setMinstocklevel(rs.getInt("minstocklevel"));
        return f;
    }
    
}
