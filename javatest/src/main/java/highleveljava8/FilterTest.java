package highleveljava8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author qtq
 * @Created on 2019-10-01 20:36.
 */
public class FilterTest {

    public static void main(String[] args) {

        FilterServiceImpl impl = new FilterServiceImpl();
        //Filter的注释用法
        List<Person> personList = Arrays.asList(
                new Person("zhagnsan", 20),
                new Person("cehgnliu", 22),
                new Person("cehgnliu", 30),
                new Person("cehgnliu", 40)
        );
        List<Person> resultList = impl.getPersonByAge(25, personList, (age, lists) -> lists.stream().filter(e -> e.getAge() > age)
                .collect(Collectors.toList()));

//        resultList.forEach(System.out::println);
        resultList.forEach(e -> System.out.println(e.getUsername() + "," + e.getAge()));


        //Consumer
    }
}
