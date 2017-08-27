package com.cdk.at.dao;

import com.cdk.at.model.Accessories;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AccessoriesDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Accessories selectByVin(Integer vin) {
        return entityManager.find(Accessories.class,vin);
    }

    public int save(Accessories accessories) {
        entityManager.persist(accessories);
        return accessories.getVin();
    }
}
