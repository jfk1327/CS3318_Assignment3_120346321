/**
 *
 * Main Class for the Application.
 * <br> The Main function instantiates 2 colours: one with the float representation and the other with the
 * 24 bit String representation.
 * <br> The main also ensures the equals() method is properly implemented.
 *
 * @author James Kelly.
 * @version 1.0.
 *
 */
public class Main {
    public static void main(String[] args) {
        Colour colour1 = new Colour(1.0f,0.0f,0.49803921668f);
        System.out.println(colour1);
        Colour colour2 = new Colour("111111110000000001111111");
        System.out.println(colour2);
        System.out.println(colour1.equals(colour2));

    }
}
