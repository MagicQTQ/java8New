package file.multithread.runnableInter;

/*
    出现重复的票 和 带有负数的票[线程安全问题] 用同步关键字 synchronized，分别在代码块，方法 ，静态方法上
 */
public class SellTicketDemo {
    public static void main(String[] args) {
        // 创建三个线程对象（Thread的方式）
//		SellTicket st1 = new SellTicket();
//		SellTicket st2 = new SellTicket();
//		SellTicket st3 = new SellTicket();
        // 给线程对象起名字
//		st1.setName("窗口1");
//		st2.setName("窗口2");
//		st3.setName("窗口3");
        // 启动线程
//		st1.start();
//		st2.start();
//		st3.start();

        // 新建资源对象
        SellTicket s1 = new SellTicket();

        // 创建线程[共同操作SellTicket类的资源]
        Thread t1 = new Thread(s1, "线程1");
        Thread t2 = new Thread(s1, "线程2");
        Thread t3 = new Thread(s1, "线程3");

        t1.start();
        t2.start();
        t3.start();
    }
}