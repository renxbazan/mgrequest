package com.renx.mg.request.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.renx.mg.request.model.Customer;
import com.renx.mg.request.repository.CustomerRepository;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerRepository repository;
	
	@GetMapping("/customer")
	public String index(Model model) {
		model.addAttribute("customerList", repository.findAll());
		model.addAttribute("customer", new Customer());
		
		return "customer";
	}
	
	@PostMapping("/customer")
	public String save(Model model,@ModelAttribute("customer") Customer customer) {
		model.addAttribute("customerList", repository.findAll());
		model.addAttribute("customer", new Customer());
		
		repository.save(customer);
		
		return "redirect:/customer";
	}
	
	@GetMapping("/customer/{id}")
	public String findOne(Model model,@PathVariable("id") Long id) {
		model.addAttribute("customerList", repository.findAll());
		Optional<Customer> customer = repository.findById(id);
		model.addAttribute("customer",customer.get() );
		
		return "customer";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String save(Model model,@PathVariable("id") Long id) {
		model.addAttribute("customerList", repository.findAll());
		model.addAttribute("customer", new Customer());
		repository.deleteById(id);
		
		return "redirect:/customer";
	}
	
	

}
