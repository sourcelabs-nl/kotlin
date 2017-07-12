# Kotlin - Java

Simple project showing some of the features Kotlin offers to Java developers. Where applicable, this will be accompanied by some Java code showing the difference in syntax and functionality between both languages.

This is intented to be a unidirectional comparison; I will focus on features in Kotlin and if possible map them to Java - not the other way around.

# Topics covered

This is still very much a work-in-progress, but for the time being please have a look at the topics covered in this codebase. The list is below and should be fairly complete.

If you feel there are any mistakes, misconceptions, missing or unclear examples, feel free to let me know.

## Language Basics

#### Semicolon optional

Kotlin has semicolon inference. It uses the pseudo-token SEMI (semicolon or newline) to separate declarations, statements and the like. Only in some cases, such as writing several statements on one line Kotlin requires an explicit semicolon.

```kotlin
fun doSomething() {
    val someString = "someString" // semicolon optional
    if(true) { operation1(); operation() } // Semicolon required to separate statements
}
```

#### Type inference

```kotlin
// Explicit, something can't be anything other than string, so type can be omitted
val something: String = "This is a string" 

// Infers that something is of type String
val something = "This is a string" 
```

#### Null values

Kotlin types are not nullable by default. When interoperating with Java, they can at times be null. To allow nulls in your code, append a '?' after the parameter type. Kotlin will force you to deal with possible null values.

```kotlin
fun operate(context: String?) { // context could be null 
}
```

#### Nullsafe (Elvis) operator

When parameters are nullable, code must be written defensively to prevent nullpointers. The nullsafe operator will only access the function or property when the lefthand side of the statement is not null. Additionally ?: allows you to provide a default value in case any of the properties is null.

```kotlin
fun getContracteeName(contract: Contract?): String { 
    // ?. only executes if contract isn't null, ?: specifies a default in case of null
    return contract?.contractee?.name ?: "Unknown" 
}
```

#### No 'new' keyword

```kotlin
val person: Person() // <class>() implies constructor call
```

#### Checked exceptions

```kotlin
fun break() { 
    throw IOException("")
}
```

#### Smart casts 

```kotlin
if(instance is String) { // is is the equivalent for instanceof
    instance.toUpperCase() // inside the if-block instance is implicitly cast to String
}
```

## Properties

#### Mutable properties

```kotlin
var someProperty = "value"
someProperty = "newValue" // assign new value
```

#### Immutable properties

```kotlin
val someProperty = "value"
someProperty = "newValue" // compiler error, someProperty is final
```

#### Getters and Setters

Kotlin advocates property access rather than accessor methods. If the need arises, it's possible to explicitly provide a getter for the property. 

The implicit variable 'field' references the property.

```kotlin
var stringRep: String = "Default"
    get() = field // return the actual value for the field
    set(value) {
        if(value.length < 10) // conditional set, if length < 10
            field = value
    }
```

If you need annotations on setters (for injection perhaps) there is a shorthand syntax.

```kotlin
var stringRep: String = "Default"
    @Inject set // concise declaration for setter injection
```

Visibility can also be modified using similar syntax.

```kotlin
var stringRep: String = "Default"
    private set // Setter has private access
```

#### Local properties

Local properties are transient, unlike var/val they will not become properties in the class.

Primary constructors can't have a code block, so if any initializing logic is required, this can be encapsulated in the init block.

```kotlin
class Thing(nameParam: String) { // property is only in scope in constructor
    val name = nameParam // nameParam can be used to initialize properties too
    init {
        println(nameParam) // nameParam is in scope in the init block as well
    }
}
```

#### Compile time constant

Constant declaration. This has a few limitations, as the value has to be:

- Top-level in a file;
- Value has to be a string or a primitive;
- Can't declare custom getter for the property.

```kotlin
const val path = "/api/users" // Compile time constant

class UserResource {
    @GetMapping(path) 
    fun findUsers(): List<User> { ... } // Can be used as annotation values
}
```

## TODO Accessors

- private
- public 
- internal (package)

## TODO Classes

- Open
- Sealed
- object (singleton)
- abstract
- interface

## TODO null-safety

- !!
- Elvis operator .? 
- etc.

## TODO Lambda syntax

- examples

## TODO Controlling flow

- if
- when

## TODO Keywords

- suspend
- lateinit
- by lazy

## TODO Returns and jumps

- labels
- etc

## TODO Constructors

#### Private constructors

TODO

#### Property declarations 
```kotlin
class SomeType(val name: String)
```

#### Named parameters 
```kotlin
class SomeType(val name: String)
val type = SomeType(name = "Name")
```

#### Default parameters 
```kotlin
class SomeType(val name: String = "name")
```

#### Init blocks 
```kotlin
class SomeType(val firstname: String, val lastname: String) {
    private val fullname:String
    
    init { 
        fullname = firstname + lastname 
    }
}
```

## Functions

#### Top-level functions 
```kotlin
fun sum(left: Int, right: Int) { return left + right } 
Usage: val total = sum(1, 3) 
```

#### Extension functions 
```kotlin
fun Int.add(add: Int) { return this + right } 
Usage: val total = 1.add(3) 
```

#### Infix functions 
```kotlin
infix fun Int.and(add: Int) { return this + right }
Usage: val total = 1 and 3 
```

## Higher order functions

#### Functions returning functions
```kotlin
fun modulo(input: Int): (Int) -> Boolean = {
    it % input == 0
}
Usage: val values = (0..25).filter (modulo(5))
```

#### Functions taking functions as parameters
```kotlin
fun execute(function: () -> Unit) {
    function()
}
Usage: execute { println("Lambda Syntax") }
```

#### Passing function references to functions
```kotlin
fun function(){ println("Executed") }
Usage: execute(::function())
```

#### Invoking function references
```kotlin
fun modulo(input: Int): (Int) -> Boolean = {
    it % input == 0
}
val moduloReference = modulo(3)
Usage: val result = moduloReference.invoke(5)
```

## Data classes

#### General data class definition
```kotlin
data class Person(val name: String)
``` 
#### Property declarations
```kotlin
data class Person(
    val name: String,
    val lastname: String,
    var email: String, // mutable
)
``` 

#### Generated functions
```kotlin
val person: Person("First", "Last", "first@last.com")
person.toString() 
person.equals() 
person.hashcode() 
```

#### Creating copies
```kotlin
val person: Person("First", "Last", "first@last.com")
val copiedPerson = person.copy() // or:
val copiedPerson = person.copy(email = "new@newemail.com") // change email (or any given property)
```

## Generics
    
#### Covariant generics 
```kotlin
class SomeType <out T>
```
#### Contravariant generics
```kotlin
class SomeType <in T>
```
#### Invariant generics 
```kotlin
class SomeType <T>
```
#### Wildcards 
```kotlin
class SomeType <*>
```
