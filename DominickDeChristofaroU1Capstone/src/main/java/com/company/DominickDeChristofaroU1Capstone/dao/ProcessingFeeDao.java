/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Interface for ProcessingFee DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.ProcessingFee;
import java.util.List;

public interface ProcessingFeeDao {
    /**
     * Add a ProcessingFee to the database.
     * @param processingFee The ProcessingFee to add to the database.
     * @return The ProcessingFee added to the database.
     */
    ProcessingFee addProcessingFee(ProcessingFee processingFee);

    /**
     * Update a ProcessingFee in the database by productType.
     * @param processingFee The ProcessingFee to be updated in the database by productType.
     */
    void updateProcessingFeeByProductType(ProcessingFee processingFee);

    /**
     * Delete a ProcessingFee in the database by productType.
     * @param productType The productType of the ProcessingFee to be deleted from the database.
     */
    void deleteProcessingFeeByProductType(String productType);

    /**
     * Get a ProcessingFee from the database by productType.
     * @param productType The productType of the ProcessingFee to be retrieved from the database.
     * @return The ProcessingFee with the productType requested from the database.
     */
    ProcessingFee getProcessingFeeByProductType(String productType);

    /**
     * A List of all ProcessingFee's in the database.
     * @return A List of all ProcessingFee's in the database.
     */
    List<ProcessingFee> getAllProcessingFee();
}
