/* ************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           09/08/2019
 *  Description:    Interface for Type DAO.
 **************************************************************************************************/
package com.company.VideoGameCollectionDaoDominickDeChristofaro.dao;
import com.company.VideoGameCollectionDaoDominickDeChristofaro.model.Type;
import java.util.List;

public interface TypeInventoryDao {
    // CRUD Methods
    Type addType(Type type);
    Type getType(int type_id);
    List<Type> getAllType();
    void updateType(Type type);
    void deleteType(int type_id);
}
