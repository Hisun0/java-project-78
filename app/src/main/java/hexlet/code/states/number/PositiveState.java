package hexlet.code.states.number;

import hexlet.code.states.State;

public final class PositiveState implements State<Integer> {
    @Override
    public boolean isValid(Integer value) {
        return value == null || value > 0;
    }
}
