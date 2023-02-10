
package com.mycompany.ppm.test;

import com.mycompany.ppm.config.SpringRootConfig;
import java.sql.Date;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * @author amanm
 */
public class TestDataSource {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        DataSource ds = ctx.getBean(DataSource.class);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        JdbcTemplate jt = new JdbcTemplate(ds);
        String sql="INSERT INTO fuel(`fuelname`, `rate`, `maxsize`, `avaliablesize`, `minstocklevel`) VALUES(?,?,?,?,?)";
        Object[] param = new Object[]{"Petrol", 105.5, 10000, 5000,2000};
        jt.update(sql, param);
        System.out.println("------SQL executed-----");
    }
}
