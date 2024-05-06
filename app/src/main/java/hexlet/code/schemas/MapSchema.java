package hexlet.code.schemas;

import hexlet.code.states.RequiredState;
import hexlet.code.states.map.SizeOfState;

import java.util.Map;

public class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        Utils.updateState(states, new RequiredState<Map<String, String>>());
        return this;
    }

    public MapSchema sizeOf(int size) {
        Utils.updateState(states, new SizeOfState(size));
        return this;
    }
}
