
public class Plane {
	private static int counter = 1;
	
	private PlaneStatus status;
	private int number;
	
	Plane() {
		number = counter++;
		status = PlaneStatus.isGoingToRunway;
	}

	PlaneStatus getStatus() {
		return status;
	}

	private synchronized void setNextStatus() {
		switch (status) { // 1st solution for method (the cutest)
			case isGoingToRunway:
				status = PlaneStatus.isOnRunway;
				break;
			case isOnRunway:
				status = PlaneStatus.isInAir;
				break;
			default: break;
		}
		//status = status==PlaneStatus.isGoingToRunway ? PlaneStatus.isOnRunway : (status==PlaneStatus.isOnRunway ? PlaneStatus.isInAir : status); //2nd solution
		//status = status==PlaneStatus.isGoingToRunway ? PlaneStatus.isOnRunway : PlaneStatus.isInAir; //3rd solution
	}

	synchronized void takeOff() {
		setNextStatus();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setNextStatus();
	}

	void writeStatus() {
		System.out.println(this.toString() 
				+ (getStatus()==PlaneStatus.isGoingToRunway ? " is going to runway."
				: (getStatus()==PlaneStatus.isInAir ? " took off"
				: (getStatus()==PlaneStatus.isOnRunway ? " is on runway" : status))));
	}
	
	@Override
	public String toString() {
		return "plane #" + number;
	}
}

enum PlaneStatus {
	isGoingToRunway, isOnRunway, isInAir;
}