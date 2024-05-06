package hexlet.code.schemas;

import hexlet.code.states.RequiredState;
import hexlet.code.states.number.PositiveState;
import hexlet.code.states.number.RangeState;

public class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Utils.updateState(states, new RequiredState<Integer>());
        return this;
    }

    public NumberSchema positive() {
        Utils.updateState(states, new PositiveState());
        return this;
    }

    public NumberSchema range(Integer pMin, Integer pMax) {
        Utils.updateState(states, new RangeState(pMin, pMax));
        return this;
    }
}
