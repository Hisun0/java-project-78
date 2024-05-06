package hexlet.code.states.string;

import hexlet.code.states.State;

public final class RequiredState implements State<String> {
    @Override
    public boolean isValid(String value) {
        return value != null && !value.isEmpty();
    }
}
