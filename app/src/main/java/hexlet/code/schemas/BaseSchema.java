package hexlet.code.schemas;

import hexlet.code.states.State;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema<T> {
    private List<State> states = new ArrayList<>();

    public final boolean isValid(T value) {
        return states.stream().allMatch(state -> state.isValid(value));
    }

    public List<State> getStates() {
        return states;
    }
}
