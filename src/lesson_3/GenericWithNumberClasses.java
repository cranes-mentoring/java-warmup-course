package lesson_3;

public class GenericWithNumberClasses<T extends Number> {

    // variable of T type
    private T data;

    public GenericWithNumberClasses(T data) {
        this.data = data;
    }

    // method that return T type variable
    public T getData() {
        return this.data;
    }

    public void display() {
        System.out.println("This is a bounded type generics class.");
    }
}
