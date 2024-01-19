package com.cms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cms.bean.Customer;
import com.cms.dao.CustomerDAO;



@RestController
@CrossOrigin("http://localhost:4200/")
public class CMSController {

	@Autowired
	CustomerDAO dao;

	// For Inserting
	@PostMapping("/PerformInsert")
	public String performInsert(@RequestBody Customer cus) {
		dao.save(cus);
		return "Inserted";
	}
	
	@PutMapping("/PerformUpdate")
    public String performUpdate(@RequestBody Customer cus)
    {
		dao.save(cus);
        return "Updated";
    }
    @DeleteMapping("/PerformDelete/{cId}")
    public String performDelete(@PathVariable("cId") int cId) {
        dao.deleteById(cId);
        return "Deleted";
    }
    
    @GetMapping("/ViewAll")
    public List<Customer> viewAllCustomer(){
        Iterator<Customer> it=dao.findAll().iterator();
         List<Customer> list = new ArrayList<>();
            while (it.hasNext()) {
                list.add(it.next());
            }
            return list;
    }
}
