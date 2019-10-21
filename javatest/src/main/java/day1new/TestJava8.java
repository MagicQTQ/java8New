package day1new;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:41.
 */
public class TestJava8 {
    public static void main(String[] args) {
        String str = "a,b,c,,";
        String[] ary = str.split(",");
        // 预期大于 3，结果是 3
        System.out.println(ary.length);

        // =====================================================
        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("cde");
        // 转成数组要 new，初始化类型和容量，不然返回Object
        String[] strArray = strList.toArray(new String[0]);
        // String[0]

        for (String ss : strArray) {
            if (ss instanceof String) {
                System.out.println(ss);
            }
        }

        // =====================================================
        /*
         * 【强制】不要在 foreach 循环里进行元素的 remove/add 操作。remove 元素请使用 Iterator
		 * 方式，如果并发操作，需要对 Iterator 对象加锁
		 */
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("1".equals(item)) {
                iterator.remove();
            }
        }

        //===================================================
        // diamond 方式，即<>
//        Map<String, byte[]> userMap = new HashMap<>(16);
        Map<String, String> userMap = new HashMap<>(16);
        // 全省略方式
        List<User> users = new ArrayList(10);

        //===================================================
        userMap.put("1", "zhangsan");
        userMap.put("2", "zhangsan1");
        userMap.put("3", "zhangsan2");
        userMap.put("4", "zhangsan3");
        userMap.put("5", "zhangsan4");
        userMap.put("5", "zhangsan7");
        userMap.put(null, null);  //不输出
        userMap.put("6", null);
        userMap.put("8", "zhangsan5");  //输出，位置排到最前
        userMap.put("9", "zhangsan5");  //同一个value，可以映射不同的key

        // 传统的Map迭代方式
        for (Map.Entry<String, String> entry : userMap.entrySet()) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        // JDK8的Map的迭代方式，推荐
        userMap.forEach((x, y) -> {
            System.out.println(x + "：" + y);
        });

        //=====================================================
        List<String> lists = Arrays.asList("as", "df", "bb");

        String ss = lists.stream().collect(Collectors.joining(",", "{{((", "))}}"));
        System.out.println(ss);

        long L1 = LongStream.rangeClosed(1, 100).sum();
        int i2 = IntStream.rangeClosed(1, 100).reduce(Integer::sum).getAsInt();
        System.out.println(L1 + "============" + i2);


        // flatMap：将多个Stream连接成一个Stream ; 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
        /**获取单词，并且去重**/
        List<String> stringList = Arrays.asList("hello welcome", "world haha", "dobi some", "hello world welcome");
        //也可以这样
        stringList.stream().map(item -> item.split(" ")).flatMap(Arrays::stream)
                .distinct().collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));
        System.out.println("========================================================");
        stringList.stream().flatMap(item -> Arrays.stream(item.split(" ")))
                .map(String::toUpperCase)
                .distinct().collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));

        System.out.println("========================================================");
        /**相互组合**/
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2))
                .collect(Collectors.toList())
                .forEach(e -> System.out.print(e + " "));


        list2.stream().flatMap(word -> Arrays.stream(word.split("")))
                .collect(Collectors.toList()).forEach(System.out::println);


        List<User> userList = Arrays.asList(
                new User("2", "lisi1", "lisi123"),
                new User("1", "zhangsan", "zhangsan1234"),
                new User("2", "lisi2", "lisi456"),
                new User("3", "wangwu", "wangwu1234"));

        //根据年龄分组，接着在获取分组里面List单个实体的属性值
        Map<String, List<String>> userGroupByMap = userList.stream()
                .collect(Collectors.groupingBy(User::getId,
                        Collectors.mapping(User::getUsername, Collectors.toList())));



        userGroupByMap.forEach((k, v) -> System.out.println("key:" + k + "，value:" + v));


    }
}
