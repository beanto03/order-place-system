package com.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.order.service.OrderService;
import com.order.model.Order;

@Controller
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", orderService.getAllOrder());
        return "index";
    }

    @GetMapping("/add")
    public String addNewEmployee(Model model) {
        Order order = new Order();
        model.addAttribute("Order", order);
        return "addOrder";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("order") Order order){
        orderService.save(order);
        return "redirect:/";
    }

    @GetMapping("updateform/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model){
        Order order = orderService.getById(id);
        model.addAttribute("order", order);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(value = "id") long id){
        orderService.deleteById(id);
        return "redirect:/";
    }


}
