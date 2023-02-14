package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Fuel;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface FuelService {

    public void save(Fuel u);

    public void update(Fuel u);

    public void delete(Integer id);

    public List<Fuel> findAll();

    public Fuel findById(Integer id);
}
