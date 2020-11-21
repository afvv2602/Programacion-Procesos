
public class Ejercicio1 {

	public synchronized static void main(String[] args) {
		Object obj = new Object();
		cucu c = new cucu();
		tras t = new tras();
//		synchronized (obj) {
//			c.start();
//			t.start();
//			try {
//				c.wait();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			t.notifyAll();
//
//		}
		c.start();
		t.start();

	}
}

class cucu extends Thread {
	public void run() {
		while (true) {
			System.out.println("CUCU");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class tras extends Thread {

	public void run() {
		while (true) {
			System.out.println("TRAS");
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
