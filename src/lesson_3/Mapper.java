package lesson_3;

import java.util.List;

public interface Mapper<T, U> {
    U map(T data);

    List<U> map(List<T> listOfData);

}
