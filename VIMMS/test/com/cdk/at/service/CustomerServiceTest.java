package com.cdk.at.service;

import com.cdk.at.dao.CustomerDAO;
import com.cdk.at.model.Car;
import com.cdk.at.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Set;

public class CustomerServiceTest {

    CustomerService customerService = new CustomerService();

    Car car1 = new Car(1,"Audi","X6",4500000);
    Car car2 = new Car(2,"Maruti","Alto",2200000);
    Set<Car> set = new HashSet<Car>();

    @Test
    public void testAdd() throws Exception {
        set.add(car1);
        set.add(car2);
        Customer customer1 = new Customer(1,"Ram","ram@cdk.com",set);


        CustomerDAO mock = Mockito.mock(CustomerDAO.class);
        Mockito.when(mock.save(customer1)).thenReturn(customer1.getUid());
        customerService.setCustomerDAO(mock);

        int customerUid1 = customerService.add(customer1);
        Assert.assertEquals(customerUid1,customer1.getUid());
    }

    @Test
    public void testReadByUid() throws Exception {
        set.add(car1);
        set.add(car2);
        Customer customer2 = new Customer(2,"Shyam","shyam@cdk.com",set);

        CustomerDAO mock = Mockito.mock(CustomerDAO.class);
        Mockito.when(mock.selectByUid(2)).thenReturn(customer2);
        customerService.setCustomerDAO(mock);

        Customer customer = customerService.readByUid(2);
        Assert.assertEquals(customer,customer2);
    }


}
