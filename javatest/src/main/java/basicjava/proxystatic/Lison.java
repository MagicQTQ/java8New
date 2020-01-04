package basicjava.proxystatic;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:51.
 *
 * 静态代理：缺点违反开闭原则，当有多个类需要代理，则无法扩展【可维护性和扩展性较差】
 *
 * Lison类：代理类，代理AaFactory，二者都要继承 MantoolsFactory 接口
 *
 */
public class Lison implements MantoolsFactory {


    private AaFactory aaFactory;

    public Lison(AaFactory aaFactory) {
        super();
        this.aaFactory = aaFactory;
    }


    @Override
    public void saleManTools(int size) {
        doSomethingStart();
        aaFactory.saleManTools(size);
        doSomethingEnd();
    }

    //增强方法
    private void doSomethingStart(){
        System.out.println("静态方法：包装精美，全程快递一条龙服务");
    }

    private void doSomethingEnd(){
        System.out.println("静态方法：售后7天无理由包退换");
    }
}
