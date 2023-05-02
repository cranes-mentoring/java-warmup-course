package lessonThree;

import java.util.LinkedList;
import java.util.List;

public class LessonThree {

    public static void main(String[] args) {
        // Integers
        List<Integer> listOfIntegers = new LinkedList<>();
        // String
        List<String> listOfStrings = new LinkedList<>();

        // methods
        var genericWithMethods = new GenericWithMethods();
        var integers = new Integer[] { 1, 2, 3 };
        genericWithMethods.<Integer>collect(integers);
        // can be simplified to:
        genericWithMethods.collect(integers);
        // public final class Integer extends Number
        genericWithMethods.collectNumbers(integers);
        // reason: no instance(s) of type variable(s) exist so that String conforms to Number
//        genericWithMethods.collectNumbers(new String[] { "test"});

        genericWithMethods.collectNumbersAndComparable(integers);
        // with connectors
        var connectors = List.of(
                new Connector("localhost", 1090),
                new Connector("172.128.0.1", 8080)
        );
        genericWithMethods.findAllHosts(connectors);


        // genericWithMethods
        var genericWithStringClasses = new GenericWithClasses<>("test");
        System.out.println(genericWithStringClasses.getData());

        var genericWithIntegerClasses = new GenericWithClasses<>(123);
        System.out.println(genericWithIntegerClasses.getData());

        // Integers
        var numbers = new GenericWithNumberClasses(123);
        numbers.display();
        // but with String we will have exceptions
//        var strings = new GenericWithNumberClasses("123"); // cast exception
    }
}
