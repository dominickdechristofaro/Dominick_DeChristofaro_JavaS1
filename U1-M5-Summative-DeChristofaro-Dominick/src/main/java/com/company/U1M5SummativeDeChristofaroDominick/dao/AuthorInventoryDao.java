/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Author Data Access Object (DAO) Interface.
 **************************************************************************************************/
package com.company.U1M5SummativeDeChristofaroDominick.dao;
import com.company.U1M5SummativeDeChristofaroDominick.model.Author;
import java.util.List;

public interface AuthorInventoryDao {
    // CRUD Methods
    /**
     * Add an Author to the database.
     *
     * @param author The Author you would like to add to the database.
     * @return The Author you added to the database.
     */
    Author addAuthor(Author author);

    /**
     * Get a single Author from the database.
     *
     * @param author_id The id of the Author you would like to retrieve from the database.
     * @return The Author requested from the database.
     */
    Author getAuthor(int author_id);

    /**
     * A List of all the Author's in the database.
     *
     * @return A List of all the Author's in the database.
     */
    List<Author> getAllAuthor();

    /**
     * Update an Author in the database.
     *
     * @param author An Author object you would like to update in the database.
     */
    void updateAuthor(Author author);

    /**
     * Delete an Author from the database.
     *
     * @param author_id The id of the Author you would like to delete.
     */
    void deleteAuthor(int author_id);
}
