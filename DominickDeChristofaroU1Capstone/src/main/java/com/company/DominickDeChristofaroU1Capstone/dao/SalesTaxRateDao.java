/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
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
     * @param salesTaxRate
     */
    void updateSalesTaxRateByState(SalesTaxRate salesTaxRate);
    void deleteSalesTaxRateByState(String state);

    // Getter Methods
    SalesTaxRate getSalesTaxRateByState(String state);
    List<SalesTaxRate> getAllSalesTaxRate();
}
