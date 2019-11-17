package file.io.in;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * 计算机是如何识别什么时候该把两个字节转换为一个中文呢?
 * 在计算机中中文的存储分两个字节：
 * 		第一个字节肯定是负数。
 * 		第二个字节常见的是负数，可能有正数。但是没影响。
 */
public class BytesTransDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // String s = "abcde";
        // // [97, 98, 99, 100, 101]

        String str = "我爱你中国";
        // [-50, -46, -80, -82, -60, -29, -42, -48, -71, -6]

        byte[] ch = str.getBytes();
        System.out.println(Arrays.toString(ch));


        String s = "你好";

        // String -- byte[]
       // byte[] bys = s.getBytes(); // [-60, -29, -70, -61]
        // byte[] bys = s.getBytes("GBK");// [-60, -29, -70, -61]  GBK:一个中文三个字节
         byte[] bys = s.getBytes("UTF-8");// [-28, -67, -96, -27, -91, -67] UTF-8:一个中文三个字节
        System.out.println(Arrays.toString(bys));

        // byte[] -- String
        String ss = new String(bys); // 你好
        // String ss = new String(bys, "GBK"); // 你好
        // String ss = new String(bys, "UTF-8"); // ???
        System.out.println(ss);
    }
}
