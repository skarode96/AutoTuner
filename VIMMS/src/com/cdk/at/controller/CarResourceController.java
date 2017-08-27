package com.cdk.at.controller;

import com.cdk.at.model.Car;
import com.cdk.at.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class CarResourceController {

    @Autowired
    CarService carService;

    // Rest URL : http://localhost:5000/autotuner/rest/add
    //Accept Header : application/json
    //Don't pass Vin
    /* Body : {
            "name": "M7",
            "make": "BMW",
            "price": 45000,
            "qty": 1
            }
*/
    @RequestMapping(value = "/addcar",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addCar(@RequestBody Car car){
        System.out.println(car);
        int value = carService.add(car);
        return "Car with vin '"+value+" ' resource added successfully!";
    }

    // Rest URL : http://localhost:5000/autotuner/rest/car/1
    //Accept Header : application/json
    //Body : Empty
    @RequestMapping(value = "/car/{vin}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Car readCarByVinAsJson(@PathVariable Integer vin){
        System.out.println("In get method");
        Car car = carService.readByVin(vin);
        return car;
    }

    // Rest URL : http://localhost:5000/autotuner/rest/cars
    //Accept Header : application/json
    //Body : Empty
    @RequestMapping(value = "/cars",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Car> readAllCarsAsJson(){
        return carService.readAll();
    }


    // Rest URL : http://localhost:5000/autotuner/rest/update
    //Accept Header : text/plain
    //pass the vin of the car which needs to be updated
    /* Body : {
            "vin" : 1,
            "name": "Alto",
            "make": "Maruti",
            "price": 60000,
            "qty": 2
            }
*/
    @RequestMapping(value = "/update/{vin}",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.PUT)
    public String updateCar(@RequestBody Car car, @PathVariable int vin){
        car.setVin(vin);
        int value = carService.modify(car);
        return "Car with vin '"+value+" ' resource updated successfully!";
    }

    // Rest URL : http://localhost:5000/autotuner/rest/delete/1
    //Accept Header : text/plain
    //Body : Empty
    @RequestMapping(value = "/delete/{vin}",produces = TEXT_PLAIN_VALUE ,method = RequestMethod.DELETE)
    public String deleteCar(@PathVariable int vin){
        carService.remove(vin);
        return "Car with vin '"+vin+"'resource deleted successfully!";
    }

}
