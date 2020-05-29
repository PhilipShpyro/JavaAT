public class Main {
	public static void main(String[] args) {
        Airport airport = new Airport();
        Runnable r = () -> {
            try {
                airport.sendPlane();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };


        Thread[] threads = new Thread[10];

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }


        try {
            for (Thread thread : threads)
                thread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}