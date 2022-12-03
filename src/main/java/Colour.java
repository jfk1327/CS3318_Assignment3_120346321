/**
 * Implementation of a Colour Object. The Object represents RGB values internally in two ways:
 * <p>
 *     (i)As three float values on the interval - (0.0f - 1.0f) which represents the proportion
 *     of intensity for each component, e.g. 0.0f being no intensity and 1.0 as full intensity.
 *     Example - (1.0f,0.0f,0.0f) being perfect red.
 *     <br><br>(ii) The class also stores an internal array with the RGB value being represented as
 *     a byte at each index of the array e.g. a binary representation with 8 bits.
 *     This is implemented as floating point numbers between (0-255) for each component.
 *     <br>Example - [255.0f,0.0f ,0.0f] being perfect red.
 * </p>
 * <br> The Class is implemented to give the user two methods to enter the desired RGB value:
 * <p>
 *     (i)The user may give the Colour Object 3 floating point numbers between (0.0f - 1.0f)
 *     <br> Example - Colour colour = new Colour(0.2f,0.5f,0.9f);
 *     <br><br>(ii) The user may give a Colour Object a string of length 24, with 3 slots each of
 *     length 8 to give a byte representation of the RGB.
 *     <br>Example - Colour colour = new Colour("111111110000000010101010");
 *
 * </p>
 *
 * The Class also implements an equals() method to compare Colour Object.
 * <br>The user cannot instantiate a Colour Object with no parameter and cannot instantiate a Colour
 * Object with invalid inputs (caught by Exceptions).
 *
 * @author - James Kelly
 * @version - 1.0
 */

public class Colour {


    private float red;
    private float green;
    private float blue;


    private final float MAX_FLOAT_VALUE = 1.0f;

    private final float MIN_FLOAT_VALUE = 0.0f;

    private final float MAX_RGB_VALUE = 255.0f;

    private final float[] rgbArray = new float[3];


    /**
     * This is the three parameter constructor for the Colour Object.
     * <br>The Constructor should be used as follows:
     * <p>
     * The user gives three floating point numbers representing intensity for each component
     * <br>Example - Colour colour = new Colour(1.0f, 0.2f, 0.7f).
     * </p>
     *
     * @param red - floating point representation of red intensity for the colour - Range (0.0f - 1.0f).
     * @param green - floating point representation of green intensity for the colour - Range (0.0f - 1.0f).
     * @param blue - floating point representation of blue intensity for the colour - Range (0.0f - 1.0f).
     * @throws IllegalArgumentException - Valid input must be 3 floating point values (0.0f - 1.0f).
     *
     */
    public Colour(float red, float green, float blue) throws IllegalArgumentException{


        if (red < 0.0f || red > 1.0f){
            throw new IllegalArgumentException("Red Floating Point Value has to be in range 0.0f - 1.0f");
        }
        if (green < 0.0f || green > 1.0f){
            throw new IllegalArgumentException("Green Floating Point Value has to be in range 0.0f - 1.0f");
        }
        if (blue < 0.0f || blue > 1.0f){
            throw new IllegalArgumentException("Blue Floating Point Value has to be in range 0.0f - 1.0f");
        }
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.rgbArray[0] = red * MAX_RGB_VALUE;
        this.rgbArray[1] = green * MAX_RGB_VALUE;
        this.rgbArray[2] = blue * MAX_RGB_VALUE;

    }

    /**
     * Single Parameter for the Colour Object.
     * <br> The constructor should be used as follows:
     * <p>
     *     (i)The user may give a Colour Object a string of length 24, with 3 slots each of
     *     length 8. Bits 0-7 represent blue, 8-15 represent green and 16-23 representing red.
     *     <br> Example -> Colour colour = new Colour("111111110000000010101010");
     * </p>
     * @param rgbStringInput - String of length 24 with bits 0-7 representing blue, 8-15 representing green and
     *                       16-23 representing red.
     * @throws IllegalArgumentException - Must provide String representation of 3 bytes for Rgb as prescribed in docs.
     */

    public Colour(String rgbStringInput) throws IllegalArgumentException {

        if (rgbStringInput.length() != 24)
            throw new IllegalArgumentException("Input must be a String of length 24 with 3 valid bytes concatenated.");

        if (!(this.checkValidBitFormat(rgbStringInput))){
            throw new IllegalArgumentException("The input must be 3 valid bytes corresponding to each RGB.");
        }

        String[] byteArray = this.splitIntoBytes(rgbStringInput);

        this.red = (Integer.parseInt(byteArray[0],2) / 255.0f);
        this.green = (Integer.parseInt(byteArray[1],2) / 255.0f);
        this.blue = (Integer.parseInt(byteArray[2],2) / 255.0f);

        this.rgbArray[0] = (float) Integer.parseInt(byteArray[0],2);
        this.rgbArray[1] = (float) Integer.parseInt(byteArray[1],2);
        this.rgbArray[2] = (float) Integer.parseInt(byteArray[2],2);

    }

    /**
     * This protected method is used to split the input string into 3 valid bytes - Red byte, Green byte and blue byte.
     * @param input - String used to construct Colour Object.
     * @return Array of length 3 with Each index containing String byte.
     */
     protected static String[] splitIntoBytes(String input) {
        String[] stringAsList = input.split("");
        String[] byteList = new String[3];
        for(int i = 0; i < 3; i++){
            String byteTemporary = "";
            for(int j = 0; j<8; j++){
                byteTemporary += stringAsList[(i * 8) + j];
            }
            byteList[i] = byteTemporary;
        }
        return byteList;

    }


    /**
     * This private method checks that each character in the input string is numeric 0 or 1. If the input is
     * length 24, and only a zero and one, the input must be a valid 24 bit representation.
     * @param input - String input that is checked for the valid bit format.
     * @return - boolean value of whether the input is the valid format.
     */
    private boolean checkValidBitFormat(String input){
        String[] arrString = input.split("");
        for (int i = 0; i < arrString.length; i++) {
            int j = Integer.parseInt(arrString[i]);
            if (!(j == 0 || j == 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Equals() method override for Colour. The Equality is made true when the float RGBs of both objects are identically
     * equal.
     * <br> Implementation accounts for self reference, null reference, and different class type comparisons.
     * @param o - object to be compared to the Colour Object for equality.
     * @return boolean true if equal, false otherwise.
     */
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        if (o == null){
            return false;
        }
        if (this.getClass() != o.getClass()){
            return false;
        }
        Colour testColour = (Colour) o;
        return(this.getRed() == testColour.getRed()
                && this.getGreen() == testColour.getGreen()
                && this.getBlue() == testColour.getBlue());
    }

    /**
     * String() method override for Colour. String represents the RGB as floats and an Array of RGB on range 0-255.
     * @return String representation of a Colour.
     */
    @Override
    public String toString(){
        return "Red: " + this.red + " || Green: " + this.green + " || Blue: " + this.blue +
                " || RGBArray: [" + this.rgbArray[0]  + "],[" + this.rgbArray[1] + "],[" + rgbArray[2] + "].";
    }

    /**
     * Getter for red field.
     * @return float value of red.
     */
    public float getRed() {
        return red;
    }
    /**
     * Getter for green field.
     * @return float value of green.
     */
    public float getGreen() {

        return green;
    }


    /**
     * Getter for blue field.
     * @return float value of blue.
     */
    public float getBlue() {
        return blue;
    }

    /**
     * Getter for float Max.
     * @return Max float 1.0f for three parameter implementation.
     */
    public float getMAX_FLOAT_VALUE() {
        return MAX_FLOAT_VALUE;
    }

    /**
     * Getter for float min.
     * @return Min float 0.0f for three parameter implementation.
     */
    public float getMIN_FLOAT_VALUE() {
        return MIN_FLOAT_VALUE;
    }


    /**
     * Getter for Max RGB value.
     * @return - Max value 255 that the array floats can take.
     */
    public float getMAX_RGB_VALUE() {
        return MAX_RGB_VALUE;
    }

    /**
     * Getter for RGB Array.
     * @return RGB Array for representation of RGB as three floats between 0.0f - 255.0f.
     */
    public float[] getRgbArray() {
        return rgbArray;
    }
}
