/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    SetIterator has only 1 method, to print the values within a HashSet.
 *************************************************************************************************/
package com.company;
import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {
    // Constructor
    public SetIterator() {

    }

    /**
     *                  Place 5 integer numbers into a HashSet and then print out
     *                  the values in the HashSet.
     * @param num1      Integer number
     * @param num2      Integer number
     * @param num3      Integer number
     * @param num4      Integer number
     * @param num5      Integer number
     */
    public void printSet(int num1, int num2, int num3, int num4, int num5) {
        // Instantiate objects
        HashSet<Integer> hashSet = new HashSet<>();

        // Add values to the hashSet
        hashSet.add(num1);
        hashSet.add(num2);
        hashSet.add(num3);
        hashSet.add(num4);
        hashSet.add(num5);

        // Instantiate over hashSet elements
        Iterator<Integer> iterator = hashSet.iterator();

        // Print out the values of the hashSet
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
