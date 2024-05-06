package hexlet.code.states.string;

import hexlet.code.states.State;

public final class MinLengthState implements State<String> {
    private final int minLength;

    public MinLengthState(int pMinLength) {
        minLength = pMinLength;
    }

    @Override
    public boolean isValid(String value) {
        return value != null && value.length() >= minLength;
    }
}
