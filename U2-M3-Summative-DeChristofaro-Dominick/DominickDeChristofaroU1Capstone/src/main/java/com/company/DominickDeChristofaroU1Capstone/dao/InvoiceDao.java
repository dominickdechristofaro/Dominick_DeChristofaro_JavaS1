/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Interface for Invoice DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.Invoice;
import java.util.List;

public interface InvoiceDao {
    /**
     * Add an Invoice to the database.
     * @param invoice The Invoice to add to the database.
     * @return The Invoice added to the database with an auto-generated id.
     */
    Invoice addInvoice(Invoice invoice);

    /**
     * Update an Invoice in the database.
     * @param invoice The Invoice to be updated in the database.
     */
    void updateInvoice(Invoice invoice);

    /**
     * Delete an Invoice in the database by id.
     * @param id The id of the Invoice to be deleted from the database.
     */
    void deleteInvoice(Long id);

    /**
     * Get an Invoice from the database by id.
     * @param id The id of the Invoice to be retrieved from the database.
     * @return The Invoice with the id requested from the database.
     */
    Invoice getInvoice(Long id);

    /**
     * A List of all Invoice's in the database.
     * @return A List of all Invoices in the database.
     */
    List<Invoice> getAllInvoice();
}
