# kotlin-java

Simple project showing some of the features Kotlin offers to Java developers. Where applicable, this will be accompanied by some Java code showing the difference in syntax and possibilities.

# Topics covered

This is still very much a work-in-progress, but for the time being please have a look at the topics covered in this codebase.

If there are any mistakes, misconceptions or missing examples, feel free to let me know.

## Constructors
- Named parameters ```SomeType(val name: String) -> val type = SomeType(name = "Name")```
- Property declarations ```SomeType(val name: String)```
- Default parameters ```SomeType(val name: String = "name")```
- Init blocks ```init { // initialize the type }```

## Functions
- Top-level functions ```fun sum(left: Int, right: Int) { return left + right } -> val total = sum(1, 3) ```
- Extension functions ```fun Int.add(add: Int) { return this + right } -> val total = 1.add(3) ```
- Infix functions ```infix fun Int.and(add: Int) { return this + right } -> val total = 1 and 3 ```

## Higher order functions
- Functions returning functions
- Functions taking functions as parameters
- Invoking function references
- Passing function references to functions

## Data classes
- General data class definition
- Property declarations
- Tostring
- Equals
- Creating copies

## Generics
    
- Covariant generics ```SomeType <out T>```
- Contravariant generics ```SomeType <in T>```
- Invariant generics ```SomeType <T>```
- Wildcards ```SomeType <*>```
