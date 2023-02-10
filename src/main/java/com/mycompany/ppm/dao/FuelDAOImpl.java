package com.mycompany.ppm.dao;

import com.mycompany.ppm.domain.Fuel;
import com.mycompany.ppm.rm.FuelRowMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amanm
 */
@Repository
public class FuelDAOImpl extends BaseDAO implements FuelDAO {
//    `fuelid`, `fuelname`, `rate`, `maxsize`, `avaliablesize`, `minstocklevel`

    @Override
    public void save(Fuel f) {
        String sql = "INSERT INTO fuel(`fuelname`, `rate`, `maxsize`, `avaliablesize`, `minstocklevel`)"
                + " VALUES(:fuelname, :rate, :maxsize, :avaliablesize, :minstocklevel)";
        Map m = new HashMap();
        m.put("fuelname", f.getFuelname());
        m.put("rate", f.getRate());
        m.put("maxsize", f.getMaxsize());
        m.put("avaliablesize", f.getAvaliablesize());
        m.put("minstocklevel", f.getMinstocklevel());

        KeyHolder kh = new GeneratedKeyHolder();
        SqlParameterSource ps = new MapSqlParameterSource(m);
        super.getNamedParameterJdbcTemplate().update(sql, ps, kh);
        Integer fuelId = kh.getKey().intValue();
        f.setFuelid(fuelId);
    }

    @Override
    public void update(Fuel f) {
        System.out.println("fuel DAO : "+ f.getFuelname()+" min stock = "+f.getMinstocklevel());
        String sql = "UPDATE fuel "
                + " SET fuelname=:fuelname,"
                + " rate=:rate, "
                + " maxsize=:maxsize,"
                + " avaliablesize=:avaliablesize,"
                + " minstocklevel=:minstocklevel"
                + " WHERE fuelid=:fuelid";
        Map m = new HashMap();
        m.put("fuelname", f.getFuelname());
        m.put("rate", f.getRate());
        m.put("maxsize", f.getMaxsize());
        m.put("avaliablesize", f.getAvaliablesize());
        m.put("minstocklevel", f.getMinstocklevel());
        m.put("fuelid", f.getFuelid());
        getNamedParameterJdbcTemplate().update(sql, m);
    }

    @Override
    public void delete(Integer id) {
        String sql = "DELETE FROM fuel WHERE fuelid=?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public List<Fuel> findAll() {
        String sql = "SELECT `fuelid`, `fuelname`, `rate`, `maxsize`, `avaliablesize`, `minstocklevel`"
                + " FROM fuel";
        return getJdbcTemplate().query(sql, new FuelRowMapper());
    }

    @Override
    public Fuel findById(Integer intgr) {
         String sql = "SELECT `fuelid`, `fuelname`, `rate`, `maxsize`, `avaliablesize`, `minstocklevel`"
                + " FROM fuel WHERE fuelid=?";
        return getJdbcTemplate().queryForObject(sql, new FuelRowMapper(),intgr);
    }
    

}
