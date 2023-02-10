package com.mycompany.ppm.dao;

import com.mycompany.ppm.domain.Fuel;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface FuelDAO {

    public void save(Fuel u);

    public void update(Fuel u);

    public void delete(Integer id);

    public List<Fuel> findAll();

    public Fuel findById(Integer id);

}
