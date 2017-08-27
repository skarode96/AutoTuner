package com.cdk.at.dao;

import com.cdk.at.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class CustomerDAO {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    CarDAO carDAO;

    public int save(Customer customer) {

        entityManager.persist(customer);
        return customer.getUid();
    }

    public Customer selectByUid(Integer uid) {
        return entityManager.find(Customer.class,uid);
    }
}
