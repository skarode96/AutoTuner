package com.cdk.at.service;

import com.cdk.at.dao.CustomerDAO;
import com.cdk.at.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerService {

    @Autowired
    CustomerDAO customerDAO;

    @Transactional
    public int add(Customer customer) {
        return customerDAO.save(customer);
    }

    @Transactional
    public Customer readByUid(Integer uid) {
        return customerDAO.selectByUid(uid);
    }

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
