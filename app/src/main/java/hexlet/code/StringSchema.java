package hexlet.code;

import java.util.Arrays;
import java.util.List;

public class StringSchema {
    private String symbols = null;
    private int minLength = 0;
    private boolean isRequired = false;

    public boolean isValid(Object value) {
        String stringValue = value == null ? "" : value.toString();
        List<Boolean> list = Arrays.asList(
                containsCheck(stringValue), lengthCheck(stringValue), requiredCheck(stringValue), valueCheck(value)
        );
        return list.stream().allMatch(el -> el);
    }

    public void required() {
        isRequired = true;
    }

    public StringSchema contains(String symbols) {
        this.symbols = symbols;
        return this;
    }

    public StringSchema minLength(int minLength) {
        this.minLength = minLength;
        return this;
    }

    private boolean containsCheck(String value) {
        if (symbols == null) {
            return true;
        }

        return value.contains(symbols);
    }

    private boolean lengthCheck(String value) {
        return value.length() >= minLength;
    }

    private boolean requiredCheck(String value) {
        return !isRequired || !value.equals("null") && !value.isEmpty();
    }

    private boolean valueCheck(Object value) {
        return value instanceof String || value == null;
    }
}
