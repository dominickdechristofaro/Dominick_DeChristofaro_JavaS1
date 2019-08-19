/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    ClassmatesList is a list of Classmates.
 *************************************************************************************************/
package com.company;
import java.util.ArrayList;

public class ClassmatesList {
    // Variables
    private ArrayList<Classmate> classmateList = new ArrayList<>();

    /**********************************************************************************************
     *                      Add a Classmate to classmateList.
     * @param classmate     A classmate object to add to classmateList.
     *********************************************************************************************/
    public void add(Classmate classmate) {
        this.classmateList.add(classmate);
    }

    /**********************************************************************************************
     *                  Return the Classmate object at the index in classmateList.
     * @param index     The index of classmateList to locate the classmate object.
     * @return          The Classmate object to be returned.
     *********************************************************************************************/
    public Classmate get(int index) {
        return this.classmateList.get(index);
    }

    /**********************************************************************************************
     *          Return all the Classmate objects within the classmateList.
     * @return  An ArrayList of Classmate objects.
     *********************************************************************************************/
    public ArrayList<Classmate> getAll() {
        return this.classmateList;
    }
}
