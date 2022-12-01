import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ColourTest {

    @Test
    public void colourThreeParamConstructorRedTest(){
        Colour testColour = new Colour(3.0f,14.0f,1.0f);
        boolean redInRange = 0.0f <= testColour.getRed() && testColour.getRed() <= 1.0f;
        assertTrue(redInRange);

    }
    @Test
    public void colourThreeParamConstructorGreenTest(){
        Colour testColour = new Colour(3.0f,14.0f,1.0f);
        boolean greenInRange = 0.0f <= testColour.getGreen() && testColour.getGreen() <= 1.0f;
        assertTrue(greenInRange);

    }

    @Test
    public void colourThreeParamConstructorBlueTest(){
        Colour testColour = new Colour(3.0f,14.0f,1.6f);
        boolean blueInRange = 0.0f <= testColour.getBlue() && testColour.getBlue() <= 1.0f;
        assertTrue(blueInRange);

    }
}
