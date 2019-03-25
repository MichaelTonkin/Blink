package tonkincode.blink.utilities;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

import tonkincode.blink.Popup;

public class PopupTimer extends TimerTask{
	
	public static Popup pop;
	Timer timer = new Timer(); //how long between breaks
	private PopupSustain ps;
	private int tValue = 300000; //the amount of time delay
	private int sustainFor = 8 + 1; // the amount of time the screen should be displayed for (in seconds)
	private Boolean task = true; // true = spawn new popup. false = disable popup.
	int time = 0; int sustain = 0;
	
	public PopupTimer(){
		timer.scheduleAtFixedRate(this, 0, 1000);//currently set to spawn in every 8 sec
	}
	
	@Override
	public void run() {	
		
		time += 1000; //increment the time
		
		if(time == tValue) //once the time reachest the value we want it to
		{
		pop = new Popup(); //show the popup
		time = 0; //reset the timer
		sustain ++; //start the sustain timer
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
		}

	public int setTValue(int minutes){
		return tValue = minutes * 60 * 1000;
	}

	public int getTValue(){
		return tValue;
	}
}