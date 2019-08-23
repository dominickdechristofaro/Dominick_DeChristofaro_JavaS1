public class City {
    // Properties
    private String cityName;
    private int cityPopulation;
    private boolean isCapital;

    // Constructors
    public City() {
    }
    public City(String cityName, int cityPopulation, boolean isCapital) {
        this.cityName = cityName;
        this.cityPopulation = cityPopulation;
        this.isCapital = isCapital;
    }

    // Getters
    public String getCityName() {
        return this.cityName;
    }
    public int getCityPopulation() {
        return this.cityPopulation;
    }
    public boolean isCapital() {
        return this.isCapital;
    }

    // Setters
    public void setCityName(String cityNameIn) {
        this.cityName = cityNameIn;
    }
    public void setCityPopulation(int cityPopulationIn) {
        this.cityPopulation = cityPopulationIn;
    }
    public void setCapital(boolean capitalIn) {
        this.isCapital = capitalIn;
    }

    // Methods
}
