
package com.mycompany.ppm.service;

import com.mycompany.ppm.dao.BaseDAO;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.domain.Sales;
import com.mycompany.ppm.rm.MonthelySaleMapper;
import com.mycompany.ppm.rm.OrderRowMapper;
import com.mycompany.ppm.rm.TotalSaleMapper;
import java.sql.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author amanm
 */
@Service
public class ReportServiceImpl extends BaseDAO implements ReportService{

    @Override
    public List<Sales> monthlySale(Integer fId) {
        String sql="select sum(`quantity`),year(`date`),month(`date`),sum(`total`) from `order` where fuelid="+fId+" group by year(`date`),month(`date`) order by year(`date`),month(`date`);";
        return getJdbcTemplate().query(sql, new MonthelySaleMapper());
    }

    @Override
    public List<Sales> dailySale(Integer intgr) {
        String sql="select sum(`quantity`),year(`date`),month(`date`),day(`date`),sum(`total`) from `order` where fuelid="+intgr+" group by year(`date`),month(`date`),day(`date`) order by year(`date`),month(`date`);";
        return getJdbcTemplate().query(sql, new MonthelySaleMapper());
    }
    @Override
    public List<Sales> netSale() {
        String sql=" select sum(`quantity`),sum(`total`),`fuelid` from `order` group by `fuelid`;";
        return getJdbcTemplate().query(sql, new TotalSaleMapper());
    }
    @Override
    public List<Sales> findByDate(Date date, Date date1) {
        String sql2 = "SELECT sum(`quantity`),sum(`total`),`fuelid` from `order` WHERE `date` BETWEEN '" + date + "' AND '" + date1 + "' group by `fuelid`";

        return getJdbcTemplate().query(sql2, new TotalSaleMapper());
    }
    
}
