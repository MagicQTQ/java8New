package com.concurrent;

/**
 * Created by Administrator on 2018/12/23.
 */
public class Demo1Runnable {
    //定义一个方法，方法的参数是一个函数式接口Runnable
    public static void startThread(Runnable r1) {
        //开始线程
        new Thread(r1).start();
    }

    public static void main(String[] args) {
        //使用匿名内部类
        startThread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了");
            }
        });
        //使用Lambda表达式
        startThread(() -> {
            System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了");
        });
        //使用简化后的Lambda表达式
        startThread(() -> System.out.println(Thread.currentThread().getName() + "-->" + "线程启动了"));
    }
}
