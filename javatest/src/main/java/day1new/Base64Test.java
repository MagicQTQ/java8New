/**
 * @file Base64Test.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package day1new;

import java.io.*;
import java.util.Base64;

/**
 * base64在Java8成为了标准类库的一部分
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-11-07
 */
public class Base64Test {


    public static void main(String[] args) {
        // 图片转成Base64
        encode();
    }

    public static void encode() {
        File file = new File("D:\\images\\2019\\0729\\1.png");
        try (InputStream is = new FileInputStream(file)) {
            byte data[] = new byte[is.available()];
            is.read(data);
            is.close();
            Base64.Encoder base64 = Base64.getEncoder();
            String base64Str = base64.encodeToString(data);
            StringBuffer stringBuffer = new StringBuffer("data:image/jpeg;base64,");
            stringBuffer.append(base64Str);
            System.out.println(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
