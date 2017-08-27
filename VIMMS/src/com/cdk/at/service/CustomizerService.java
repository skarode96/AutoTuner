package com.cdk.at.service;

import com.cdk.at.dao.CustomizerDAO;
import com.cdk.at.model.Customizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class CustomizerService {
    @Autowired
    CustomizerDAO customizerDAO;

    @Transactional
    public Customizer readByCid(Integer cId) {
        System.out.println("in service");
        return customizerDAO.selectByCid(cId);
    }

    @Transactional
    public Collection<Customizer> readAll() {
        return customizerDAO.selectAll();
    }

    public Collection<Customizer> readByCategory(String category) {
        System.out.println("in Category");
        return customizerDAO.selectByCategory(category);
    }

    public void setcustomizerDAO(CustomizerDAO customizerDAO) {
        this.customizerDAO = customizerDAO;
    }
}
