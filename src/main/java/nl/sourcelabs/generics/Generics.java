package nl.sourcelabs.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Kotlin generic types add in/out covariant/contravariant types to provide compiler hints for safe/unsafe operations.
 * That said, Kotlin does not contain raw types, meaning that the example below with the unsafe raw type is not possible
 * in Kotlin.
 */
public class Generics {
    // Wildcard declaration at call site constraining the allowed generic types accepted by this method
    public static void wildcardGeneric(List<? extends Number> numbers) {
    }

    // Unconstrained (the <?> can be omitted but its good practice to explicitly specify it)
    public static void wildcardGenericUnconstrained(List<?> objects) {
    }

    public static void main(String[] args) {
        final GenericClass<String> genericClass = new GenericClass();
        //GenericClass<Object> objectGenericClass = genericClass; // Compiler error incompatible
        final GenericClass rawGenericClass = genericClass; // Raw type - backwards compatibility feature - allowed but unsafe
        rawGenericClass.addThing(1); // When the class expects Strings this will cause an exception

        // Bounded generics
        GenericBounded<Integer> integerGenericBounded = new GenericBounded();
        //GenericBounded<String> stringGenericBounded = new GenericBounded(); // Compiler error, String no subclass of number

        // Wildcards
        wildcardGeneric(new ArrayList<Integer>());
        wildcardGeneric(new ArrayList<Double>());
        //wildcardGeneric(new ArrayList<Object>()); // Compiler error

        // Unconstrained -- anything goes
        wildcardGenericUnconstrained(new ArrayList<String>());
        wildcardGenericUnconstrained(new ArrayList<Integer>());
    }
}

/**
 * Unbounded generics class
 */
class GenericClass<T> {
    public T getThing() {
        return null;
    }

    public void addThing(T t) {
    }
}

/**
 * Bounded generics class
 */
class GenericBounded<T extends Number> {
    public T getThing() {
        return null;
    }

    public void addThing(T t) {
    }
}
