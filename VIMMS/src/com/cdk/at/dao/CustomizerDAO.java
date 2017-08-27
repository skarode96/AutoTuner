package com.cdk.at.dao;

import com.cdk.at.model.Customizer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class CustomizerDAO {

    @PersistenceContext
    EntityManager entityManager;

    public Customizer selectByCid(Integer cId) {
        System.out.println("in DAO");
        return entityManager.find(Customizer.class, cId);
    }

    public Collection<Customizer> selectAll() {
        return entityManager.createQuery("from Customizer").getResultList();
    }

    public Collection<Customizer> selectByCategory(String category) {
        System.out.println("in DAO");
        return entityManager.createQuery("from Customizer where category = " + "'" + category +"'").getResultList();

    }
}
