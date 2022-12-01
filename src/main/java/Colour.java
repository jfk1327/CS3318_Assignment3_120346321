public class Colour {

    private float red;
    private float green;
    private float blue;

    private final float MAX_FLOAT_VALUE = 1.0f;

    private final float MIN_FLOAT_VALUE = 0.0f;



    public Colour(float red, float green, float blue){
        this.red = red;
        this.green = green;
        this.blue = blue;
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

    public void setRed(float red) {
        this.red = red;
    }

    public void setGreen(float green) {
        this.green = green;
    }

    public void setBlue(float blue) {
        this.blue = blue;
    }
}
