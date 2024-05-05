package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    @Test
    public void stringTest() {
        Validator validator = new Validator();
        StringSchema schema = validator.string();

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));
        assertFalse(schema.isValid(5));

        schema.required();

        assertFalse(schema.isValid(""));
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid("hello from the other side"));
        assertTrue(schema.isValid("seven nation army"));

        assertTrue(schema.contains("sev").isValid("seven nation army"));
        assertTrue(schema.contains("seven").isValid("seven nation army"));
        assertFalse(schema.contains("sevennation").isValid("seven nation army"));

        assertFalse(schema.isValid("seven nation army"));

        StringSchema schema1 = validator.string();
        assertTrue(schema1.minLength(10).minLength(4).isValid("hello"));
    }
}
