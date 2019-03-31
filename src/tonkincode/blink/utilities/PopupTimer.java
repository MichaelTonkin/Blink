package tonkincode.blink.utilities;

import java.util.TimerTask;
import java.util.Timer;

import tonkincode.blink.Options;
import tonkincode.blink.Popup;

public class PopupTimer extends TimerTask{
	
	public static Popup pop;
	private Timer timer = new Timer(); //how long between breaks
	private int tValue = Options.getTimeGap(); //the amount of time delay
	private int sustainFor = 8 + 1; // the amount of time the screen should be displayed for (in seconds)
	private int time = 0; 
	private int sustain = 0;
	private static int exercise = 0; //used to decide which exercise the user should do
	
	public PopupTimer(){
		timer.scheduleAtFixedRate(this, 0, 1000);//currently set to spawn in every 8 sec
	}
	
	@Override
	public void run() {	
		
		time += 1000; //increment the time
		Options.updateGapTime();
		Options.updateDuration();
		
		tValue = Options.getTimeGap(); //update tValue
		sustainFor = Options.getDuration();
		
		if(time == tValue) //once the time reaches the value we want it to
		{
		pop = new Popup(); //show the popup
		time = 0; //reset the timer
		sustain ++; //start the sustain timer
		
		//here we set the eye exercise to be used in PopupUI class.
		exercise ++;
		if (exercise > 2)
			exercise = 0;
		}
		
		if(sustain > 0)
		{
			sustain++;
		}
		
		if(sustain == sustainFor)
		{
			pop.setVisible(false);
			pop.dispose();
			sustain = 0;
		}
		System.out.printf("thread running for: %d\n", time);
		}

	public int setTValue(int minutes){
		return tValue = minutes * 60 * 1000;
	}

	public int getTValue(){
		return tValue;
	}
	
	public static int getExercise(){
		return exercise;
	}
}