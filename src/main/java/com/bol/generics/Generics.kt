package com.bol.generics

/**
 * This is called an invariant generic (neither co- nor contravariant, see below)
 */
fun <T> invariant(t: T) {}

/**
 * Basic method using generics - the generic type requires the parameter to be of type Number.
 * This construct is called an upper bound; only subtypes of Number are allowed
 */
fun <T: Number> bounded(t: T) {}

/**
 * Contravariant generic - this marks the class as only 'consuming' objects of type T.
 * Methods with a signature that return objects of T are not allowed
 */
class InGeneric<in T> {
    fun input(t: T){} // Ok, (consumer)
    // fun output() : T? { return null } // Not ok, not an 'in'-type function (producer) <-- Compiler error
}

/**
 * Covariant generic - this marks the class as only 'Producing' objects of type T.
 * Methods with a signature that take T as a parameter are not allowed
 */
class OutGeneric<out T> {
    // fun input(t: T){} // Not ok, not an 'out'-type function (consumer) <-- Compiler error
    fun output() : T? { return null } // Ok, not an 'in'-type function (producer)
}

/**
 * This is called an invariant generic (neither co- nor contravariant, see below)
 */
class InvariantGeneric<T> {}

/**
 * Examples for bounded and invariant generics
 */
fun bounds() {
    invariant<Int>(1) // Anything is allowed (notice that <Int> is not required, type is inferred from parameter type)
    invariant("1") // Any type is allowed

    bounded(1) // Int - subclass of Number
    //bounded("1") // String, not a subclass of number <-- Compiler error
}

/**
 * Examples of contravariant generics.
 *
 * When declaring a SomeClass<Number> and then assigining it to a narrower type
 * of Number, i.e. SomeClass<Int> this is allowed, because someClassInstance.method(Int) is compatible with
 * someClassInstance.method(Number) - as Int is a subtype of Number.
 *
 * Not marking the class as contravariant (<in T>) will not allow this.
 */
fun contravariant() {
    val inGeneric = InGeneric<Number>()
    val differentInGeneric: InGeneric<Int> = inGeneric // <-- Allowed, contravariant

    val outGeneric = OutGeneric<Number>()
    //val differentOutGeneric: OutGeneric<Int> = outGeneric // <-- compiler error, not contravariant

    val invariantGeneric = InvariantGeneric<Number>()
    //val differentInvariantGeneric: InvariantGeneric<Int> = invariantGeneric // <-- compiler error, not contravariant
}

/**
 * Examples of covariant generics.
 *
 * When declaring a SomeClass<String> and then assigining it to a wider type such as SomeClass<Any>, this is allowed
 * - as Any is a superclass of String.
 *
 * Not marking the class as covariant (<out T>) will not allow this.
 */
fun covariant() {
    val outGeneric = OutGeneric<String>()
    val differentOutGeneric: OutGeneric<Any> = outGeneric // Allowed, covariant

    val inGeneric = InGeneric<String>()
    //val differentInGeneric: InGeneric<Any> = inGeneric // <-- compiler error, not covariant

    val invariantGeneric = InvariantGeneric<String>()
    //val differentInvariantGeneric: InvariantGeneric<Any> = invariantGeneric // <-- compiler error, not covariant
}

/**
 * Wildcard types show some similarities with Java raw types. The main difference is that the can only be applied to
 * producers rather than consumers.
 */
fun wildcards() {
    val outGeneric = OutGeneric<String>()
    val differentOutGeneric: OutGeneric<*> = outGeneric // Wildcard declaration, similar to java raw types (<?>)
    val output: Any? = differentOutGeneric.output()

    val inGeneric = InGeneric<String>()
    val differentInGeneric: InGeneric<*> = inGeneric
    //differentInGeneric.input("") // Compiler error. It cannot typecheck this method due to the wildcard (<*>)
}



