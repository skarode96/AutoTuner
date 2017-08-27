package com.cdk.at.service;

import com.cdk.at.dao.TaskDAO;
import com.cdk.at.model.Task;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

public class TaskServiceTest {

    TaskService taskService = new TaskService();

    Task task1 = new Task(1,"Paint Job",12,3,4000);
    Task task2 = new Task(2,"Tyres",11,2,6000);

    @Test
    public void testAdd() throws Exception {
        TaskDAO mock = Mockito.mock(TaskDAO.class);
        Mockito.when(mock.save(task1)).thenReturn(task1.gettId());
        taskService.setTaskDAO(mock);

        int taskTid1 = taskService.addTask(task1);
        Assert.assertEquals(taskTid1,task1.gettId());
    }

    @Test
    public void testReadByTid() throws Exception {
        TaskDAO mock = Mockito.mock(TaskDAO.class);
        Mockito.when(mock.selectByTid(1)).thenReturn(task1);
        taskService.setTaskDAO(mock);

        Task task = taskService.readByTid(1);
        Assert.assertEquals(task,task1);
    }
}
