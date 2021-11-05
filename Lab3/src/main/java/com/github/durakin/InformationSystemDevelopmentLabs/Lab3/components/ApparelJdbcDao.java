package com.github.durakin.InformationSystemDevelopmentLabs.Lab3.components;

import com.github.durakin.InformationSystemDevelopmentLabs.Lab3.entity.Apparel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component("apparelJdbcDao")
public class ApparelJdbcDao implements ApparelDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Apparel> findAll() {
        return jdbcTemplate.query("SELECT * FROM apparel", new BeanPropertyRowMapper<>(Apparel.class));
    }

    @Override
    public List<Apparel> findByType(String type) {
        return jdbcTemplate.query("SELECT * FROM apparel WHERE type = ?", new Object[]{type}, new BeanPropertyRowMapper<>(Apparel.class));
    }

    @Override
    public Optional<Apparel> findById(int id) {
        var ret = jdbcTemplate.query("SELECT * FROM apparel WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Apparel.class));
        return ret.stream().findFirst();
    }

    @Override
    public void updateById(int id, Apparel apparel) {
        /*
        jdbcTemplate.update("UPDATE apparel SET type = ?, model = ?, manufacturer = ?, cost = ?, height = ? WHERE id = ?",
                apparel.ge(), apparel.getModel(), apparel.getManufacturer(), apparel.getCost(), apparel.getHeight(), id);

         */
    }

    @Override
    public void insert(Apparel apparel) {
        /*
        jdbcTemplate.update("INSERT INTO Furniture (id, type, model, manufacturer, cost, height) VALUES (DEFAULT,?,?,?,?,?)",
                apparel.getType(), apparel.getModel(), apparel.getManufacturer(), apparel.getCost(), apparel.getHeight());

         */
    }

    @Override
    public void removeById(int id) {
        jdbcTemplate.update("DELETE FROM apparel WHERE id = ?", id);
    }
}
