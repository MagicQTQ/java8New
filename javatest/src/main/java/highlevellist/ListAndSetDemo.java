package highlevellist;

import java.util.*;

/**
 * List 和 Set 的并交补集
 */
public class ListAndSetDemo {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        //并集
//        list1.addAll(list2);
        //交集
//        list1.retainAll(list2);
        //差集
//        list1.removeAll(list2);
        //无重复并集
//        list2.removeAll(list1);
//        list1.addAll(list2);

        Iterator<String> it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

// =========================  Set的操作  ==============================================
        String[] str1 = {"a", "b", "c", "d", "e"};
        String[] str2 = {"d", "e", "f", "g", "h"};

        Set<String> set1 = new HashSet<>(Arrays.asList(str1));
        Set<String> set2 = new HashSet<>(Arrays.asList(str2));
        Set<String> set = new HashSet<>();

        // 并集
        set.addAll(set1);
        set.addAll(set2);
        System.out.println("并集" + set);

        // 交集
        set.clear();
        set.addAll(set1);
        set.retainAll(set2);
        System.out.println("交集" + set);
        // 差集
        set.clear();
        set.addAll(set1);
        set.removeAll(set2);
        System.out.println("差集" + set);



    }
}