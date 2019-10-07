package highleveljava8;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @Author qtq
 * @Created on 2019-10-01 20:40.
 */
public class FilterServiceImpl implements FilterService {
    @Override
    public List<Person> getPersonByAge(int age, List<Person> personList, BiFunction<Integer, List<Person>, List<Person>> biFunction) {
        return biFunction.apply(age, personList);
    }
}
