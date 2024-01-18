package com.cms.test;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cms.bean.Customer;
import com.cms.controller.CMSController;

@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
public class CustomerTest {
	
	@Autowired
    CMSController controller;
    
    String insert;
    String update;
    String delete;
    String result;
    String result1;
    
    List<Customer> list = new ArrayList<Customer>();
    List<Customer> list1 = new ArrayList<Customer>();
    Customer cus = new Customer(444,"Matthew","barathmatthew@gmail.com",1234567890,"Tenkasi");
    Customer cus1 = new Customer(333,"Barath","matthew@gmail.com",12345678,"Madurai");
    Customer cus2;
    Customer cus3;
    
    @Test
    @Order(1)
    void contextLoads() {
    
    }
    
    @Test
    @Order(2)    
    public void testPerformInsert() {
        insert="Inserted";
        result=controller.performInsert(cus);
        assertEquals(insert,result);
    }
    
    @Test
    @Order(3)
    public void testPerformUpdate() {
        update="Updated";
        result=controller.performUpdate(cus1);
        assertEquals(update,result);
    }
    
    @Test
    @Order(4)
    public void testPerformDelete() {
        delete="Deleted";
        result=controller.performDelete(201);
        result1=controller.performDelete(301);
        assertEquals(delete,result);
    }
    
    @Test
    @Order(5)
    public void testGetAllCustomerDetails() {
        list=controller.viewAllCustomer();
        cus2 = new Customer(1,"James","James@123@gmail.com",45751255,"Madurai");
        cus3 = new Customer(2,"jasin","jasin@gmail.com",465872,"Chennai");
        list1.add(cus2);
        list1.add(cus3);
        list.equals(list1);
    }


}

