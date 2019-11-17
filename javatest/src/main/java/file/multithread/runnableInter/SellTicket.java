package file.multithread.runnableInter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SellTicket implements Runnable {
    //public class SellTicket extends Thread {  // Thread 有默认的getName 获取线程名字方法
    // 定义100张票
    // private int tickets = 100;
    // 为了让多个线程对象共享这100张票，我们其实应该用静态修饰
    private static int tickets = 100;

    //加了这个锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        // 定义100张票
        // 每个线程进来都会走这里，这样的话，每个线程对象相当于买的是自己的那100张票，这不合理，所以应该定义到外面
        // int tickets = 100;

        // 是为了模拟一直有票
        // CPU的每一次执行必须是一个原子性(最简单基本的)的操作。
        // 先记录以前的值
        // 接着把ticket--
        // 然后输出以前的值(t2来了)
        // ticket的值就变成了99
        // 窗口1正在出售第100张票
        // 窗口2正在出售第100张票
        while (true) {
            try {

                lock.lock();
                if (tickets > 0) {
                    try {
                        Thread.sleep(100); //t1进来了并休息，t2进来了并休息，t3进来了并休息，
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "正在出售第" + (tickets--) + "张票");
                    //窗口1正在出售第1张票,tickets=0
                    //窗口2正在出售第0张票,tickets=-1
                    //窗口3正在出售第-1张票,tickets=-2
                } else
                    break;
            } finally {
                lock.unlock();
            }
        }
    }
}
