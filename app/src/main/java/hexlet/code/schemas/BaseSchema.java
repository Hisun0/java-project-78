package hexlet.code.schemas;

import hexlet.code.states.State;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseSchema<T> {
    List<State> states = new ArrayList<>();

    public boolean isValid(T value) {
        return states.stream().allMatch(state -> state.isValid(value));
    }
}
