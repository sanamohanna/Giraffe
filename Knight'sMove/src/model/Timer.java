package model;

public class Timer {
	
	private double startTime;
	private double pauseTime;

	public Timer() {
		setPauseTime(-1);
		setStartTime(-1);
	}

	public void startTimer() {
		setStartTime(System.currentTimeMillis());
		setPauseTime(-1);
	}

	public void startTimer(float seconds) {
		setStartTime((double) (System.currentTimeMillis() - seconds*(1000)));
		setPauseTime(-1);
	}
	
	public double getStartTime() {
		return startTime;
	}
	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}
	public double getPauseTime() {
		return pauseTime;
	}
	private void setPauseTime(double pauseTime) {
		this.pauseTime = pauseTime;
	}

	public void resetTimer() {
		setPauseTime(-1);
		startTimer();
	}

	public void stopTimer() {
		setStartTime(-1);
		setPauseTime(-1);
	}

	public void pauseTimer() {
		setPauseTime(System.currentTimeMillis());
	}
	
	public void unpauseTimer() {
		if(getPauseTime() == -1) return;
		double temp = (System.currentTimeMillis() - getPauseTime());
		setPauseTime(-1);
	}

	public double getSeconds() {
		if(startTime == -1) return -1;
		if(getPauseTime() != -1) {
			double temp =(System.currentTimeMillis() - getPauseTime());
			return ( System.currentTimeMillis() -  temp) / 1000F;
		}else {
			return ( System.currentTimeMillis()) / 1000F;
		}
	}
		

}
