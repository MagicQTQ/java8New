package tx;


import com.google.common.collect.Sets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * List 和 Set 的并交补集
 */
public class ListAndSetProp {

    private static final Set set1 = Sets.newHashSet(1, 2, 3, 4);
    private static final Set set2 = Sets.newHashSet(4, 5, 6);

    public static void main(String[] args) throws IOException {

        System.out.println(StringUtils.isBlank(""));

        // 并集
        Set<Integer> unionSet = Sets.union(set1, set2); // [1, 2, 3, 4, 5, 6]
        System.out.println(unionSet);

        //交集
        Set<Integer> interSet = Sets.intersection(set1, set2); //[4]
        System.out.println(interSet);

        //差集
        Set<Integer> diffSet = Sets.difference(set1, set2); // 1,2,3 [set1与set2的相比，set1独有的数值 ]
        System.out.println(diffSet);

        //相对差集，【与交集返回的数值相反的】
        Set<Integer> bothDiffSet = Sets.symmetricDifference(set1, set2); // [1, 2, 3, 5, 6]
        System.out.println(bothDiffSet);


        //两个集合的笛卡尔积
        Set cartSet = Sets.cartesianProduct(set1, set2);
        System.out.println(cartSet); // [[1, 4], [1, 5], [1, 6], [2, 4], [2, 5], [2, 6], [3, 4], [3, 5], [3, 6], [4, 4], [4, 5], [4, 6]]


        // guava的文件拷贝
        CharSource source = Files.asCharSource(new File(("D:\\note.txt")), Charsets.toCharset("UTF-8"));
        CharSink sink = Files.asCharSink(new File("e:\\note-2.txt"), Charsets.toCharset("UTF-8"));
        source.copyTo(sink);

        //类路径下的文件拷贝[springMvc下才能加载]
//        try (InputStream in = = new ClassPathResource("classpath:templates/qly.jasper").getInputStream();
//             BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream("qly-2.jasper"))) {
//            IOUtils.copy(in, os);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }
}