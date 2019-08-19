/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Map Container Practice.
 *************************************************************************************************/
package com.company;
import java.util.*;

public class App {

    /**********************************************************************************************
     *              Print out the keys of the map.
     * @param map   A map of type <String, String>.
     *********************************************************************************************/
    public void printKeys(Map<String, String> map) {
        System.out.println(map.keySet());
    }

    /**********************************************************************************************
     *              Print out the values of the map.
     * @param map   A map of type <String, String>.
     *********************************************************************************************/
    public void printValues(Map<String, String> map) {
        System.out.println(map.values());
    }

    /**********************************************************************************************
     *              Print out the key: value pairs of the map.
     * @param map   A map of type <String, String>.
     *********************************************************************************************/
    public void printKeysAndValues(Map<String,String> map) {
        Iterator iterator = map.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry)iterator.next();
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }

    /**********************************************************************************************
     *              Modify the contents of the passed argument to add 2 additional
     *              key pairs and remove a single key pair.
     * @param map   A map of type <String, Integer>.
     * @return      A map of type <String, Integer>.
     *********************************************************************************************/
    public Map<String,Integer> mapFun(Map<String,Integer> map) {
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler", 2003);
        return map;
    }

    /**********************************************************************************************
     *                  Map all the objects in a list so they all appear in the same key: value
     *                  pairing lists.
     * @param carList   A List of Car objects.
     * @return          A Map of type <String, List<Car>> where the key is the make of the Car
     *                  object and the List<Car> is the list of Car's who's make is identical
     *                  to the key.
     *********************************************************************************************/
    public Map<String,List<Car>> listCars(List<Car> carList) {
        // Instantiate new objects for the method
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();
        Map<String, List<Car>> map = new HashMap<>();

        // Iterate through the argument and determine the value of the make of the car
        for(int i = 0; i < carList.size(); i++) {
            // If make = Toyota, add to toyotaList
            if(carList.get(i).getMake().equals("Toyota")) {
                toyotaList.add(carList.get(i));
            }
            // If make = Ford, add to fordList
            else if(carList.get(i).getMake().equals("Ford")) {
                fordList.add(carList.get(i));
            }
            // If make = Honda, add to hondaList
            else if(carList.get(i).getMake().equals("Honda")) {
                hondaList.add(carList.get(i));
            }
        }

        // Create a map with the make as the Key and the list as the value
        map.put("Toyota", toyotaList);
        map.put("Ford", fordList);
        map.put("Honda", hondaList);

        // Return the map
        return map;
    }
}
