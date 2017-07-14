package nl.sourcelabs.solutions;

public class ObjectVsClassFromJava {
    public static void main(String[] args) {
        HelloworldO.INSTANCE.sayHello("Stephan");
        new HelloworldC().sayHello("Stephan");
        //new HelloworldC().calculateTheMeaningOfLife();
        //HelloworldO.sayHello("Stephan");
    }
}
