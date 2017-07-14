package nl.sourcelabs.solutions;

public class E07_ObjectVsClassFromJava {
    public static void main(String[] args) {
        /**
         * Invoke HelloworldO sayHello
         * Invoke HelloworldO sayHello("yourname")
         */
        HelloworldOE07.INSTANCE.sayHello(); // Generated because of the @JvmOverloads
        HelloworldOE07.INSTANCE.sayHello("Stephan");

        // Bonus: static by specifying @JvmStatic on a object function

        HelloworldOE07.sayHello(); // Generated because of the @JvmOverloads
        HelloworldOE07.sayHello("Stephan");

        /**
         * Invoke HelloworldC sayHello
         * Invoke HelloworldC sayHello("yourname")
         */
        new HelloworldCE07().sayHello();
        new HelloworldCE07().sayHello("Stephan");
    }
}
