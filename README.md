# kotlin-java

Simple project showing some of the features Kotlin offers to Java developers. Where applicable, this will be accompanied by some Java code showing the difference in syntax and possibilities.

# Topics covered (so far)

- Constructors
    - Named parameters ```Type(val name: String) -> val type = Type(name = "Name")```
    - Property declarations ```Type(val name: String)```
    - Default parameters ```Type(val name: String = "name")```
    - Init blocks ```init { // initialize the type }```
- Functions
    - Top-level functions ```fun sum(left: Int, right: Int) { return left + right } -> val total = sum(1, 3) ```
    - Extension functions ```fun Int.add(add: Int) { return this + right } -> val total = 1.add(3) ```
    - Infix functions ```infix fun Int.and(add: Int) { return this + right } -> val total = 1 and 3 ```
- Higher order functions
    - Functions returning functions
    - Functions taking functions as parameters
- Data classes
    - General data class definition
    - Property declarations
    - Tostring
    - Equals
    - Creating copies
- Generics
    - Covariant generics ```<out T>```
    - Contravariant generics ```<in T>```
    - Invariant generics ```<T>```
    - Wildcards ```<*>```
