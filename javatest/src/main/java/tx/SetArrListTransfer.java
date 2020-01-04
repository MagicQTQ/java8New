package tx;

import java.util.*;

/**
 * @Author qtq
 * @Created on 2019-12-06 15:52.
 * array set list的互转  //Arrays.asList() 和 Collection.toArray()
 */
public class SetArrListTransfer {


    public static void main(String[] args) {
        System.out.println("=================array---list==========================");
        // Array转List【对s的修改，直接影响到list】
        String[] s = new String[]{"A", "B", "C", "D", "E"};
        List<String> list = Arrays.asList(s);

        // List转Array
        String[] dest = list.toArray(new String[0]);//new String[0]是指定返回数组的类型
        System.out.println("List to Arrays: " + Arrays.toString(dest));

        list.set(0, "Z");
        System.out.println("modified list: " + list); // modified list: [Z, B, C, D, E]
        System.out.println("dest Arrays: " + Arrays.toString(dest));  // 目标数组不变 dest Arrays: [A, B, C, D, E]


        System.out.println("====================set---list========================");

        //List转Set
        Set<String> set = new HashSet<>(list);
        System.out.println("set: " + set);
        //Set转List
        List<String> list_1 = new ArrayList<>(set);
        System.out.println("list_1: " + list_1);

        // 和toArray()一样，被转换的List(Set)的修改不会对被转化后的Set（List）造成影响

        System.out.println("===============array---set====================");

        //array转set
        s = new String[]{"A", "B", "C", "D", "E"};
        set = new HashSet<>(Arrays.asList(s));
        System.out.println("set: " + set);
        //set转array
        dest = set.toArray(new String[0]);
        System.out.println("array: " + Arrays.toString(dest));

    }

}
