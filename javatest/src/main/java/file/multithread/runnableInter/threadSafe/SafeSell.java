package file.multithread.runnableInter.threadSafe;

public class SafeSell implements Runnable {
    // 定义100张票
    private int tickets = 100;

    @Override
    public void run() {
        while (true) {
//          synchronized (SafeSell.class) {  // 静态方法
            synchronized (this) {   // 方法
                if (tickets > 0) { //要同一把锁才行
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()
                            + "正在出售第" + (tickets--) + "张票");
                }
            }
        }
    }
}
