/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Implementation for Invoice DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    // Prepared SQL Statements (Constants)
    private static final String INSERT_INVOICE_SQL =
            "INSERT INTO invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, subtotal, tax, processing_fee, total) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_INVOICE_SQL =
            "SELECT * FROM invoice WHERE invoice_id = ?";
    private static final String SELECT_ALL_INVOICE_SQL =
            "SELECT * FROM invoice";
    private static final String UPDATE_INVOICE_SQL =
            "UPDATE invoice SET name = ?, street = ?, city = ?, state = ?, zipcode = ?, item_type = ?, item_id = ?, unit_price = ?, quantity = ?, subtotal = ?, tax = ?, processing_fee = ?, total = ? WHERE invoice_id = ?";
    private static final String DELETE_INVOICE_SQL =
            "DELETE FROM invoice WHERE invoice_id = ?";

    // Properties
    private JdbcTemplate jdbcTemplate;

    // Constructors
    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Add an Invoice to the database.
     * @param invoice The Invoice to add to the database.
     * @return The Invoice added to the database with an auto-generated id.
     */
    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal());
        Long id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
        invoice.setId(id);
        return invoice;
    }

    /**
     * Update an Invoice in the database.
     * @param invoice The Invoice to be updated in the database.
     */
    @Override
    @Transactional
    public void updateInvoice(Invoice invoice) {
        jdbcTemplate.update(UPDATE_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipcode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getSubtotal(),
                invoice.getTax(),
                invoice.getProcessingFee(),
                invoice.getTotal(),
                invoice.getId());
    }

    /**
     * Delete an Invoice in the database by id.
     * @param id The id of the Invoice to be deleted from the database.
     */
    @Override
    @Transactional
    public void deleteInvoice(Long id) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, id);
    }

    /**
     * Get an Invoice from the database by id.
     * @param id The id of the Invoice to be retrieved from the database.
     * @return The Invoice with the id requested from the database.
     */
    @Override
    public Invoice getInvoice(Long id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice, id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * A List of all Invoice's in the database.
     * @return A List of all Invoices in the database.
     */
    @Override
    public List<Invoice> getAllInvoice() {
        return jdbcTemplate.query(SELECT_ALL_INVOICE_SQL, this::mapRowToInvoice);
    }

    /**
     * Map a row of the database to an Invoice object.
     * @param resultSet The result set of parameters retrieved from the database.
     * @param rowNumber The row number retrieved from the database.
     * @return An Invoice object retrieved from the database.
     * @throws SQLException Thrown in the object could not be retrieved from the database.
     */
    private Invoice mapRowToInvoice(ResultSet resultSet, int rowNumber) throws SQLException {
        Invoice invoice = new Invoice();
        invoice.setId(resultSet.getLong("invoice_id"));
        invoice.setName(resultSet.getString("name"));
        invoice.setStreet(resultSet.getString("street"));
        invoice.setCity(resultSet.getString("city"));
        invoice.setState(resultSet.getString("state"));
        invoice.setZipcode(resultSet.getString("zipcode"));
        invoice.setItemType(resultSet.getString("item_type"));
        invoice.setItemId(resultSet.getLong("item_id"));
        invoice.setUnitPrice(resultSet.getBigDecimal("unit_price"));
        invoice.setQuantity(resultSet.getLong("quantity"));
        invoice.setSubtotal(resultSet.getBigDecimal("subtotal"));
        invoice.setTax(resultSet.getBigDecimal("tax"));
        invoice.setProcessingFee(resultSet.getBigDecimal("processing_fee"));
        invoice.setTotal(resultSet.getBigDecimal("total"));
        return invoice;
    }
}
