package file.multithread.runnableInter;

public class MyRunnable implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            // 由于实现接口的方式就不能直接使用Thread类的方法了,但是可以间接的使用
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}