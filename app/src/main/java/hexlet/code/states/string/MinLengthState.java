package hexlet.code.states.string;

import hexlet.code.states.State;

public class MinLengthState implements State<String> {
    private final int minLength;

    public MinLengthState(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() >= minLength;
    }
}
