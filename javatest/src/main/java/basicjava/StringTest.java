package basicjava;

import java.util.Scanner;

/**
 * @Author qtq
 * @Created on 2019-11-16 20:40.
 */
public class StringTest {

/*
 * String类的判断功能：
 * boolean equals(Object obj):比较字符串的内容是否相同,区分大小写
 * boolean equalsIgnoreCase(String str):比较字符串的内容是否相同,忽略大小写
 * boolean contains(String str):判断大字符串中是否包含小字符串
 * boolean startsWith(String str):判断字符串是否以某个指定的字符串开头
 * boolean endsWith(String str):判断字符串是否以某个指定的字符串结尾
 * boolean isEmpty():判断字符串是否为空。
 *
 * 注意：
 * 		字符串内容为空和字符串对象为空。
 * 		String s = "";
 * 		String s = null;
 */
/*
 * String类的获取功能
 * int length():获取字符串的长度。
 * char charAt(int index):获取指定索引位置的字符 //获取字符
 * int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。 //获取的位置
 * 		为什么这里是int类型，而不是char类型?
 * 		原因是：'a'和97其实都可以代表'a'
 * int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
 * int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
 * int indexOf(String str,int fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。
 * String substring(int start):从指定位置开始截取字符串,默认到末尾。
 * String substring(int start,int end):从指定位置开始到指定位置结束截取字符串(不包括end)。（左闭右开）
 */

/*
String的转换功能
* byte[] getBytes():把字符串转换为字节数组。
 * char[] toCharArray():把字符串转换为字符数组。
 * static String valueOf(char[] chs):把字符数组转成字符串。  //转为字符串
 * static String valueOf(int i):把int类型的数据转成字符串。
 * 		注意：String类的valueOf方法可以把任意类型的数据转成字符串。
 * String toLowerCase():把字符串转成小写。
 * String toUpperCase():把字符串转成大写。
 * String concat(String str):把字符串拼接。
 */
/*
 * String类的其他功能：
 * 替换功能：
 * String replace(char old,char new)
 * String replace(String old,String new)
 * 去除字符串两空格
 * String trim()
 *
 * 按字典顺序比较两个字符串
 * int compareTo(String str)
 * int compareToIgnoreCase(String str)
 */

    public static void main(String[] args) {
        // 定义一个字符串对象
        String s = "helloworld";

        // int length():获取字符串的长度。
        System.out.println("s.length:" + s.length());
        System.out.println("----------------------");

        // char charAt(int index):获取指定索引位置的字符
        System.out.println("charAt:" + s.charAt(7));
        System.out.println("----------------------");

        // int indexOf(int ch):返回指定字符在此字符串中第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('l'));
        System.out.println("----------------------");

        // int indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf("owo"));
        System.out.println("----------------------");

        // int indexOf(int ch,int fromIndex):返回指定字符在此字符串中从指定位置后第一次出现处的索引。
        System.out.println("indexOf:" + s.indexOf('l', 4));
        System.out.println("indexOf:" + s.indexOf('k', 4)); // -1
        System.out.println("indexOf:" + s.indexOf('l', 40)); // -1
        System.out.println("----------------------");

        // 自己练习：int indexOf(String str,int
        // fromIndex):返回指定字符串在此字符串中从指定位置后第一次出现处的索引。

        // String substring(int start):从指定位置开始截取字符串,默认到末尾。包含start这个索引
        System.out.println("substring:" + s.substring(5));
        System.out.println("substring:" + s.substring(0));
        System.out.println("----------------------");

        // String substring(int start,int end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包end索引
        System.out.println("substring:" + s.substring(3, 8));
        System.out.println("substring:" + s.substring(0, s.length()));


        // 键盘录入一个字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String line = sc.nextLine();
        // 定义一个新字符串
        String result = "";
        // 把字符串转成字符数组
        char[] chs = line.toCharArray();
        // 倒着遍历字符串，得到每一个字符
        for (int x = chs.length - 1; x >= 0; x--) {
            // 用新字符串把每一个字符拼接起来
            result += chs[x];
        }
        // 输出新串
        System.out.println("反转后的结果是：" + result);

    }


}
