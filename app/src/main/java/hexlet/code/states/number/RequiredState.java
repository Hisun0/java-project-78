package hexlet.code.states.number;

import hexlet.code.states.State;

public class RequiredState implements State<Integer> {
    @Override
    public boolean isValid(Integer value) {
        return value != null;
    }
}
