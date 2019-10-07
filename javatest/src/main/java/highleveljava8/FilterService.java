package highleveljava8;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @Author qtq
 * @Created on 2019-10-01 20:37.
 */
@FunctionalInterface
public interface FilterService {

    List<Person> getPersonByAge(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction);
}
