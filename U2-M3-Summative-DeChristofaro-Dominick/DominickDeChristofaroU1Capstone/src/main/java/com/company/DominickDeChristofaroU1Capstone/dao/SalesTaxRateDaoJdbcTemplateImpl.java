/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Implementation for SalesTaxRate DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.SalesTaxRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SalesTaxRateDaoJdbcTemplateImpl implements SalesTaxRateDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_SALES_TAX_RATE_SQL =
            "INSERT INTO sales_tax_rate (state, rate) VALUES (?,?)";
    private static final String SELECT_SALES_TAX_RATE_BY_STATE_SQL =
            "SELECT * FROM sales_tax_rate WHERE state = ?";
    private static final String SELECT_ALL_SALES_TAX_RATE_SQL =
            "SELECT * FROM sales_tax_rate";
    private static final String UPDATE_SALES_TAX_RATE_SQL =
            "UPDATE sales_tax_rate SET rate = ? WHERE state = ?";
    private static final String DELETE_SALES_TAX_RATE_SQL =
            "DELETE FROM sales_tax_rate WHERE state = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructor
    @Autowired
    public SalesTaxRateDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Transactional Methods
    @Override
    @Transactional
    /**
     * Add a SalesTaxRate to the database.
     * @param salesTaxRate The SalesTaxRate to add to the database.
     * @return The SalesTaxRate added to the database.
     */
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());
        return salesTaxRate;
    }

    @Override
    @Transactional
    /**
     * Update a SalesTaxRate in the database by state.
     * @param salesTaxRate
     */
    public void updateSalesTaxRateByState(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState());
    }

    @Override
    @Transactional
    /**
     * Delete a SalesTaxRate in the database by state.
     * @param state The state to be deleted in the database.
     */
    public void deleteSalesTaxRateByState(String state) {
        jdbcTemplate.update(DELETE_SALES_TAX_RATE_SQL, state);
    }

    // Getter Methods
    @Override
    /**
     * Get a SalesTaxRate in the database by state.
     * @param state The state to query from the database.
     * @return The SalesTaxRate from the database that corresponds to the state queried.
     */
    public SalesTaxRate getSalesTaxRateByState(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_BY_STATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    /**
     * A List of all SalesTaxRates in the database.
     * @return A List of all SalesTaxRates in the database.
     */
    public List<SalesTaxRate> getAllSalesTaxRate() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate);
    }

    /**
     * Map a row of the database to a SalesTaxRate object.
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return A SalesTaxRate object retrieved from the database.
     * @throws SQLException Thrown if the object could not be retrieved from the database.
     */
    private SalesTaxRate mapRowToSalesTaxRate(ResultSet resultSet, int rowNumber) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(resultSet.getString("state"));
        salesTaxRate.setRate(resultSet.getBigDecimal("rate"));
        return salesTaxRate;
    }
}
