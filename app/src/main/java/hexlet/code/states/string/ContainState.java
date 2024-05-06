package hexlet.code.states.string;

import hexlet.code.states.State;

public final class ContainState implements State<String> {
    private final String symbols;

    public ContainState(String pSymbols) {
        symbols = pSymbols;
    }

    @Override
    public boolean isValid(String value) {
        return symbols == null || value.contains(symbols);
    }
}
