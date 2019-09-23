/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
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
    public SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(INSERT_SALES_TAX_RATE_SQL,
                salesTaxRate.getState(),
                salesTaxRate.getRate());
        return salesTaxRate;
    }

    @Override
    @Transactional
    public void updateSalesTaxRateByState(SalesTaxRate salesTaxRate) {
        jdbcTemplate.update(UPDATE_SALES_TAX_RATE_SQL,
                salesTaxRate.getRate(),
                salesTaxRate.getState());
    }

    @Override
    @Transactional
    public void deleteSalesTaxRateByState(String state) {
        jdbcTemplate.update(DELETE_SALES_TAX_RATE_SQL, state);
    }

    // Getter Methods
    @Override
    public SalesTaxRate getSalesTaxRateByState(String state) {
        try {
            return jdbcTemplate.queryForObject(SELECT_SALES_TAX_RATE_BY_STATE_SQL, this::mapRowToSalesTaxRate, state);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SalesTaxRate> getAllSalesTaxRate() {
        return jdbcTemplate.query(SELECT_ALL_SALES_TAX_RATE_SQL, this::mapRowToSalesTaxRate);
    }

    // Helper Methods
    private SalesTaxRate mapRowToSalesTaxRate(ResultSet resultSet, int rowNumber) throws SQLException {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState(resultSet.getString("state"));
        salesTaxRate.setRate(resultSet.getBigDecimal("rate"));
        return salesTaxRate;
    }
}
