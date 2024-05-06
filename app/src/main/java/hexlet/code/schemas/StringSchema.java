package hexlet.code.schemas;

import hexlet.code.states.string.ContainState;
import hexlet.code.states.string.MinLengthState;
import hexlet.code.states.string.RequiredState;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Utils.updateState(getStates(), new RequiredState());
        return this;
    }

    public StringSchema contains(String pSymbols) {
        Utils.updateState(getStates(), new ContainState(pSymbols));
        return this;
    }

    public StringSchema minLength(int pMinLength) {
        Utils.updateState(getStates(), new MinLengthState(pMinLength));
        return this;
    }
}
