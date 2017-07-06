package nl.sourcelabs.functions;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Example similar to the Kotlin equivalent in the same folder.
 *
 * The extension function from the Kotlin example is missing here. LocalTime is final, so we can't extend it. Best we
 * can do to create something similar is wrapping it in a delegate type, which probably is not worth the trouble.
 *
 * -- Yes, that's being a bit sarcastic.
 */
public class Methods {

    // Similar implementation of the Kotlin function
    public static String toTimeString(final LocalTime time) {
        return DateTimeFormatter.ofPattern("hh:mm:ss").format(time);
    }

    // In order to have similar functionality to default params, overloading is required
    public static String toTimeString() {
        return toTimeString(LocalTime.now());
    }

    public static void main(final String[] args) {
        // Closest thing to a top-level kotlin function is a static function. The invocation will rquire you
        // to name the enclosing class
        System.out.println(Methods.toTimeString(LocalTime.of(10,0,0)));

        // Default values
        System.out.println(Methods.toTimeString());
    }
}
