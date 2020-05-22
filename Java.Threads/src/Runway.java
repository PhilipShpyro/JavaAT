
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
		System.out.println("Runway #" + number + (status == RunwayStatus.isOpened ?
				" is opened." : (status == RunwayStatus.hasPlane ? " has plane." :
					status)));
	}

	synchronized void setPlane(Plane plane) {
		if(status == RunwayStatus.hasPlane) {
			System.out.println("already has " + this.plane);
			return;
		}
		this.plane = plane;
		status = RunwayStatus.hasPlane;
	}
}

enum RunwayStatus {
	isOpened, hasPlane;
}