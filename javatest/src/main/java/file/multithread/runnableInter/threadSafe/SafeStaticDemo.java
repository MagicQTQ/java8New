package file.multithread.runnableInter.threadSafe;

/*
 * A:同步代码块的锁对象是谁呢?
 * 		任意对象。
 *
 * B:同步方法的格式及锁对象问题?
 * 		把同步关键字加在方法上。
 *
 * 		同步方法是谁呢?
 * 			this
 *
 * C:静态方法及锁对象问题?
 * 		静态方法的锁对象是谁呢?
 * 			类的字节码文件对象。(反射会讲) 类.class
 */
public class SafeStaticDemo {
    public static void main(String[] args) {
        // 创建资源对象
        SafeStatic st = new SafeStatic();

        // 创建三个线程对象
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");

        // 启动线程
        t1.start();
        t2.start();
        t3.start();
    }
}