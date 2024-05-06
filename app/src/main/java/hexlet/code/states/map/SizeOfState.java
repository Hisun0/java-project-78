package hexlet.code.states.map;

import hexlet.code.states.State;

import java.util.Map;

public class SizeOfState implements State<Map<String, String>> {
    private int sizeOf;

    public SizeOfState(int sizeOf) {
        this.sizeOf = sizeOf;
    }

    @Override
    public boolean isValid(Map<String, String> value) {
        return value != null && value.size() == sizeOf;
    }
}
