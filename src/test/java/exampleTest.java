import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class exampleTest{
    /**
     * Example Test Class that was used at start of Project to test dependencies in Maven and
     * ensure Each type of Test and Parameterized Test was working. Can be ignored.
     *
     * @author - James Kelly.
     * @version - 1.0
     */

    @Test
    public void testExample(){
        /**
         * Example to check @Test decorator.
         */

        int i = 1;
        assertEquals(1,i);
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "World "})

    public void testWithStringParameter(String argument){
        /**
         * Example to check @ParameterizedTest decorator.
         * @param - Strings to be passed test method.
         */
        assertNotNull(argument);
    }
}

