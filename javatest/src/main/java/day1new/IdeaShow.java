package day1new;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qtq
 * @Created on 2019-09-01 17:17.
 */
public class IdeaShow {

    public static void main(String[] args) {
        int b=123;
        String str ="345";

        //IDEA:project = Eclipse:Workspace ; IDEA:module = Eclipse:project

        // soutp  "方法形参名 = " + 形参名
        // soutv  "变量名 = " + 变量
        // soutm  "当前类名.当前方法"
        // “abc”.sout => System.out.println("abc");
        System.out.println("b = " + b);

        List<String> strList = new ArrayList<>();

        strList.add("qwe");
        strList.add("asdf");

        // iter 增强for循环
        for (String ss : strList) {
        }
        // itar 普通for循环
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            
        }

        System.out.println("IndexController.index");
    }
}
