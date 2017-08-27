package com.cdk.at.service;

import com.cdk.at.dao.CustomizerDAO;
import com.cdk.at.model.Customizer;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Collection;

public class CustomizerServiceTest {

    CustomizerService customizerService = new CustomizerService();

    Customizer customizer1 = new Customizer(1,"Pranav","Tyres",1,1000);
    Customizer customizer2 = new Customizer(2,"Nishant","Brakes",2,6000);
    Customizer customizer3 = new Customizer(3,"Avay","Tyres",3,4000);
    Customizer customizer4 = new Customizer(4,"Rahul","Wheels",4,3490);
    Collection<Customizer> list = new ArrayList<Customizer>();

    @Test
    public void testReadByCid() throws Exception {

        CustomizerDAO mock = Mockito.mock(CustomizerDAO.class);
        Mockito.when(mock.selectByCid(1)).thenReturn(customizer1);
        customizerService.setcustomizerDAO(mock);

        Customizer customizer = customizerService.readByCid(1);
        Assert.assertEquals(customizer,customizer1);
    }

    @Test
    public void testReadByCategory() throws Exception {
        list.add(customizer1);
        list.add(customizer2);
        list.add(customizer3);

        CustomizerDAO mock = Mockito.mock(CustomizerDAO.class);
        Mockito.when(mock.selectByCategory("Tyres")).thenReturn(list);
        customizerService.setcustomizerDAO(mock);

        Collection<Customizer> tyresList = customizerService.readByCategory("Tyres");
        Assert.assertEquals(tyresList,list);
    }
}
