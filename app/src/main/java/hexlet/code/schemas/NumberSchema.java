package hexlet.code.schemas;

import hexlet.code.states.RequiredState;
import hexlet.code.states.number.PositiveState;
import hexlet.code.states.number.RangeState;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Utils.updateState(getStates(), new RequiredState<Integer>());
        return this;
    }

    public NumberSchema positive() {
        Utils.updateState(getStates(), new PositiveState());
        return this;
    }

    public NumberSchema range(Integer pMin, Integer pMax) {
        Utils.updateState(getStates(), new RangeState(pMin, pMax));
        return this;
    }
}
