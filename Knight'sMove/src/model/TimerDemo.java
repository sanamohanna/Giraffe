package model;
import java.util.Timer;  
import java.util.TimerTask; 
public class TimerDemo {
	
	private double startTime = 0;
	private double pauseTime;
	Timer timer = new Timer();  
	public TimerDemo() {
		setPauseTime(-1);
		setStartTime(-1);
	}
	  
	TimerDemo(Integer seconds)   
	{  
	//schedule the task  
		timer.schedule(new RemindTask(), seconds*1000);   
	}
	class RemindTask extends TimerTask   
	{  
	public void run()   
	{  
	System.out.println("You have a notification!");  
	//terminate the timer thread  
	timer.cancel();   
	}  
	}  
	//driver code  
	public static void main(String args[])   
	{  
	//function calling      
	new TimerDemo(60);  
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
