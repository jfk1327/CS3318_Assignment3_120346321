import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class exampleTest{

    @Test
    public void testExample(){
        int i = 1;
        assertEquals(1,i);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World "})

    public void testWithStringParameter(String argument){
        assertNotNull(argument);
    }
}

