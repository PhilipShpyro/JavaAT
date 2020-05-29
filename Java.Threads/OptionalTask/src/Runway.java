
public class Runway {
	private static int counter = 1;
	
	private RunwayStatus status;
	private Plane plane;
	private int number;
	
	Runway() {
		number = counter++;
		status = RunwayStatus.isOpened;
		plane = null;
	}
	
	RunwayStatus getStatus() {
		return status;
	}
	
	synchronized void setStatus(RunwayStatus status) {
		this.status = status;
	}
	
	void writeStatus() {
		System.out.println("runway #" + number + (status == RunwayStatus.isOpened ?
				" is opened" : (status == RunwayStatus.isClosed ? " has plane" :
					status)));
	}

	synchronized void setPlane(Plane plane) {
		this.plane = plane;
		status = RunwayStatus.isClosed;
	}

	synchronized void sendPlane() {
		plane.takeOff();
	}

	@Override
	public String toString() {
		return "runway #" + number;
	}
}

enum RunwayStatus {
	isOpened, isClosed;
}