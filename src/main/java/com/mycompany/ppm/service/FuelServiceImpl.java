package com.mycompany.ppm.service;

import com.mycompany.ppm.dao.BaseDAO;
import com.mycompany.ppm.dao.FuelDAO;
import com.mycompany.ppm.domain.Fuel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author amanm
 */
@Service
public class FuelServiceImpl extends BaseDAO implements FuelService {

    @Autowired
    private FuelDAO fuelDAO;

    @Override
    public void save(Fuel u) {
        fuelDAO.save(u);
    }

    @Override
    public void update(Fuel u) {
        fuelDAO.update(u);
    }

    @Override
    public void delete(Integer id) {
        fuelDAO.delete(id);
    }

    @Override
    public List<Fuel> findAll() {
        return fuelDAO.findAll();
    }

    @Override
    public Fuel findById(Integer id) {
        return fuelDAO.findById(id);
    }

}
