package com.cdk.at.controller;

import com.cdk.at.model.Task;
import com.cdk.at.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Collection;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@RestController
public class TaskResourceController {
    @Autowired
    TaskService taskService;

    @RequestMapping(value = "/task/{tId}", produces = APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Task readTaskByVinAsJson(@PathVariable Integer tId) {
        System.out.println("In get method");
        Task task = taskService.readByTid(tId);
        return task;
    }



    @RequestMapping(value = "/addtask",consumes = APPLICATION_JSON_VALUE ,produces = TEXT_PLAIN_VALUE ,method = RequestMethod.POST)
    public String addTaskFromUI(@RequestBody Task task){
        System.out.println("in controller");
        int value = taskService.addTask(task);
        return "Task for tid '"+value+" ' added successfully!";
    }


    @RequestMapping(value = "/report/{vin}",produces = APPLICATION_JSON_VALUE ,method = RequestMethod.GET)
    public Collection<Task> reportGeneration(@PathVariable Integer vin){
        System.out.println("in controller");
        return taskService.readAll(vin);
    }



}
