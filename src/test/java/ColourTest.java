import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColourTest {
    @Test
    public void colourThreeParamConstructorRedTest(){
        Colour testColour = new Colour(1.0f, 1.0f, 1.0f);
        boolean redInRange = 0.0f <= testColour.getRed() && testColour.getRed() <= 1.0f;
        assertTrue(redInRange);

    }
    @Test
    public void colourThreeParamConstructorGreenTest(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        boolean greenInRange = 0.0f <= testColour.getGreen() && testColour.getGreen() <= 1.0f;
        assertTrue(greenInRange);

    }

    @Test
    public void colourThreeParamConstructorBlueTest(){
        Colour testColour = new Colour(1.0f,1.0f,1.0f);
        boolean blueInRange = 0.0f <= testColour.getBlue() && testColour.getBlue() <= 1.0f;
        assertTrue(blueInRange);

    }

    @Test
    public void colourSingleParamConstructorLengthOfStringTest(){
        String input = "111111110000000000000000";
        Colour testColour = new Colour(input);
        assertEquals(24,input.length());

    }

    @Test
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
    public void colourSingleParamTestSplitIntoBytes(){
        String input = "111111111010101000000000";
        Colour testColour = new Colour(input);
        String[] byteArray = Colour.splitIntoBytes(input);
        for (int i = 0; i < byteArray.length; i++){
            assertEquals(8,byteArray[i].length());
        }
    }

    @Test
    public void colourEqualsMethodTest(){
        Colour testColour1 = new Colour(1.0f, 1.0f, 1.0f);
        Colour testColour2 = new Colour(1.0f, 1.0f, 1.0f);
        assertTrue(testColour1.equals(testColour2));

    }



}





