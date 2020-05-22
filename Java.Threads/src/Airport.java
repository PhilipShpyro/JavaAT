
public class Airport {
	private Plane[] planes;
	private Runway[] runways;
	
	Airport() {
		planes = new Plane[10];
		runways = new Runway[5];
		
		for(int i = 0; i < runways.length; i++) {
			runways[i] = new Runway();
		}
		for(int i = 0; i < planes.length; i++) {
			planes[i] = new Plane();
		}
	}
	
	synchronized void sendPlane() {
		
	}
}

//class PlaneSender implements Runnable {
//	PlaneSender(Airport airport) {
//		
//	}
//	
//	public void run() {
//		
//	}
//}