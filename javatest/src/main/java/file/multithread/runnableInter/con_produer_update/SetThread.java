package file.multithread.runnableInter.con_produer_update;

public class SetThread implements Runnable {

    private Student s;
    private int x = 0;

    public SetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {

            if (x % 2 == 0) {
                s.set("林青霞", 27);  //没有数据就生产，有数据就消费
            } else {
                s.set("liufei", 30);
            }
            x++; //x=1

        }
    }
}

