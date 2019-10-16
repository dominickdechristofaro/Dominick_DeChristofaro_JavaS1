package com.trilogyed.tasker.service;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {
    // Properties
    private TaskerDao taskerDao;
    private AdserverFeignClient adserverFeignClient;

    // Constructor
    @Autowired
    public TaskerServiceLayer(TaskerDao taskerDao, AdserverFeignClient adserverFeignClient) {
        this.taskerDao = taskerDao;
        this.adserverFeignClient = adserverFeignClient;
    }

    // Tasker API
    @Transactional
    public TaskViewModel addTask(TaskViewModel taskViewModel) {
        // Create a Task from the taskViewModel
        Task task = new Task();
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        // Add the task to the database
        task = taskerDao.addTask(task);

        // Set the id of the taskViewModel
        taskViewModel.setId(task.getId());

        // Get an advertisement through the Feign Client
        taskViewModel.setAdvertisement(adserverFeignClient.getAd());

        // Return the taskViewModel
        return taskViewModel;
    }

    public TaskViewModel getTask(int id) {
        // Get the Task from the database by ID
        Task task = taskerDao.getTask(id);

        if(task != null) {
            // Create a TaskViewModel from the taskId
            TaskViewModel tvm = new TaskViewModel();
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());

            // Get a ad from the AdServer and assign it to the TaskViewModel
            tvm.setAdvertisement(adserverFeignClient.getAd());

            // Return the TaskViewModel
            return tvm;
        } else {
            return null;
        }
    }

    public List<TaskViewModel> getAllTask() {
        // Get all tasks from the database
        List<Task> taskList = taskerDao.getAllTasks();

        // Create an empty list of TaskViewModel's
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        // Using every task from the taskList, return a TaskViewModel with ad
        taskList.forEach(task ->
        {
            TaskViewModel tvm = new TaskViewModel();
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(adserverFeignClient.getAd());
            taskViewModelList.add(tvm);
        });

        // Return the taskViewModelList with ad's
        return taskViewModelList;
    }

    public List<TaskViewModel> getTaskByCategory(String category) {
        // Get all tasks from the database
        List<Task> taskList = taskerDao.getTasksByCategory(category);

        // Create an empty list of TaskViewModel's
        List<TaskViewModel> taskViewModelList = new ArrayList<>();

        // Using every task from the taskList, return a TaskViewModel with ad
        taskList.forEach(task ->
        {
            TaskViewModel tvm = new TaskViewModel();
            tvm.setId(task.getId());
            tvm.setDescription(task.getDescription());
            tvm.setCreateDate(task.getCreateDate());
            tvm.setDueDate(task.getDueDate());
            tvm.setCategory(task.getCategory());
            tvm.setAdvertisement(adserverFeignClient.getAd());
            taskViewModelList.add(tvm);
        });

        // Return the taskViewModelList with ad's
        return taskViewModelList;
    }

    @Transactional
    public void updateTask(TaskViewModel taskViewModel) {
        // Create a new Task from the TaskViewModel
        Task task = new Task();
        task.setId(taskViewModel.getId());
        task.setDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        // Update the Task in the database
        taskerDao.updateTask(task);
    }

    @Transactional
    public void deleteTask(int id) {
        taskerDao.deleteTask(id);
    }
}
