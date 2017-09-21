package nl.sourcelabs.instructor

/**
 * Using higher order functions (=function with another function as a parameter) in Kotlin feels very natural while using it.
 * But it causes some memory overhead due to the usage of Lambdas. To optimize this behaviour kotlin allows you to inline
 * these higher-order functions. Which means that the compiler will copy the code of the inline function to the call site and
 * not using an Object for it.
 *
 * Consider the following method which times the duration of the execution of a function. We pass the function as an argument to
 * the stopwatch method. stopwatch is therefore an higher-order function because it accepts a function as an argument.
 */
inline fun stopwatch(unit: () -> Unit) {
    val start = System.currentTimeMillis()
    unit()
    val duration = System.currentTimeMillis() - start
    println("Execution took: $duration ms.")
}

/**
 * When we invoke it twice in the code below, the inline on the stopwatch function causes the stopwatch code the be inlined (copied)
 * to the main functions byte code.
 */
fun main(args: Array<String>) {
    stopwatch {
        println("Doing stuff that takes almost no time at all!")
    }
    stopwatch {
        println("Other stuff that takes almost no time at all!")
    }
}


/**
 * Below the decompiled Java code for the inline function invocation. Be sure to look at the main class and see the inlined (copied) code!
 *
 * package nl.sourcelabs.instructor;
 *
 * import java.io.PrintStream;
 * import kotlin.Metadata;
 * import kotlin.Unit;
 * import kotlin.jvm.functions.Function0;
 * import kotlin.jvm.internal.Intrinsics;
 * import org.jetbrains.annotations.NotNull;
 *
 * @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\000\032\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003\n\002\030\002\n\000\032\031\020\000\032\0020\0012\f\020\002\032\b\022\004\022\0020\0040\003��\006\002\020\005\032\027\020\006\032\0020\0012\f\020\007\032\b\022\004\022\0020\0010\bH��\b��\006\t"}, d2={"main", "", "args", "", "", "([Ljava/lang/String;)V", "stopwatch", "unit", "Lkotlin/Function0;", "kotlin-workshop"})
 * public final class InlineFunctionExampleKt
 * {
 *   public static final void stopwatch(@NotNull Function0<Unit> unit)
 *   {
 *     ;
 *     Intrinsics.checkParameterIsNotNull(unit, "unit");long start = System.currentTimeMillis();
 *     unit.invoke();
 *     long duration = System.currentTimeMillis() - start;
 *     String str = "Execution took: " + duration + " ms.";System.out.println(str);
 *   }
 *
 *   public static final void main(@NotNull String[] args)
 *   {
 *     Intrinsics.checkParameterIsNotNull(args, "args");
 *     int $i$f$stopwatch;
 *     long start$iv = System.currentTimeMillis();
 *     int $i$a$1$stopwatch;
 *     String str1 = "Doing stuff that takes almost no time at all!";System.out.println(str1);
 *
 *     long duration$iv = System.currentTimeMillis() - start$iv;
 *     String str2 = "Execution took: " + duration$iv + " ms.";System.out.println(str2);
 *     int $i$f$stopwatch;
 *     long start$iv = System.currentTimeMillis();
 *     int $i$a$2$stopwatch;
 *     str1 = "Doing stuff that takes almost no time at all!";System.out.println(str1);
 *
 *     long duration$iv = System.currentTimeMillis() - start$iv;
 *     str2 = "Execution took: " + duration$iv + " ms.";System.out.println(str2);
 *   }
 * }
 **/


/**
 * Below the non inline decompiled Java code. Two instances of Function0 are created and invoked from the main method.
 *
 * package nl.sourcelabs.instructor;
 *
 * import java.io.PrintStream;
 * import kotlin.Metadata;
 * import kotlin.Unit;
 * import kotlin.jvm.functions.Function0;
 * import kotlin.jvm.internal.Intrinsics;
 * import kotlin.jvm.internal.Lambda;
 * import org.jetbrains.annotations.NotNull;
 *
 * @Metadata(mv={1, 1, 7}, bv={1, 0, 2}, k=2, d1={"\000\032\n\000\n\002\020\002\n\000\n\002\020\021\n\002\020\016\n\002\b\003\n\002\030\002\n\000\032\031\020\000\032\0020\0012\f\020\002\032\b\022\004\022\0020\0040\003��\006\002\020\005\032\024\020\006\032\0020\0012\f\020\007\032\b\022\004\022\0020\0010\b��\006\t"}, d2={"main", "", "args", "", "", "([Ljava/lang/String;)V", "stopwatch", "unit", "Lkotlin/Function0;", "kotlin-workshop"})
 * public final class InlineFunctionExampleKt
 * {
 *     public static final void stopwatch(@NotNull Function0<Unit> unit)
 *     {
 *         Intrinsics.checkParameterIsNotNull(unit, "unit");long start = System.currentTimeMillis();
 *         unit.invoke();
 *         long duration = System.currentTimeMillis() - start;
 *         String str = "Execution took: " + duration + " ms.";System.out.println(str);
 *     }
 *
 *     public static final void main(@NotNull String[] args)
 *     {
 *         Intrinsics.checkParameterIsNotNull(args, "args");
 *
 *         stopwatch((Function0)main.1.INSTANCE);
 *
 *         stopwatch((Function0)main.2.INSTANCE);
 *     }
 * }
 **/
