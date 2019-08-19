public class City {
    // Variables
    private String name;
    private int population;

    // Constructors
    public City() {

    }
    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public int getPopulation() {
        return this.population;
    }

    // Setters
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public void setPopulation(int populationIn) {
        this.population = populationIn;
    }

    // Methods
}
