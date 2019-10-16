package com.trilogyed.tasker.service;
import com.trilogyed.tasker.dao.TaskerDao;
import com.trilogyed.tasker.dao.TaskerDaoJdbcTemplateImpl;
import com.trilogyed.tasker.model.Task;
import com.trilogyed.tasker.model.TaskViewModel;
import com.trilogyed.tasker.util.feign.AdserverFeignClient;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskerServiceLayerTest {
    // Properties
    private TaskerServiceLayer taskerServiceLayer;
    private TaskerDao taskerDao;
    private AdserverFeignClient adserverFeignClient;
    private ArgumentCaptor<Task> taskArgumentCaptor = ArgumentCaptor.forClass(Task.class);
    private ArgumentCaptor<Integer> integerArgumentCaptor = ArgumentCaptor.forClass(Integer.class);

    // SetUp()
    @Before
    public void setUp() throws Exception {
        setUpTaskerDaoMock();
        setUpAdserverFeignClientMock();
        taskerServiceLayer = new TaskerServiceLayer(taskerDao, adserverFeignClient);
    }

    // Tests
    @Test
    public void addTask() {
        // Build a TaskViewModel to pass addTask()
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setDescription("Description 1");
        taskViewModel.setCreateDate(LocalDate.of(2019, 10, 4));
        taskViewModel.setDueDate(LocalDate.of(2019,10,5));
        taskViewModel.setCategory("Cleaning");

        // Pass the taskViewModel to the addTask()
        taskViewModel = taskerServiceLayer.addTask(taskViewModel);

        // Add an advertisement to the taskViewModel
        taskViewModel.setAdvertisement(adserverFeignClient.getAd());

        // Create a copy of the taskViewModel
        TaskViewModel taskViewModelCopy = taskerServiceLayer.getTask(taskViewModel.getId());

        // Test addTask() method
        TestCase.assertEquals(taskViewModel, taskViewModelCopy);
    }

    @Test
    public void getTask() {
        // Build a TaskViewModel to pass addTask()
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setDescription("Description 1");
        taskViewModel.setCreateDate(LocalDate.of(2019, 10, 4));
        taskViewModel.setDueDate(LocalDate.of(2019,10,5));
        taskViewModel.setCategory("Cleaning");

        // Pass the taskViewModel to the addTask()
        taskViewModel = taskerServiceLayer.addTask(taskViewModel);

        // Add an advertisement to the taskViewModel
        taskViewModel.setAdvertisement(adserverFeignClient.getAd());

        // Create a copy of the taskViewModel
        TaskViewModel taskViewModelCopy = taskerServiceLayer.getTask(taskViewModel.getId());

        // Test addTask() method
        TestCase.assertEquals(taskViewModel, taskViewModelCopy);
    }

    @Test
    public void getAllTask() {
        // Get all Tasks from the database
        List<TaskViewModel> allTaskList = taskerServiceLayer.getAllTask();

        // Pull the tasks from the database
        TaskViewModel taskViewModel1 = taskerServiceLayer.getTask(1);
        taskViewModel1.setAdvertisement(adserverFeignClient.getAd());
        TaskViewModel taskViewModel2 = taskerServiceLayer.getTask(2);
        taskViewModel2.setAdvertisement(adserverFeignClient.getAd());
        TaskViewModel taskViewModel3 = taskerServiceLayer.getTask(3);
        taskViewModel3.setAdvertisement(adserverFeignClient.getAd());

        // Test the getAllTask() method
        TestCase.assertEquals(3, allTaskList.size());
        TestCase.assertEquals(taskViewModel1, allTaskList.get(0));
        TestCase.assertEquals(taskViewModel2, allTaskList.get(1));
        TestCase.assertEquals(taskViewModel3, allTaskList.get(2));
    }

    @Test
    public void getTaskByCategory() {
        // Get all Cleaning Tasks into a List
        List<TaskViewModel> cleaningTaskList = taskerServiceLayer.getTaskByCategory("Cleaning");

        // Get all Stocking Tasks into a List
        List<TaskViewModel> stockingTaskList = taskerServiceLayer.getTaskByCategory("Stocking");

        // Pull the tasks from the database
        TaskViewModel taskViewModel1 = taskerServiceLayer.getTask(1);
        taskViewModel1.setAdvertisement(adserverFeignClient.getAd());
        TaskViewModel taskViewModel2 = taskerServiceLayer.getTask(2);
        taskViewModel2.setAdvertisement(adserverFeignClient.getAd());
        TaskViewModel taskViewModel3 = taskerServiceLayer.getTask(3);
        taskViewModel3.setAdvertisement(adserverFeignClient.getAd());

        // Test the getTaskByCategory()
        TestCase.assertEquals(1, cleaningTaskList.size());
        TestCase.assertEquals(2, stockingTaskList.size());
        TestCase.assertEquals(taskViewModel1, cleaningTaskList.get(0));
        TestCase.assertEquals(taskViewModel2, stockingTaskList.get(0));
        TestCase.assertEquals(taskViewModel3, stockingTaskList.get(1));
    }

    @Test
    public void updateTask() {
        // Pull the tasks from the database and build a taskViewModel
        TaskViewModel taskViewModel = taskerServiceLayer.getTask(1);
        taskViewModel.setAdvertisement(adserverFeignClient.getAd());

        // Update a Task in the database using a taskViewModel
        taskerServiceLayer.updateTask(taskViewModel);

        // Test the updateTask() method
        Mockito.verify(taskerDao, Mockito.times(1)).updateTask(taskArgumentCaptor.getValue());

        // Create a TaskViewModel from the taskArgumentCaptor()
        TaskViewModel taskViewModelCopy = new TaskViewModel();
        taskViewModelCopy.setId(taskArgumentCaptor.getValue().getId());
        taskViewModelCopy.setDescription(taskArgumentCaptor.getValue().getDescription());
        taskViewModelCopy.setCreateDate(taskArgumentCaptor.getValue().getCreateDate());
        taskViewModelCopy.setDueDate(taskArgumentCaptor.getValue().getDueDate());
        taskViewModelCopy.setCategory(taskArgumentCaptor.getValue().getCategory());
        taskViewModelCopy.setAdvertisement(adserverFeignClient.getAd());

        TestCase.assertEquals(taskViewModel, taskViewModelCopy);
    }

    @Test
    public void deleteTask() {
        // Build a TaskViewModel to pass addTask()
        TaskViewModel taskViewModel = new TaskViewModel();
        taskViewModel.setDescription("Description 1");
        taskViewModel.setCreateDate(LocalDate.of(2019, 10, 4));
        taskViewModel.setDueDate(LocalDate.of(2019,10,5));
        taskViewModel.setCategory("Cleaning");

        // Pass the taskViewModel to the addTask()
        taskViewModel = taskerServiceLayer.addTask(taskViewModel);

        // Delete the Task from the database
        taskerServiceLayer.deleteTask(taskViewModel.getId());

        // Test the deleteTask() method
        Mockito.verify(taskerDao, Mockito.times(1)).deleteTask(integerArgumentCaptor.getValue());
        TestCase.assertEquals(taskViewModel.getId(), integerArgumentCaptor.getValue().intValue());
    }

    // Mocks
    private void setUpTaskerDaoMock() {
        // Set up the TaskerDao Mock
        taskerDao = Mockito.mock(TaskerDaoJdbcTemplateImpl.class);

        // Task Inputs
        Task taskInput1 = new Task("Description 1", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Cleaning");
        Task taskInput2 = new Task("Description 2", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Stocking");
        Task taskInput3 = new Task("Description 3", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Stocking");

        // Task Responses
        Task taskResponse1 = new Task(1,"Description 1", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Cleaning");
        Task taskResponse2 = new Task(2,"Description 2", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Stocking");
        Task taskResponse3 = new Task(3,"Description 3", LocalDate.of(2019, 10, 4), LocalDate.of(2019,10,5), "Stocking");

        // Task List
        List<Task> allTaskList = new ArrayList<>();
        allTaskList.add(taskResponse1);
        allTaskList.add(taskResponse2);
        allTaskList.add(taskResponse3);

        // Task List By Category (Cleaning)
        List<Task> cleaningTaskList = new ArrayList<>();
        cleaningTaskList.add(taskResponse1);

        // Task List by Category (Stocking)
        List<Task> stockingTaskList = new ArrayList<>();
        stockingTaskList.add(taskResponse2);
        stockingTaskList.add(taskResponse3);

        // Mocking addTask()
        Mockito.doReturn(taskResponse1).when(taskerDao).addTask(taskInput1);
        Mockito.doReturn(taskResponse2).when(taskerDao).addTask(taskInput2);
        Mockito.doReturn(taskResponse3).when(taskerDao).addTask(taskInput3);

        // Mocking getTask()
        Mockito.doReturn(taskResponse1).when(taskerDao).getTask(taskResponse1.getId());
        Mockito.doReturn(taskResponse2).when(taskerDao).getTask(taskResponse2.getId());
        Mockito.doReturn(taskResponse3).when(taskerDao).getTask(taskResponse3.getId());

        // Mocking getAllTasks()
        Mockito.doReturn(allTaskList).when(taskerDao).getAllTasks();

        // Mocking getTasksByCategory()
        Mockito.doReturn(cleaningTaskList).when(taskerDao).getTasksByCategory(taskResponse1.getCategory());
        Mockito.doReturn(stockingTaskList).when(taskerDao).getTasksByCategory(taskResponse2.getCategory());

        // Mocking updateTask()
        Mockito.doNothing().when(taskerDao).updateTask(taskArgumentCaptor.capture());

        // Mocking deleteTask()
        Mockito.doNothing().when(taskerDao).deleteTask(integerArgumentCaptor.capture());
    }

    private void setUpAdserverFeignClientMock() {
        // Set up the AdserverFeignClient Mock
        adserverFeignClient = Mockito.mock(AdserverFeignClient.class);

        // Mocking
        Mockito.doReturn("Test Advertisement").when(adserverFeignClient).getAd();
    }
}
