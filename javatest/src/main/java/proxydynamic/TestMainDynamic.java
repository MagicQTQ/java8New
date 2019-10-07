package proxydynamic;


import proxystatic.AaFactory;
import proxystatic.Lison;
import proxystatic.MantoolsFactory;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:57.
 */
public class TestMainDynamic {

    public static void main(String[] args) {

        MantoolsFactory aa = new AaFactory();

        WomanToolsFactory bb = new BbFactory();

        LisonCompany company = new LisonCompany();
        company.setFactory(aa);

        MantoolsFactory proxyAA = (MantoolsFactory)company.getProxyInstance();
        System.out.println(proxyAA);
        proxyAA.saleManTools(4);

        company.setFactory(bb);
        WomanToolsFactory proxyBB = (WomanToolsFactory)company.getProxyInstance();
        System.out.println(proxyBB);
        proxyBB.saleManTools(5);

    }
}
