/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.21.2019
 *  Description:    Computer Class for CSV Reader.
 *************************************************************************************************/
package com.company;
import com.opencsv.bean.CsvBindByName;

public class Computer {
    // Properties
    @CsvBindByName(column = "Brand")
    private String brand;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "CPU")
    private String cpu;
    @CsvBindByName(column = "RAM")
    private int ram;
    @CsvBindByName(column = "StorageSize")
    private int storageSize;

    // Default Constructor
    public Computer() {
    }

    /**
     *                      5-Parameter Constructor.
     * @param brand         The brand name of a Computer.
     * @param model         The model of a Computer.
     * @param cpu           The CPU model of a Computer.
     * @param ram           The RAM spec of a Computer.
     * @param storageSize   The storage size of a Computer.
     */
    public Computer(String brand, String model, String cpu, int ram, int storageSize) {
        this.brand = brand;
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.storageSize = storageSize;
    }

    // Getters
    public String getBrand() {
        return this.brand;
    }
    public String getModel() {
        return this.model;
    }
    public String getCpu() {
        return this.cpu;
    }
    public int getRam() {
        return this.ram;
    }
    public int getStorageSize() {
        return this.storageSize;
    }

    // Setters
    public void setBrand(String brandIn) {
        this.brand = brandIn;
    }
    public void setModel(String modelIn) {
        this.model = modelIn;
    }
    public void setCpu(String cpuIn) {
        this.cpu = cpuIn;
    }
    public void setRam(int ramIn) {
        this.ram = ramIn;
    }
    public void setStorageSize(int storageSizeIn) {
        this.storageSize = storageSizeIn;
    }
}
