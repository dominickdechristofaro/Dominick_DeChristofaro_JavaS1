/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Interface for SalesTaxRate DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.SalesTaxRate;
import java.util.List;

public interface SalesTaxRateDao {
    /**
     * Add a SalesTaxRate to the database.
     * @param salesTaxRate The SalesTaxRate to add to the database.
     * @return The SalesTaxRate added to the database.
     */
    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);

    /**
     * Update a SalesTaxRate in the database by state.
     * @param salesTaxRate The SalesTaxRate to update in the database.
     */
    void updateSalesTaxRateByState(SalesTaxRate salesTaxRate);

    /**
     * Delete a SalesTaxRate in the database by state.
     * @param state The state to be deleted in the database.
     */
    void deleteSalesTaxRateByState(String state);

    /**
     * Get a SalesTaxRate in the database by state.
     * @param state The state to query from the database.
     * @return The SalesTaxRate from the database that corresponds to the state queried.
     */
    SalesTaxRate getSalesTaxRateByState(String state);

    /**
     * A List of all SalesTaxRates in the database.
     * @return A List of all SalesTaxRates in the database.
     */
    List<SalesTaxRate> getAllSalesTaxRate();
}
