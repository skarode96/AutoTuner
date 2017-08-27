package com.cdk.at.controller;

import com.cdk.at.model.Customer;
import com.cdk.at.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class CustomerResourceController {
    @Autowired
    CustomerService customerService;

    // Rest URL : http://localhost:5000/autotuner/rest/addcustomer
    //Accept Header : text/plain
    //content-type : application/json
    // pass uid
    /*{
    "uid": 1,
    "name": "Sameer",
    "emailId": "sameer.karode07@gmail.com",
    "cars": [
        {
            "vin": 123,
            "make": "Toyota",
            "model": "Qualis",
            "price": 230000
        },
        {
            "vin": 124,
            "make": "Toyota",
            "model": "Itios",
            "price": 240000
        }
    ]
}
*/
    @RequestMapping(value = "/addcustomer",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        int value = customerService.add(customer);
        return "Customer with uid '"+value+" ' added successfully!";
    }


    @RequestMapping(value = "/customer/{uid}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Customer readCustomerByJson(@PathVariable Integer uid){
        Customer customer = customerService.readByUid(uid);
        return customer;
    }

}
