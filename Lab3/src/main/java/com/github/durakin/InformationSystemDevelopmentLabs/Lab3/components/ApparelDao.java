package com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components;

import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity.Apparel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class ApparelDao{
    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Apparel> findAll() {
        return jdbcTemplate.query("select * from apparel", new
                BeanPropertyRowMapper<>(Apparel.class));
    }

    public int insert(Apparel apparel) {
        return jdbcTemplate.update("insert into apparel" +
                        "(price, in_stock, apparel_type, size, sex)" +
                        "values (?,?,?,?,?)",
                apparel.getPrice(), apparel.getInStock(), apparel.getApparelType(), apparel.getSize(), apparel.getSex());
    }
}
