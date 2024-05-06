package hexlet.code.states.map;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.states.State;

import java.util.Map;

public class ShapeState implements State<Map<String, String>> {
    private final Map<String, BaseSchema<String>> schemas;

    public ShapeState(Map<String, BaseSchema<String>> schemas) {
        this.schemas = schemas;
    }

    @Override
    public boolean isValid(Map<String, String> value) {
        return schemas.keySet().stream().allMatch(key -> {
            BaseSchema<String> schema = schemas.get(key);
            String valueToValidate = value.get(key);
            return schema.isValid(valueToValidate);
        });
    }
}
