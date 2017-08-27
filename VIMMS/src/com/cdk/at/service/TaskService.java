package com.cdk.at.service;

import com.cdk.at.dao.TaskDAO;
import com.cdk.at.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


@Service
public class TaskService {
    @Autowired
    TaskDAO taskDAO;


    @Transactional
    public int addTask(Task task) {
        System.out.println("in service");
        return taskDAO.save(task);
    }

    @Transactional
    public Task readByTid(Integer tId) {

        return taskDAO.selectByTid(tId);
    }

    @Transactional
    public Collection<Task> readAll(Integer vin) {
        System.out.println("in service");
        return taskDAO.selectAll(vin);
    }


    public void setTaskDAO(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }
}
