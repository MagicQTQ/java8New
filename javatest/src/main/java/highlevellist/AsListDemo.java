package highlevellist;

import java.util.Arrays;
import java.util.List;

/*
 * 可变参数：定义方法的时候不知道该定义多少个参数
 * 格式：
 * 		修饰符 返回值类型 方法名(数据类型…  变量名){}
 *
 * 		注意：
 * 			这里的变量其实是一个数组
 * 			如果一个方法有可变参数，并且有多个参数，那么，可变参数肯定是最后一个
 *
   public static <T> List<T> asList(T... a):把数组转成集合
 *  注意事项：
 * 		虽然可以把数组转成集合，但是集合的长度不能改变。【可以修改元素】
 */
public class AsListDemo {

    public static void main(String[] args) {
        // 定义一个数组
        // String[] strArray = { "hello", "world", "java" };
        // List<String> list = Arrays.asList(strArray);

        List<String> list = Arrays.asList("hello", "world", "java");
        // UnsupportedOperationException
        // list.add("javaee");
        // UnsupportedOperationException
        // list.remove(1);
        list.set(1, "javaee"); //可以修改元素，其本质还是一个数组

        for (String s : list) {
            System.out.println(s);
        }
    }

}
