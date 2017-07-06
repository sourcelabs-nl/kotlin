# Kotlin - Java

Simple project showing some of the features Kotlin offers to Java developers. Where applicable, this will be accompanied by some Java code showing the difference in syntax and functionality between both languages.

This is intented to be a unidirectional comparison; I will focus on features in Kotlin and if possible map them to Java - not the other way around.

# Topics covered

This is still very much a work-in-progress, but for the time being please have a look at the topics covered in this codebase. The list is below and should be fairly complete.

If you feel there are any mistakes, misconceptions, missing or unclear examples, feel free to let me know.

## Constructors

#### Named parameters 

```kotlin
SomeType(val name: String)
val type = SomeType(name = "Name")
```

#### Property declarations 
```kotlin
SomeType(val name: String)
```

#### Default parameters 
```kotlin
SomeType(val name: String = "name")
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
fun sum(left: Int, right: Int) { return left + right } -> val total = sum(1, 3) 
```

#### Extension functions 
```kotlin
fun Int.add(add: Int) { return this + right } -> val total = 1.add(3) 
```

#### Infix functions 
```kotlin
infix fun Int.and(add: Int) { return this + right } -> val total = 1 and 3 
```

## Higher order functions

#### Functions returning functions
#### Functions taking functions as parameters
#### Invoking function references
#### Passing function references to functions

## Data classes

#### General data class definition
#### Property declarations
#### Tostring
#### Equals
#### Creating copies

## Generics
    
#### Covariant generics ```SomeType <out T>```
#### Contravariant generics ```SomeType <in T>```
#### Invariant generics ```SomeType <T>```
#### Wildcards ```SomeType <*>```
