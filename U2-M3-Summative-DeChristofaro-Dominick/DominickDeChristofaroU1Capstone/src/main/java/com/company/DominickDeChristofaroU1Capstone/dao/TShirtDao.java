/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           10/15/2019
 *  Description:    Interface for TShirt DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import java.util.List;

public interface TShirtDao {
    /**
     * Add a TShirt to the database.
     * @param tShirt The TShirt to add to the database.
     * @return The TShirt added to the database.
     */
    TShirt addTShirt(TShirt tShirt);

    /**
     * Update a TShirt in the database.
     * @param tShirt The TShirt to update in the database.
     */
    void updateTShirt(TShirt tShirt);

    /**
     * Delete a TShirt in the database.
     * @param id The id of the TShirt to delete in the database.
     */
    void deleteTShirt(Long id);

    /**
     * Get a TShirt from the database by id.
     * @param id The id of the TShirt to retrieve from the database.
     * @return The TShirt that the user requested from the database.
     */
    TShirt getTShirt(Long id);

    /**
     * A List of all TShirts in the database.
     * @return A List of all TShirts in the database.
     */
    List<TShirt> getAllTShirt();

    /**
     * A List of all TShirts in the database by a specific color.
     * @param color The color of TShirts to be queried from the database.
     * @return A List of TShirts of queried color.
     */
    List<TShirt> getTShirtByColor(String color);

    /**
     * A List of all TShirts in the database by a specific size.
     * @param size The size of TShirts to be queried from the database.
     * @return A List of TShirts of queried size.
     */
    List<TShirt> getTShirtBySize(String size);
}
