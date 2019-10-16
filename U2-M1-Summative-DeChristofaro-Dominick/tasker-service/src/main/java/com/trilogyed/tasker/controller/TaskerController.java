package com.trilogyed.tasker.controller;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.service.TaskerServiceLayer;
import com.trilogyed.tasker.util.feign.AdserverFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class TaskerController {
    // Properties
    private TaskerServiceLayer service;

    // Constructors
    @Autowired
    public TaskerController(TaskerServiceLayer service) {
        this.service = service;
    }

    // Methods
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TaskViewModel addTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        return service.addTask(taskViewModel);
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TaskViewModel getTask(@PathVariable int id) {
        // Find the Task requested in the database
        TaskViewModel taskViewModelFromDB = service.getTask(id);

        // Return the Task if it is found in the database
        if (taskViewModelFromDB != null) {
            return taskViewModelFromDB;
        } else {
            throw new IllegalArgumentException("There is no Task with id: " + id + ".");
        }
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getAllTasks() {
        return service.getAllTask();
    }

    @RequestMapping(value = "/tasks/category/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<TaskViewModel> getTasksByCategory(@PathVariable String category) {
        return service.getTaskByCategory(category);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody @Valid TaskViewModel taskViewModel) {
        // Get the TaskViewModel from the database
        TaskViewModel taskViewModelFromDB = service.getTask(taskViewModel.getId());

        // Update the TaskViewModel if the task is found in the database
        if (taskViewModelFromDB == null) {
            throw new IllegalArgumentException("There is no task with id " + taskViewModel.getId() + ".");
        } else {
            service.updateTask(taskViewModel);
        }
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id) {
        // Get the requested Task from the database
        TaskViewModel taskViewModelFromDB = service.getTask(id);

        // Delete Task if it is found in the database
        if (taskViewModelFromDB == null) {
            throw new IllegalArgumentException("There is no task with id " + id + ".");
        } else {
            service.deleteTask(id);
        }
    }
}
