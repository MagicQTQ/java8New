package file.multithread.runnableInter.con_produer_update;

public class Student {
    private String name;
    private int age;
    private boolean flag; // 默认情况是没有数据，如果是true，说明有数据

    //有数据就等待，没有数据就生产
    public synchronized void set(String name, int age) {
        if (this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        setName(name);
        setAge(age);

        this.flag = true;
        this.notify();

    }

    public synchronized void get() {
        if (!this.flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + "----" + getAge());

        this.flag = false;

        this.notify();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}