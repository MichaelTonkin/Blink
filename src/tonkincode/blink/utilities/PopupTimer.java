package tonkincode.blink.utilities;

import java.io.IOException;
import java.util.Date;
import java.util.TimerTask;
import java.util.Timer;

import tonkincode.blink.Popup;

public class PopupTimer extends TimerTask{

	Timer timer = new Timer();
	public PopupTimer(){
		timer.scheduleAtFixedRate(this, 500, 1000);
	}
	
	@Override
	public void run() {
		
		try {
			Popup pop = new Popup();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}


}	        
