package file;

import org.apache.commons.io.output.WriterOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author qtq
 * @Created on 2019-09-08 19:34.
 */
public class IOCopyFile {

    public static void main(String[] args) throws Exception {

//        try (FileInputStream in = new FileInputStream("D:\\file2.txt");
//             FileOutputStream out = new FileOutputStream(new File("D:\\abc.txt"))) {
//
//            IOUtils.copy(in, out);
////            byte[] bytes = IOUtils.toByteArray(in);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Files.copy(Paths.get("D:\\file2.txt"), new FileOutputStream("output.txt"));  //NIO的复制文件
//
//        List<String> lists = new ArrayList<>();
//        lists.add("hello");
//        lists.add("world");
//        lists.add("java");
//        Files.write(Paths.get("array.txt"), lists, Charset.forName("UTF-8"));
    }
}
