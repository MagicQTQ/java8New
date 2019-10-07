package day1new;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @Author qtq
 * @Created on 2019-10-01 17:08.
 */
public class OptionalTest {
    public static void main(String[] args) {

        Optional<String> emptyStr = Optional.empty();
        Optional<User> emptyUser = Optional.empty();  //相当于 User nullUser = new User();

        User uu = new User();
        // ofNullable相当于 不存在则User nullUser = new User();  存在则 用该对象 existUser
        // 使用场景：从数据库查出来对象，不知道是否为不为空
        Optional<User> existUser = Optional.ofNullable(uu);

        Optional<User> notNullUser = Optional.of(new User("1", "zhangsan", "1234"));

//        if (emptyUser != null) {
//            System.out.println(emptyUser.get());
//        }

        emptyUser.ifPresent(e -> System.out.println(e));  //推荐使用这个
        notNullUser.ifPresent(e -> System.out.println(e.getUsername()));

        //============================================================================
        System.out.println(emptyStr.orElse("optional test"));
        System.out.println(emptyStr.orElseGet(() -> "optional test"));


        List<User> userList = Arrays.asList(new User("2", "lisi", "lisi123"), new User("3", "wangwu", "wangwu1234"));
        Optional<List<User>> userOptional = Optional.ofNullable(userList);
        userOptional.ifPresent(e -> e.stream().map(User::getUsername).forEach(System.out::println)); // 推荐

// ============================= Function test (一个参数，返回一个结果) ======================
        System.out.println(compose(2, value -> value * 3, value -> value * value));
        System.out.println(compose2(2, value -> value * 3, value -> value * value));

// ============================= BiFunction test (两个参数，返回一个结果) map的输出也是这个 ，加减乘除运算======================

    }

    // 先执行后面的Function函数，即function2，在执行function1的函数方法【扩展:compose可以嵌套 function1.compose(function2.compose().andthen()).apply(a); 】
    private static int compose(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.compose(function2).apply(a);
    }


    // 先执行当前的Function函数，即function1，在执行function2的函数方法，andthen与compose方法相反
    private static int compose2(int a, Function<Integer, Integer> function1, Function<Integer, Integer> function2) {
        return function1.andThen(function2).apply(a);
    }
}
