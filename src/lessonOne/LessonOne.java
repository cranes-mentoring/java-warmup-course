package lessonOne;

import lessonOne.eq.UsefulObject;
import lessonOne.recordExample.UserPost;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class LessonOne {

    public static void main(String[] args) {
        /** types */
        boolean bool = true;
        byte b = 100;
        short sh = 10_000;
        char ch = 'a';
        int i = 1_000_000;
        float f = 1.3f;
        long l = 100_000_000L;
        double d = 1.2;

        /* Also we can use var instead of type
         * example: var i = 1;
         * */
        var intType = 1;
        var flag = false;
        var strangeChar = 'c';

        // how we can compare primitives
        int a = 1;
        int c = 1;
        System.out.println(a == c); // true
        System.out.println(a > c); // false
        System.out.println(a < c); // false
        System.out.println(a >= c); // true
        System.out.println(a <= c); // true
        System.out.println(a != c); // false

        // class wrapper
        Integer ai = Integer.valueOf(1), bi = Integer.valueOf(1);
        System.out.println(ai == bi); // true

        Integer ac = Integer.valueOf(128), bc = Integer.valueOf(128);
        System.out.println(ac == bc); // false

        /** compare classes */
        // strings
        String s1 = "hello";
        String s2 = "word";
        System.out.println(s1 == s2); // false
        System.out.println(s1.equals(s2)); // false

        String s3 = "prql";
        String s4 = "prql";
        System.out.println(s3 == s4); // true

        String s5 = "s";
        String s6 = new String("s");
        System.out.println(s5 == s6); // false

        // extra: Comparator
        Comparator<UserPost> postRidComparator = Comparator.comparing(UserPost::postRid);

        /** switch, case */
        int expression = 9;
        switch (expression) {
            case 2:
                System.out.println("Small Size");
                break;

            case 3:
                System.out.println("Large Size");
                break;

            // default case
            default:
                System.out.println("Unknown Size");
        }

        // new one
        Day day = Day.WEDNESDAY;
        var resultDay = switch (day) {
            case MONDAY, FRIDAY, SUNDAY -> 6;
            case TUESDAY -> 7;
            case THURSDAY, SATURDAY -> 8;
            case WEDNESDAY -> 9;
            default -> throw new IllegalStateException("Invalid day: " + day);
        };
        System.out.println(resultDay);
    }

    /**
     * try and catch
     **/

    public int find(String playerFile) {
        try {
            Scanner contents = new Scanner(new File(playerFile));
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException noFile) {
            throw new IllegalArgumentException("Couldn't find the file");
        }
    }

    // with resources
    public int findAnotherOne(String playerFile) {
        try (Scanner contents = new Scanner(new File(playerFile))) {
            return Integer.parseInt(contents.nextLine());
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file");
            return 0;
        }
    }

    // don't do it!
    public int findAnotherOneForAnotherOne(String playerFile) {
        try {
            // action
        } catch (Exception e) {
        } // <== catch and swallow
        return 0;
    }

    public void collections() {
        // old way:
        List<String> old = new ArrayList<>();
        old.add("one");

        // new way:
        List<String> list = Arrays.asList("one", "two");
        List<String> list2 = List.of("one", "two", "three");
        Set<String> set = Set.of("one", "two", "three");

        // old:
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1, "foo");

        // new:
        Map<String, String> map = Map.of("foo", "one", "bar", "two");

        // Intermediate Operations
        var stream = Stream.of("one", "two", "lets go!");
        // you can use stream only once! like a pipeline, it will be closed after using

        var filter = stream.filter(str -> str.equals("test"));
        var mapOperation = stream.map(str -> str + "new part for each str");
//        stream.filter();
//        stream.map();
//        stream.flatMap();
//        stream.distinct();
//        stream.sorted();
//        stream.peek();
//        stream.limit();
//        stream.skip();

        // Terminal
        stream.forEach(str -> System.out.println(str));
        // or
        stream.forEach(System.out::println);
//        stream.reduce();
//        stream.forEach();
//        stream.min();
//        stream.max();
//        stream.anyMatch();
//        stream.allMatch();
//        stream.noneMatch();
//        stream.findAny();
//        stream.findFirst();
//        stream.toArray();
//        stream.collect();
//        stream.count();
//        stream.forEachOrdered();
    }

    public void optional() {
        var empty = Optional.empty();
        empty.isPresent(); // false

        var name = "name";
        var notEmpty = Optional.of(name);
        notEmpty.isPresent(); // true

        String name1 = null;
        Optional<String> opt = Optional.ofNullable(name1);
        opt.isPresent(); // false

        String name2 = null;
        String result = Optional.ofNullable(name2).orElse("Default");

        // get result
        var name3 = Optional.of("Name");
        name3.get();

        String name4 = Optional.ofNullable(name2)
                .orElseThrow(IllegalArgumentException::new);

        // throw NoSuchElementException.class
        Optional.ofNullable(name4).orElseThrow();
    }


    public void executor() {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        var testObject = new UsefulObject();

        executor.submit(() -> testObject.setTestString("test_1"));
        executor.submit(() -> testObject.setTestString("test_2"));
        executor.submit(() -> testObject.setTestString("test_3"));
        executor.submit(() -> testObject.setTestString("test_4"));

        System.out.println(testObject.getTestString()); // ???
    }
}
