public class Main {
	public static void main(String[] args) {
		Main m = new Main();
		Runnable r1 = () -> m.doA();
		Runnable r2 = () -> m.doB();
		new Thread(r1).start();
		new Thread(r2).start();
	}
	synchronized void doA() {
		System.out.println("A");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	synchronized void doB() {
		System.out.println("B");
	}
}

