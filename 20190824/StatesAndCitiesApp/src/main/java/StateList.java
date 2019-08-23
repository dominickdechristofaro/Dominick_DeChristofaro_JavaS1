import java.util.List;

public class StateList {
    // Properties
    private List<State> stateList;

    // Constructors
    public StateList() {
    }
    public StateList(List<State> stateList) {
        this.stateList = stateList;
    }

    // Getters
    public List<State> getStateList() {
        return this.stateList;
    }

    // Setters
    public void setStateList(List<State> stateListIn) {
        this.stateList = stateListIn;
    }

    // Methods
}
