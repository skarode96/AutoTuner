package com.cdk.at.controller;

import com.cdk.at.model.Accessories;
import com.cdk.at.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class AccessoriesResourceController {
    @Autowired
    AccessoriesService accessoriesService;

    @RequestMapping(value = "/accessories/{vin}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Accessories readAccessoriesByVinAsJson(@PathVariable Integer vin) {
        System.out.println("In get method");
        Accessories accessories = accessoriesService.readByVin(vin);
        return accessories;
    }



    @RequestMapping(value = "/addaccessories",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addAccessoriesFromCheckboxes(@RequestBody Accessories accessories){
        System.out.println(accessories);
        int value = accessoriesService.addAccessories(accessories);
        return "Accessories for vin '"+value+" ' added successfully!";
    }

}
