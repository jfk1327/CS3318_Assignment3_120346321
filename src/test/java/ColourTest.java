
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Methods for the Colour Class.
 * <br> The main focus of this project is in this Class.
 * <br> The TDD design pattern was used for this project.
 * <br> The design for the class begins by writing a test before implementing any code.
 * <br> Once I wrote a failing test and the bare amount of code to allow a test,
 * (N.B. see git log and commits for details) I then and only then used the test to guide implementation.
 * <br> Once the tests passed on rerun the test after implementation, I could do some refactoring.
 * <br> I intended each test to test only one component ever, and to only fail for one reason as well.
 * This ensures tests are independent and test specific units.
 *
 * @author James Kelly.
 * @verion 1.0
 *
 */
public class ColourTest {
    @Test
    @DisplayName("Test to check that that the red component is in the float range (0.0f - 1.0f):")
    public void colourThreeParamConstructorRedTest(){
        Colour testColour = new Colour(1.0f, 1.0f, 1.0f);
        boolean redInRange = 0.0f <= testColour.getRed() && testColour.getRed() <= 1.0f;
        assertTrue(redInRange);

    }
    @Test
    @DisplayName("Test to check that that the green component is in the float range (0.0f - 1.0f):")
    public void colourThreeParamConstructorGreenTest(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        boolean greenInRange = 0.0f <= testColour.getGreen() && testColour.getGreen() <= 1.0f;
        assertTrue(greenInRange);

    }

    @Test
    @DisplayName("Test to check that that the blue component is in the float range (0.0f - 1.0f):")
    public void colourThreeParamConstructorBlueTest(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        boolean blueInRange = 0.0f <= testColour.getBlue() && testColour.getBlue() <= 1.0f;
        assertTrue(blueInRange);

    }

    @Test
    @DisplayName("Test to check that the input length for a colour object must be 24:")
    public void colourSingleParamConstructorLengthOfStringTest(){
        String input = "111111110000000000000000";
        Colour testColour = new Colour(input);
        assertEquals(24,input.length());

    }

    @Test
    @DisplayName("Test to ensure that a string given is of the correct byte format:")
    public void colourSingleParamConstructorCheckValidBytes(){
        String input = "111111110100000000000000";
        Colour testColour = new Colour(input);
        String[] arrString = input.split("");
        for (int i = 0; i < arrString.length; i++){
            int j = Integer.parseInt(arrString[i]);
            assertTrue((j == 0 || j == 1));
        }

    }
    @Test
    @DisplayName("Test to check the method that will split the 24 bit string into 3 string bytes:")
    public void colourSingleParamTestSplitIntoBytes(){
        String input = "111111111010101000000000";
        Colour testColour = new Colour(input);
        String[] byteArray = Colour.splitIntoBytes(input);
        for (int i = 0; i < byteArray.length; i++){
            assertEquals(8,byteArray[i].length());
        }
    }

    @Test
    @DisplayName("Test to check proper overide of the equals() method:")
    public void colourEqualsMethodTestDifferentColourObjects(){
        Colour testColour1 = new Colour(1.0f, 1.0f, 1.0f);
        Colour testColour2 = new Colour(1.0f, 1.0f, 1.0f);
        assertTrue(testColour1.equals(testColour2));

    }
    @Test
    @DisplayName("Test to check that equals() method works in case of self-reference:")
    public void colourEqualsMethodTestSelfEquals(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        assertTrue(testColour.equals(testColour));
    }

    @Test
    @DisplayName("Test to check that equals() method works in case of comparison to null:")
    public void colourEqualsMethodNullCheckTest(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        assertTrue(!(testColour.equals(null)));
    }



}





