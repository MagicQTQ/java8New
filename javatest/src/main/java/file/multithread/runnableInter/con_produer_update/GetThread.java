package file.multithread.runnableInter.con_produer_update;

public class GetThread implements Runnable {
    private Student s;

    public GetThread(Student s) {
        this.s = s;
    }

    @Override
    public void run() {
        while (true) {
            s.get(); //有数据就消费，没有数据就等待
        }
    }
}
