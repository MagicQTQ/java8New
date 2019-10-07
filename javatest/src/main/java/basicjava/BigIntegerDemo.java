package basicjava;

import java.math.BigInteger;

/**
 * @Author qtq
 * @Created on 2019-09-07 18:56.
 */
public class BigIntegerDemo {
  /*
    Integer包装类里面没有加减乘除的方法

    * public BigInteger add(BigInteger val):加
    * public BigInteger subtract(BigInteger val):减
    * public BigInteger multiply(BigInteger val):乘
    * public BigInteger divide(BigInteger val):除
    * public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
 */
    public static void main(String[] args) {

        BigInteger bi1 = new BigInteger("100");
        BigInteger bi2 = new BigInteger("50");

        // public BigInteger add(BigInteger val):加
        System.out.println("add:" + bi1.add(bi2));
        // public BigInteger subtract(BigInteger val):减
        System.out.println("subtract:" + bi1.subtract(bi2));
        // public BigInteger multiply(BigInteger val):乘
        System.out.println("multiply:" + bi1.multiply(bi2));
        // public BigInteger divide(BigInteger val):除
        System.out.println("divide:" + bi1.divide(bi2));

        // public BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
        BigInteger[] bis = bi1.divideAndRemainder(bi2);
        System.out.println("商：" + bis[0]);
        System.out.println("余数：" + bis[1]);

        Integer i1 = new Integer("200");
        Integer i2 = new Integer("25");



    }

}
