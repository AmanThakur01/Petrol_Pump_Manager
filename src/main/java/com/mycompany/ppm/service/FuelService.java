/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
