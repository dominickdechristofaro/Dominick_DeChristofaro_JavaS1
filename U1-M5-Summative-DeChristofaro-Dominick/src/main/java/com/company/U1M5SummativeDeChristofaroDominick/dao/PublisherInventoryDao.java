/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Publisher Data Access Object (DAO) Interface.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Publisher;
import java.util.List;

public interface PublisherInventoryDao {
    /**
     * Add a Publisher to the database.
     *
     * @param publisher The Publisher you would like to add to the database.
     * @return The Publisher added to the database.
     */
    Publisher addPublisher(Publisher publisher);

    /**
     * Get a single Publisher from the database.
     *
     * @param publisher_id The id of the Publisher you would like to get from the database.
     * @return The Publisher requested from the database.
     */
    Publisher getPublisher(int publisher_id);

    /**
     * A List of all Publisher's from the database.
     *
     * @return A List of all Publisher's from the database.
     */
    List<Publisher> getAllPublisher();

    /**
     * Update a Publisher in the database.
     *
     * @param publisher A Publisher object with a valid publisher_id with new
     *                  updated properties for the database.
     */
    void updatePublisher(Publisher publisher);

    /**
     * Delete a publisher from the database.
     *
     * @param publisher_id The Publisher id that you would like deleted from the database.
     */
    void deletePublisher(int publisher_id);
}
