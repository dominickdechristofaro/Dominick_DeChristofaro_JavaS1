import java.util.List;

public class CityList {
    // Properties
    private List<City> cityList;

    // Constructors
    public CityList() {
    }
    public CityList(List<City> cityList) {
        this.cityList = cityList;
    }

    // Getters
    public List<City> getCityList() {
        return this.cityList;
    }

    // Setters
    public void setCityList(List<City> cityListIn) {
        this.cityList = cityListIn;
    }

    // Methods
}
