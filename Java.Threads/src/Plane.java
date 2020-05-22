
public class Plane {
	private static int counter = 1;
	
	private PlaneStatus status;
	private int number;
	
	Plane() {
		number = counter++;
		status = PlaneStatus.isGoingToRunway;
	}

	synchronized PlaneStatus getStatus() {
		return status;
	}

	synchronized void setStatus(PlaneStatus status) {
		this.status = status;
	}
	
	void writeStatus() {
		System.out.println(this.toString() 
				+ (getStatus()==PlaneStatus.isGoingToRunway ? " is going to runway."
				: (getStatus()==PlaneStatus.inAir ? " took off." : status)));
	}
	
	@Override
	public String toString() {
		return "plane #" + number;
	}
}

enum PlaneStatus {
	isGoingToRunway, inAir;
}