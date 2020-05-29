
public class Airport {
	private Plane[] planes;
	private Runway[] runways;

	private int freeRunwaysAmount;
	private int stayingPlanes;

	private synchronized int getFreeRunwaysAmount() {
		return freeRunwaysAmount;
	}

	private synchronized void incrementFreeRunwaysAmount() {
		freeRunwaysAmount++;
	}

	private synchronized void decrementFreeRunwaysAmount() {
		freeRunwaysAmount--;
	}

	private synchronized Runway getFreeRunway() throws Exception {
		while(getFreeRunwaysAmount() < 1) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(Runway runway : runways)
			if(runway.getStatus() == RunwayStatus.isOpened) {
				decrementFreeRunwaysAmount();
				runway.setStatus(RunwayStatus.isClosed);
				return runway;
			}
		throw new Exception("Can't find free runway, but it's known there is");
	}

	private synchronized void returnFreeRunway(Runway runway) {
		incrementFreeRunwaysAmount();
		runway.setStatus(RunwayStatus.isOpened);
	}

	private synchronized Plane getPlane() {
		stayingPlanes--;
		return planes[stayingPlanes];
	}

	private synchronized void notifyWaitingRunways() {
		notify();
	}

	Airport() {
		planes = new Plane[10];
		runways = new Runway[5];
		
		for(int i = 0; i < runways.length; i++) {
			runways[i] = new Runway();
		}
		for(int i = 0; i < planes.length; i++) {
			planes[i] = new Plane();
		}

		freeRunwaysAmount = runways.length;
		stayingPlanes = planes.length;
	}


	void sendPlane() throws Exception {
		Runway runway = getFreeRunway();
		Plane plane = getPlane();

		plane.writeStatus();

		runway.setPlane(plane);

		System.out.println(runway.toString() + " took the " + plane.toString() + ".");

		runway.sendPlane();

		plane.writeStatus();

		returnFreeRunway(runway);

		runway.writeStatus();

		notifyWaitingRunways();
	}
}