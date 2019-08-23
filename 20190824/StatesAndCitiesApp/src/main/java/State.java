import java.util.List;

public class State {
    // Properties
    private String stateName;
    private int statePopulation;
    private List<City> cityList;

    // Constructors
    public State() {
    }
    public State(String stateName, int statePopulation, List<City> cityList) {
        this.stateName = stateName;
        this.statePopulation = statePopulation;
        this.cityList = cityList;
    }

    // Getters
    public String getStateName() {
        return this.stateName;
    }
    public int getStatePopulation() {
        return this.statePopulation;
    }
    public List<City> getCityList() {
        return this.cityList;
    }

    // Setters
    public void setStateName(String stateNameIn) {
        this.stateName = stateNameIn;
    }
    public void setStatePopulation(int statePopulationIn) {
        this.statePopulation = statePopulationIn;
    }
    public void setCityList(List<City> cityListIn) {
        this.cityList = cityListIn;
    }

    // Methods
}
