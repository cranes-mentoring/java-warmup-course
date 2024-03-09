package lesson_3;

public class GenericWithClasses<T> {

    // variable of T type
    private T data;

    public GenericWithClasses(T data) {
        this.data = data;
    }

    // method that return T type variable
    public T getData() {
        return this.data;
    }

}
