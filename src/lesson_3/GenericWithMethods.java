package lesson_3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericWithMethods {

    public <T> List<T> collect(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public <T extends Number> List<T> collectNumbers(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public <T extends Number & Comparable> List<T> collectNumbersAndComparable(T[] array) {
        return Arrays.stream(array).collect(Collectors.toList());
    }

    public void findAllHosts(List<? extends Connector> connectors) {
        connectors.stream().map(Connector::host).forEach(System.out::println);
    }

}
