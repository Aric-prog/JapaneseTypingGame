
public class KPM {
	private double timeElapsed;
	private int keyTyped;
	private double startTime;
	
	public KPM() {
		this.startTime = 0;
		this.timeElapsed = 0L;
		this.keyTyped = 0;
	}

	public double getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(double timeElapsed) {
		// Converts time from millisecond to second
		this.timeElapsed = ((double) (timeElapsed - startTime)) / 1000;
	}

	public double getKeyTyped() {
		return keyTyped;
	}

	// Adds typed key into the total typed keys
	public void setKeyTyped(int keyTyped) {
		this.keyTyped += (keyTyped);
	}
	public double getKPM() {
		return ((((double)keyTyped)) / timeElapsed) * 60;
	}
	
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	
	
}
