/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Interface for Publisher DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Publisher;
import java.util.List;

public interface PublisherInventoryDao {
    // CRUD Methods
    Publisher addPublisher(Publisher publisher);
    Publisher getPublisher(int publisher_id);
    List<Publisher> getAllPublisher();
    void updatePublisher(Publisher publisher);
    void deletePublisher(int publisher_id);
}
