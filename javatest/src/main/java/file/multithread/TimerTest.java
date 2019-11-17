package file.multithread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author qtq
 * @Created on 2019-11-17 13:37.
 */
public class TimerTest {

    public static void main(String[] args) {

        Timer tt = new Timer();
        tt.schedule(new MyTask(tt), 2000,2000);  //定时器3秒执行 MyTask的run方法
    }
}

class MyTask extends TimerTask {

    private Timer t;

    public MyTask() {
    }

    public MyTask(Timer t) {
        this.t = t;
    }

    @Override
    public void run() {
        System.out.println("beng，爆炸了！");
//        t.cancel();  //爆炸一次
    }
}
