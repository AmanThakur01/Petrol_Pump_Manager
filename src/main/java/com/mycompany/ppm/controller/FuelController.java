
package com.mycompany.ppm.controller;

import com.mycompany.ppm.command.FuelCommand;
import com.mycompany.ppm.command.OrderCommand;
import com.mycompany.ppm.domain.Fuel;
import com.mycompany.ppm.service.FuelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author amanm
 */
@Controller
public class FuelController {
    @Autowired
    FuelService fuelService;
    
    @RequestMapping(value = {"/save_fuel"})
    public String fuelUpdate(@ModelAttribute("fuelCommand") FuelCommand cmd) {
        Fuel f = fuelService.findById(cmd.getFuelid());
        f.setRate(cmd.getRate());
        f.setAvaliablesize(cmd.getAvaliablesize());
        fuelService.update(f);
        return "redirect:fuel_manager?act=sv";
    }
    
    @RequestMapping(value = {"/", "/index"})
    public String orderForm(Model m) {
        m.addAttribute("fuelList", fuelService.findAll());
        m.addAttribute("command", new OrderCommand());
        return "index";//JSP
    }
    
    @RequestMapping(value = {"/fuel_manager"})
    public String fuelManager(Model m) {
        m.addAttribute("fuelList", fuelService.findAll());
        m.addAttribute("fuelCommand", new FuelCommand());
        return "fuel_manager";
    }

}
