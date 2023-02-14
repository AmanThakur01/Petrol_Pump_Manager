package com.mycompany.ppm.controller;

import com.mycompany.ppm.command.FilterCommand;
import com.mycompany.ppm.command.OrderCommand;
import com.mycompany.ppm.domain.Fuel;
import com.mycompany.ppm.domain.Order;
import com.mycompany.ppm.service.FuelService;
import com.mycompany.ppm.service.OrderService;
import java.sql.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author amanm
 */
@Controller
public class OrderController {

    @Autowired
    OrderService orderService;
    @Autowired
    FuelService fuelService;

    @RequestMapping(value = {"/order"})
    public String order(@ModelAttribute("command") OrderCommand cmd, Model m) {

        Integer qty;
        Order order = new Order();

        try {
            Fuel f = fuelService.findById(cmd.getFuelid());
            order.setFuelId(cmd.getFuelid());
            order.setRate(f.getRate());
            if ("amount".equals(cmd.getByType())) {
                qty = (int) (cmd.getValue() / f.getRate());
                order.setTotal(cmd.getValue());
                order.setQty(qty);
                //1L = 100Rs
                m.addAttribute("amt", cmd.getValue());

            } else {
                qty = (cmd.getValue()).intValue();
                order.setQty(qty);
                order.setTotal(cmd.getValue() * f.getRate());
                m.addAttribute("amount", (cmd.getValue() * f.getRate()));
            }
            int check = checkAvail(f, qty);
            switch (check) {
                case 0:
                    m.addAttribute("minLevel", "ml");
                    break;
                case -2:
                    return "redirect:index?act=uf";
            }
            f.setAvaliablesize(f.getAvaliablesize() - qty);
            System.out.println("f.getAvaliablesize() : " + f.getAvaliablesize());
            fuelService.update(f);
            orderService.save(order);
            return "redirect:index?act=sv";

        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("err", "Process Failed...!");
            return "redirect:index";
        }
    }

    @RequestMapping(value = {"/order_report"})
    public String orderReport(Model m) {
        m.addAttribute("filterCommand", new FilterCommand());
        m.addAttribute("orderList", orderService.findAll());
        return "order_report";//jsp
    }

    @RequestMapping(value = {"/order/order_search"})
    public String orderSearch(@RequestParam("freeText") String txt, Model m) {
        m.addAttribute("orderList", orderService.findByTxt(txt));
        return "order_report";//jsp
    }

    public Integer checkAvail(Fuel f, Integer qty) {
        /*      minstocklevel < qty =< availSize   ---->   Done Go On
                0 < qty =< minstocklevel  --->  Fuel Reached Min. Level
                else -> Insufficient Fuel
         */
        Integer availSize = f.getAvaliablesize();
        Integer minStockLevel = f.getMinstocklevel();
        if (0 < qty && qty <= availSize) {
            if (availSize <= minStockLevel) {
                return 0;
            } else {
                return 2;
            }
        } else {
            return -2;

        }

    }

    @RequestMapping(value = "/order_filter")
    public String expenseFilter(@RequestParam("filter") String filter, @RequestParam("val") String val, @RequestParam("val2") String val2, Model m) {
        try {
            if ("byFuel".equals(filter)) {
                List<Order> l = orderService.findByProperty("fuelid", ("petrol".equals(val.toLowerCase())) ? 1 : 2);
                System.out.println("l cate = " + l);
                for (Order order : l) {
                    System.out.println("order = " + order.getDate());

                }
                m.addAttribute("orderList", l);

            } else if ("byDateRange".equals(filter)) {
                List<Order> l = orderService.findByDate(Date.valueOf(val), Date.valueOf(val2));
                System.out.println("l cate = " + l);
                for (Order order : l) {
                    System.out.println("order = " + order.getDate());

                }
                m.addAttribute("orderList", l);

            } else {
                List<Order> l = orderService.findByProperty("date", val);
                m.addAttribute("orderList", l);
                System.out.println("l date = " + l);
                for (Order order : l) {
                    System.out.println("order = " + order.getDate());

                }
                m.addAttribute("expenseList", l);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "/order_report";
        }
        return "/order_report";
    }

}
