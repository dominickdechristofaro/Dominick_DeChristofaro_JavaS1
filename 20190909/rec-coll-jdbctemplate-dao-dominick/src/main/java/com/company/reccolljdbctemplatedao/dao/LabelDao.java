/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/06/2019
 *  Description:    Interface for Label DAO.
 *************************************************************************************************/
package com.company.reccolljdbctemplatedao.dao;
import com.company.reccolljdbctemplatedao.model.Label;
import java.util.List;

public interface LabelDao {
    // CRUD methods
    Label addLabel(Label label);
    Label getLabel(int id);
    List<Label> getAllLabels();
    void updateLabel(Label label);
    void deleteLabel(int id);
}
