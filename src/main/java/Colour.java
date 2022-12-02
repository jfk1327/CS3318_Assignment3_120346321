

public class Colour {

    private float red;
    private float green;
    private float blue;


    private final float MAX_FLOAT_VALUE = 1.0f;

    private final float MIN_FLOAT_VALUE = 0.0f;

    private final float MAX_RGB_VALUE = 255.0f;

    private final float[] rgbArray = new float[3];



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

    public Colour(String rgbStringInput) throws IllegalArgumentException {

        if (rgbStringInput.length() != 24)
            throw new IllegalArgumentException("Input must be a String of length 24 with 3 valid bytes concatenated.");

        if (!(this.checkValidByteFormat(rgbStringInput))){
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

    public static String[] splitIntoBytes(String input) {
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

    private boolean checkValidByteFormat(String input){
        String[] arrString = input.split("");
        for (int i = 0; i < arrString.length; i++) {
            int j = Integer.parseInt(arrString[i]);
            if (!(j == 0 || j == 1)) {
                return false;
            }
        }
        return true;
    }

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

    @Override
    public String toString(){
        return "Red: " + this.red + " || Green: " + this.green + " || Blue: " + this.blue +
                " || RGBArray: [" + this.rgbArray[0]  + "],[" + this.rgbArray[1] + "],[" + rgbArray[2] + "].";
    }

    public float getRed() {
        return red;
    }

    public float getGreen() {
        return green;
    }

    public float getBlue() {
        return blue;
    }

    public float getMAX_FLOAT_VALUE() {
        return MAX_FLOAT_VALUE;
    }

    public float getMIN_FLOAT_VALUE() {
        return MIN_FLOAT_VALUE;
    }


    public float getMAX_RGB_VALUE() {
        return MAX_RGB_VALUE;
    }

    public float[] getRgbArray() {
        return rgbArray;
    }
}
