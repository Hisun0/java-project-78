package hexlet.code.states.map;

import hexlet.code.states.State;

import java.util.Map;

public final class SizeofState implements State<Map<String, String>> {
    private final int sizeOf;

    public SizeofState(int pSizeOf) {
        sizeOf = pSizeOf;
    }

    @Override
    public boolean isValid(Map<String, String> value) {
        return value != null && value.size() == sizeOf;
    }
}
