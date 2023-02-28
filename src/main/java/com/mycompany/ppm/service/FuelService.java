package com.mycompany.ppm.service;

import com.mycompany.ppm.domain.Fuel;
import java.util.List;

/**
 *
 * @author amanm
 */
public interface FuelService {

    /**
	 * This method will Save Fuel Which will be Sale
	 * 
	 * @param f conatin fuel name,max,min, available level rate
	 */
	public void save(Fuel f);

	/**
	 * This method Update Fuel Rate and Quantity while container is refueling
	 * 
	 * @param f contain new value of rate and refueling quantity
	 */
	public void update(Fuel f);

	/**
	 * This Method Delete Fuel By its FuelId
	 * 
	 * @param id
	 */
	public void delete(Integer id);

	/**
	 * This method get all type fuel present
	 * 
	 * @return retuen all fuel in a list
	 */

	public List<Fuel> findAll();

	/**
	 * This method find fuel by its fuel id
	 * 
	 * @param id
	 * @return return fuel container data
	 */

	public Fuel findById(Integer id);
}
