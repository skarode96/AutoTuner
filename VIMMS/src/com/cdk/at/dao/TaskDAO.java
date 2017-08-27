package com.cdk.at.dao;

import com.cdk.at.model.Customizer;
import com.cdk.at.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class TaskDAO {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public int save(Task task) {
        System.out.println("in DAO");
        entityManager.persist(task);
        return task.gettId();
    }

    @Transactional
    public Task selectByTid(Integer tId) {
        return entityManager.find(Task.class, tId);
    }

    public Collection<Task> selectAll(Integer vin) {
        System.out.println("in DAO");
        /*int vin = task.getVin();
        Car car = (Car) entityManager.createQuery("from Car where Car.vin = vin").getSingleResult();*/

        return entityManager.createQuery("from Task task where task.vin = "+vin).getResultList();


    }
}
