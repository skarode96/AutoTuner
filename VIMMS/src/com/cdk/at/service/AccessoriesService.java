package com.cdk.at.service;

import com.cdk.at.dao.AccessoriesDAO;
import com.cdk.at.model.Accessories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AccessoriesService {
    @Autowired
    AccessoriesDAO accessoriesDAO;

    @Transactional
    public Accessories readByVin(Integer vin) {
        return accessoriesDAO.selectByVin(vin);
    }

    @Transactional
    public int addAccessories(Accessories accessories) {
        return accessoriesDAO.save(accessories);
    }
}
