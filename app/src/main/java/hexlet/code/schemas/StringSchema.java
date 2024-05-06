package hexlet.code.schemas;

import hexlet.code.states.string.ContainState;
import hexlet.code.states.string.MinLengthState;
import hexlet.code.states.string.RequiredState;

public class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Utils.updateState(states, new RequiredState());
        return this;
    }

    public StringSchema contains(String pSymbols) {
        Utils.updateState(states, new ContainState(pSymbols));
        return this;
    }

    public StringSchema minLength(int pMinLength) {
        Utils.updateState(states, new MinLengthState(pMinLength));
        return this;
    }
}
