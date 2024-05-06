package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {
    @Test
    public void stringTest() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("hello from the other side"));
        assertTrue(schema.isValid("seven nation army"));

        assertTrue(schema.contains("sev").isValid("seven nation army"));
        assertTrue(schema.contains("seven").isValid("seven nation army"));
        assertFalse(schema.contains("sevennation").isValid("seven nation army"));

        assertFalse(schema.isValid("seven nation army"));

        StringSchema schema1 = validator.string().minLength(10).minLength(4);
        assertTrue(schema1.isValid("hello"));

        StringSchema schema2 = validator.string().required().minLength(5).contains("hel").contains("helo");
        assertFalse(schema2.isValid("hello"));

        StringSchema schema3 = validator.string().minLength(10).minLength(4);
        assertFalse(schema3.isValid(null));
    }

    @Test
    public void numberTest() {
        Validator validator = new Validator();
        NumberSchema schema = validator.number();

        assertTrue(schema.isValid(5));

        assertTrue(schema.isValid(null));
        assertTrue(schema.positive().isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(10));

        assertFalse(schema.isValid(-10));
        assertFalse(schema.isValid(0));

        schema.range(5, 10);

        assertTrue(schema.isValid(5));
        assertTrue(schema.isValid(10));
        assertFalse(schema.isValid(4));
        assertFalse(schema.isValid(11));

        NumberSchema schema1 = validator.number().required().positive().range(3, 6);
        assertTrue(schema1.isValid(4));

        NumberSchema schema2 = validator.number().positive().range(4, 10).range(1, 3);
        assertTrue(schema2.isValid(2));
    }

    @Test
    public void mapTest() {
        Validator validator = new Validator();
        MapSchema schema = validator.map();

        assertTrue(schema.isValid(null));

        schema.required();

        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeOf(2);

        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));

        Map<String, String> data1 = new HashMap<>();
        data1.put("key1", "value1");
        data1.put("key2", "value2");
        MapSchema schema1 = validator.map().required().sizeOf(1).sizeOf(2);
        assertTrue(schema1.isValid(data1));
    }
}
