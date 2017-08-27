package com.cdk.at.controller;

import com.cdk.at.model.Customizer;
import com.cdk.at.service.CustomizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class CustomizerResourceController {

    @Autowired
    CustomizerService customizerService;

    @RequestMapping(value = "/customizers",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Customizer> readAllCustomizersAsJson(){
        return customizerService.readAll();
    }

    @RequestMapping(value = "/customizer/{cId}",produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Customizer readArtistByCidAsJson(@PathVariable Integer cId){
        System.out.println("in controller");
        Customizer customizer = customizerService.readByCid(cId);
        return customizer;
    }

    @RequestMapping(value = "/customizer/category/{category}",produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Collection<Customizer> readArtistByCategoryAsJson(@PathVariable String category){
        System.out.println("in controller");
        return customizerService.readByCategory(category);
    }

}
