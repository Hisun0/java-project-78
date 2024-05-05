package hexlet.code.states.string;

import hexlet.code.states.State;

public class ContainState implements State<String> {
    private final String symbols;

    public ContainState(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public boolean isValid(String value) {
        return symbols == null || value.contains(symbols);
    }
}
