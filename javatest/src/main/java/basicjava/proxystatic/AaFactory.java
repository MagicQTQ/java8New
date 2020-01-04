package basicjava.proxystatic;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:46.
 */
public class AaFactory implements MantoolsFactory {

    @Override
    public void saleManTools(int size) {
        System.out.println("为您定制一个"+size+"大的衣服");
    }
}
