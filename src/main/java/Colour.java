public class Colour {

    private final float red;
    private final float green;
    private final float blue;


    private final float MAX_FLOAT_VALUE = 1.0f;

    private final float MIN_FLOAT_VALUE = 0.0f;

    private final float MAX_RGB_VALUE = 255.0f;



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

    }

    @Override
    public String toString(){
        return "Red: " + this.red + " || Green: " + this.green + " || Blue: " + this.blue +".";
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
}
