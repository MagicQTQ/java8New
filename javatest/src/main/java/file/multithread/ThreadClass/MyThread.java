package file.multithread.ThreadClass;

public class MyThread extends Thread {

	public MyThread() {
	}

	public MyThread(String name){
		super(name);
	}

	@Override
	public void run() {
		for (int x = 0; x < 300; x++) {
			System.out.println(getName() + ":" + x);
		}
	}
}
