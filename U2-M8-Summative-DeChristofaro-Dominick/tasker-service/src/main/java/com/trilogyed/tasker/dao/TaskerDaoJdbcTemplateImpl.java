package com.trilogyed.tasker.dao;
import com.trilogyed.tasker.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskerDaoJdbcTemplateImpl implements TaskerDao {
    // Prepared SQL Statements (Constants)
    public static final String INSERT_TASK_SQL =
            "INSERT INTO task (task_description, create_date, due_date, category) VALUES (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID_SQL =
            "SELECT * FROM task WHERE task_id = ?";
    public static final String SELECT_ALL_TASK_SQL =
            "SELECT * FROM task";
    public static final String SELECT_TASK_BY_CATEGORY_SQL =
            "SELECT * FROM task WHERE category = ?";
    public static final String UPDATE_TASK_SQL =
            "UPDATE task SET task_description = ?, create_date = ?, due_date = ?, category = ? WHERE task_id = ?";
    public static final String DELETE_TASK_BY_ID_SQL =
            "DELETE FROM task WHERE task_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public TaskerDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add a Task to the database.
     *
     * @param task The task to add to the database.
     * @return The task added to the database.
     */
    @Override
    @Transactional
    public Task addTask(Task task) {
        jdbcTemplate.update(INSERT_TASK_SQL,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory());
        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        task.setId(id);
        return task;
    }

    /**
     * Get a single Task from the database by id.
     *
     * @param id The id of the Task the user is querying for.
     * @return The Task with the id requested (if any).
     */
    @Override
    public Task getTask(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TASK_BY_ID_SQL, this::mapRowToTask, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Get all Tasks from the database into a single list.
     *
     * @return A List of all Tasks from the database.
     */
    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query(SELECT_ALL_TASK_SQL, this::mapRowToTask);
    }

    /**
     * Get all Tasks from the database that have the queried category.
     *
     * @param category The category of Tasks the user is querying.
     * @return A List of all tasks by queried category.
     */
    @Override
    public List<Task> getTasksByCategory(String category) {
        return jdbcTemplate.query(SELECT_TASK_BY_CATEGORY_SQL, this::mapRowToTask, category);
    }

    /**
     * Update a task in the database.
     *
     * @param task The task the user would like to update in the database.
     */
    @Override
    @Transactional
    public void updateTask(Task task) {
        jdbcTemplate.update(UPDATE_TASK_SQL,
                task.getDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory(),
                task.getId());
    }

    /**
     * Delete a Task by id from the database.
     *
     * @param id The id of the Task the user would like to delete from the database.
     */
    @Override
    @Transactional
    public void deleteTask(int id) {
        jdbcTemplate.update(DELETE_TASK_BY_ID_SQL, id);
    }

    /**
     * Map a row of the database to a Task object.
     *
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return A Task object retrieved from the database.
     * @throws SQLException Thrown if the object could not be retrieved from the database.
     */
    private Task mapRowToTask(ResultSet resultSet, int rowNumber) throws SQLException {
        Task task = new Task();
        task.setId(resultSet.getInt("task_id"));
        task.setDescription(resultSet.getString("task_description"));
        task.setCreateDate(resultSet.getDate("create_date").toLocalDate());
        task.setDueDate(resultSet.getDate("due_date").toLocalDate());
        task.setCategory(resultSet.getString("category"));
        return task;
    }
}
