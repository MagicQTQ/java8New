package file;

import java.io.*;

/*
    文件复制的操作
 */
public class FileCopyDemo {

    public static void main(String[] args) throws IOException {

        File srcString = new File("e:\\aaa");

        File destString = new File("c:\\test");
        // 如果文件夹不存在，则新建
        if (!destString.exists()) {
            destString.mkdirs();
        }

        File[] lists = srcString.listFiles();

        for (File file : lists) {
            System.out.println(file);// e:\aaa\张三_001_自我介绍1.txt

            String name = file.getName();// 张三_001_自我介绍1.txt
            File target = new File(destString, name);// c:\test\张三_001_自我介绍1.txt

            System.out.println(target);
            CopyFile(file, target); // 注意这里复制的是file，而不是srcString
        }

    }

    public static void copyFile2(String srcString ,String descString) throws IOException {
        BufferedInputStream ios = new BufferedInputStream(new FileInputStream(srcString));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(descString));

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len =ios.read(bys)) != -1){
            bos.write(bys,0,len);
        }
        ios.close();
        bos.close();
    }

    public static void CopyFile(File srcString, File target) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(srcString));

        BufferedWriter bw = new BufferedWriter(new FileWriter(target));

        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        bw.close();
    }
}
