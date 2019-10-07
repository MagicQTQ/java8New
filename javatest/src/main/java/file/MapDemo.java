package file;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * @Author qtq
 * @Created on 2019-09-25 14:38.
 */
public class MapDemo {
    public static void main(String[] args) {

        String response = "asf";
        System.out.println(ImmutableMap.of("isClick", "123", "response", response));

        System.out.println("==================================================================");
        Map<Integer, String> INTEGER_STRING_MAP = new ImmutableMap.Builder<Integer, String>().
                put(30, "IP地址或地址段").
                put(31, "端口号或范围").
                put(32, "IP地址或地址段").
                put(33, "端口号或范围")
                .build();

        //另一种写法
        //Map<Integer,String> activityMsgMap = ImmutableMap.<Integer,String>builder().
        //            put(30, "IP地址或地址段").
        //            put(31, "端口号或范围").
        //            put(32, "IP地址或地址段").
        //            put(33, "端口号或范围").
        //            build();

        Integer key = 30;
        System.out.println("key = " + key + "的提示语是：" + INTEGER_STRING_MAP.get(key));

    }
}