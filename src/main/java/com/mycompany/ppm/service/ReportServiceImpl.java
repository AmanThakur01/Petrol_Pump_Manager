
package com.mycompany.ppm.service;

import com.mycompany.ppm.dao.BaseDAO;
import com.mycompany.ppm.domain.Sales;
import com.mycompany.ppm.rm.MonthelySaleMapper;
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
    
}
