package hexlet.code.schemas;

import hexlet.code.states.RequiredState;
import hexlet.code.states.map.ShapeState;
import hexlet.code.states.map.SizeofState;

import java.util.Map;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        Utils.updateState(getStates(), new RequiredState<Map<String, String>>());
        return this;
    }

    public MapSchema sizeof(int size) {
        Utils.updateState(getStates(), new SizeofState(size));
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> schemas) {
        Utils.updateState(getStates(), new ShapeState(schemas));
        return this;
    }
}
