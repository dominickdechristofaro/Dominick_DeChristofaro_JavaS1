/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/23/2019
 *  Description:    Interface for TShirt DAO.
 **************************************************************************************************/
package com.company.DominickDeChristofaroU1Capstone.dao;
import com.company.DominickDeChristofaroU1Capstone.model.TShirt;
import java.util.List;

public interface TShirtDao {
    // Transactional Methods
    TShirt addTShirt(TShirt tShirt);
    void updateTShirt(TShirt tShirt);
    void deleteTShirt(Long id);

    // Getter Methods
    TShirt getTShirt(Long id);
    List<TShirt> getAllTShirt();
    List<TShirt> getTShirtByColor(String color);
    List<TShirt> getTShirtBySize(String size);
}
