package com.trilogyed.tasker.dao;
import com.trilogyed.tasker.model.Task;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoTest {
    // Autowired DAO's
    @Autowired
    private TaskerDao taskerDao;

    // setUp()
    @Before
    public void setUp() throws Exception {
        // Clean up the task table in the database
        List<Task> taskList = taskerDao.getAllTasks();
        taskList.forEach(task -> taskerDao.deleteTask(task.getId()));
    }

    // Tests
    @Test
    public void addTask() {
        // Create a new Task object and add it to the database
        Task task = new Task();
        task.setDescription("Clean Bathroom");
        task.setCreateDate(LocalDate.of(2019, 10, 1));
        task.setDueDate(LocalDate.of(2019,10,2));
        task.setCategory("Cleaning");
        task = taskerDao.addTask(task);

        // Create a copy of the newly added Task object
        Task taskCopy = taskerDao.getTask(task.getId());

        // Test addTask() method
        TestCase.assertEquals(taskCopy, task);
    }

    @Test
    public void getTask() {
        // Create a new Task object and add it to the database
        Task task = new Task();
        task.setDescription("Clean Bathroom");
        task.setCreateDate(LocalDate.of(2019, 10, 1));
        task.setDueDate(LocalDate.of(2019,10,2));
        task.setCategory("Cleaning");
        task = taskerDao.addTask(task);

        // Create a copy of the newly added Task object
        Task taskCopy = taskerDao.getTask(task.getId());

        // Test getTask() method
        TestCase.assertEquals(taskCopy, task);
    }

    @Test
    public void getAllTasks() {
        // Create a new Task object and add it to the database
        Task task1 = new Task();
        task1.setDescription("Clean Bathroom");
        task1.setCreateDate(LocalDate.of(2019, 10, 1));
        task1.setDueDate(LocalDate.of(2019,10,2));
        task1.setCategory("Cleaning");
        task1 = taskerDao.addTask(task1);

        // Create a second Task object and add it to the database
        Task task2 = new Task();
        task2.setDescription("Stock Groceries");
        task2.setCreateDate(LocalDate.of(2019, 10, 1));
        task2.setDueDate(LocalDate.of(2019,10,2));
        task2.setCategory("Stocking");
        task2 = taskerDao.addTask(task2);

        // Gather all Task's into a list
        List<Task> taskList = taskerDao.getAllTasks();

        // Test getAllTasks() method
        TestCase.assertEquals(2, taskList.size());
    }

    @Test
    public void getTaskByCategory() {
        // Create a new Task object and add it to the database
        Task task1 = new Task();
        task1.setDescription("Clean Bathroom");
        task1.setCreateDate(LocalDate.of(2019, 10, 1));
        task1.setDueDate(LocalDate.of(2019,10,2));
        task1.setCategory("Cleaning");
        task1 = taskerDao.addTask(task1);

        // Create a second Task object and add it to the database
        Task task2 = new Task();
        task2.setDescription("Stock Groceries");
        task2.setCreateDate(LocalDate.of(2019, 10, 1));
        task2.setDueDate(LocalDate.of(2019,10,2));
        task2.setCategory("Stocking");
        task2 = taskerDao.addTask(task2);

        // Create a third Task object and add it to the database
        Task task3 = new Task();
        task3.setDescription("Stock Underwear");
        task3.setCreateDate(LocalDate.of(2019, 10, 1));
        task3.setDueDate(LocalDate.of(2019,10,2));
        task3.setCategory("Stocking");
        task3 = taskerDao.addTask(task3);

        // Create a List of all Cleaning Tasks
        List<Task> taskListOfCleaning = taskerDao.getTasksByCategory("Cleaning");

        // Create a List of all Stocking Tasks
        List<Task> taskListOfStocking = taskerDao.getTasksByCategory("Stocking");

        // Test getTasksByCategory() method
        TestCase.assertEquals(1, taskListOfCleaning.size());
        TestCase.assertEquals(2, taskListOfStocking.size());
    }

    @Test
    public void updateTask() {
        // Create a new Task object and add it to the database
        Task task = new Task();
        task.setDescription("Clean Bathroom");
        task.setCreateDate(LocalDate.of(2019, 10, 1));
        task.setDueDate(LocalDate.of(2019,10,2));
        task.setCategory("Cleaning");
        task = taskerDao.addTask(task);

        // Update the task description
        task.setDescription("Updated Description");

        // Update the task in the database
        taskerDao.updateTask(task);

        // Make a copy of the updated Task
        Task taskCopy = taskerDao.getTask(task.getId());

        // Test the updateTask() method
        TestCase.assertEquals(task, taskCopy);
    }

    @Test
    public void deleteTask() {
        // Create a new Task object and add it to the database
        Task task = new Task();
        task.setDescription("Clean Bathroom");
        task.setCreateDate(LocalDate.of(2019, 10, 1));
        task.setDueDate(LocalDate.of(2019,10,2));
        task.setCategory("Cleaning");
        task = taskerDao.addTask(task);

        // Delete the Task from the database
        taskerDao.deleteTask(task.getId());

        // Try to get a copy of the deleted task (should return null)
        Task taskCopy = taskerDao.getTask(task.getId());

        // Test deleteTask() method
        TestCase.assertNull(taskCopy);
    }
}
