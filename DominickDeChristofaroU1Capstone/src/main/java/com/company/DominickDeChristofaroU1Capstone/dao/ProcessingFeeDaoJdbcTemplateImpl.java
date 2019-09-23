/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Implementation for ProcessingFee DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.ProcessingFee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProcessingFeeDaoJdbcTemplateImpl implements ProcessingFeeDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_PROCESSING_FEE_SQL =
            "INSERT INTO processing_fee (product_type, fee) VALUES (?,?)";
    private static final String SELECT_PROCESSING_FEE_SQL =
            "SELECT * FROM processing_fee WHERE product_type = ?";
    private static final String SELECT_ALL_PROCESSING_FEE_SQL =
            "SELECT * FROM processing_fee";
    private static final String UPDATE_PROCESSING_FEE_SQL =
            "UPDATE processing_fee SET fee = ? WHERE product_type = ?";
    private static final String DELETE_PROCESSING_FEE_SQL =
            "DELETE FROM processing_fee WHERE product_type = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public ProcessingFeeDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add a ProcessingFee to the database.
     * @param processingFee The ProcessingFee to add to the database.
     * @return The ProcessingFee added to the database.
     */
    @Override
    @Transactional
    public ProcessingFee addProcessingFee(ProcessingFee processingFee) {
        jdbcTemplate.update(INSERT_PROCESSING_FEE_SQL,
                processingFee.getProductType(),
                processingFee.getFee());
        return processingFee;
    }

    /**
     * Update a ProcessingFee in the database by productType.
     * @param processingFee The ProcessingFee to be updated in the database by productType.
     */
    @Override
    @Transactional
    public void updateProcessingFeeByProductType(ProcessingFee processingFee) {
        jdbcTemplate.update(UPDATE_PROCESSING_FEE_SQL,
                processingFee.getFee(),
                processingFee.getProductType());
    }

    /**
     * Delete a ProcessingFee in the database by productType.
     * @param productType The productType of the ProcessingFee to be deleted from the database.
     */
    @Override
    @Transactional
    public void deleteProcessingFeeByProductType(String productType) {
        jdbcTemplate.update(DELETE_PROCESSING_FEE_SQL, productType);
    }

    /**
     * Get a ProcessingFee from the database by productType.
     * @param productType The productType of the ProcessingFee to be retrieved from the database.
     * @return The ProcessingFee with the productType requested from the database.
     */
    @Override
    public ProcessingFee getProcessingFeeByProductType(String productType) {
        try {
            return jdbcTemplate.queryForObject(SELECT_PROCESSING_FEE_SQL, this::mapRowToProcessingFee, productType);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * A List of all ProcessingFee's in the database.
     * @return A List of all ProcessingFee's in the database.
     */
    @Override
    public List<ProcessingFee> getAllProcessingFee() {
        return jdbcTemplate.query(SELECT_ALL_PROCESSING_FEE_SQL, this::mapRowToProcessingFee);
    }

    /**
     * Map a row of the database to an ProcessingFee object.
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return An ProcessingFee object retrieved from the database.
     * @throws SQLException Thrown in the object could not be retrieved from the database.
     */
    private ProcessingFee mapRowToProcessingFee(ResultSet resultSet, int rowNumber) throws SQLException {
        ProcessingFee processingFee = new ProcessingFee();
        processingFee.setProductType(resultSet.getString("product_type"));
        processingFee.setFee(resultSet.getBigDecimal("fee"));
        return processingFee;
    }
}
