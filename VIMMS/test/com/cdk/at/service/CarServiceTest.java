package com.cdk.at.service;

import com.cdk.at.dao.CarDAO;
import com.cdk.at.model.Car;
import org.junit.Test;
import org.junit.Assert;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.mock.staticmock.MockStaticEntityMethods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarServiceTest {

    CarService carService = new CarService();

    Car car1 = new Car(1,"Audi","X6",4500000);
    Car car2 = new Car("BMW","A4",7800000);
    Car car3 = new Car(2,"Maruti","Alto",2200000);

    @Test
    public void testAdd() throws Exception {
        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.save(car1)).thenReturn(car1.getVin());
        carService.setCarDAO(mock);

        int carVin1 = carService.add(car1);
        Assert.assertEquals(carVin1,car1.getVin());

    }

    @Test
    public void testReadByVin() throws Exception {

        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.selectByVin(1)).thenReturn(car1);
        carService.setCarDAO(mock);

        Car car = carService.readByVin(1);
        Assert.assertEquals(car,car1);
    }

    @Test
    public void testModify() throws Exception {

        CarDAO mock = Mockito.mock(CarDAO.class);
        Mockito.when(mock.update(car3)).thenReturn(car3.getVin());
        carService.setCarDAO(mock);

        int getVin3 = carService.modify(car3);
        Assert.assertEquals(getVin3,car3.getVin());
    }
}