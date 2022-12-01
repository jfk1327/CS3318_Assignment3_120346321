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




}
