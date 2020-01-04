package basicjava.proxydynamic;

/**
 * @Author qtq
 * @Created on 2019-12-06 17:17.
 */
public class BbFactory implements WomanToolsFactory {


    @Override
    public void saleManTools(int size) {
        System.out.println("定制了一个" + size + "大的衣服");
    }
}
