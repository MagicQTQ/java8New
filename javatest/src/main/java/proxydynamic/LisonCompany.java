package proxydynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author qtq
 * @Created on 2019-09-01 12:51.
 * <p>
 * 动态代理：可以动态创建多个代理类【proxy，InvocationHandler】
 * <p>
 * 创建Proxy实例
 * 实现InvocationHandler接口
 * <p>
 * LisonCompany：代理类，代理AaFactory，二者都要继承 MantoolsFactory 接口
 *
 * 核心源码：
 * long num = nextUniqueNumber.getAndIncrement();
 * String proxyName = proxyPkg + proxyClassNamePrefix + num; //$Proxy0
 *
 * byte[] proxyClassFile = ProxyGenerator.generateProxyClass(  //生成字节码文件
 * proxyName, interfaces, accessFlags);
 *
 */
public class LisonCompany implements InvocationHandler {


    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    @Override
    //通过动态代理对象 对方法进行增强
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSomethingStart();
        Object invoke = method.invoke(factory, args);
        doSomethingEnd();
        return invoke;
    }


    //增强方法
    private void doSomethingStart() {
        System.out.println("动态方法：包装精美，全程快递一条龙服务");
    }

    private void doSomethingEnd() {
        System.out.println("动态方法：售后7天无理由包退换");
    }


}
