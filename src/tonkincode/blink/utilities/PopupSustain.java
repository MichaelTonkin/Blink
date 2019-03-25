/*
 * Description: thread that handles how long the popup should exist for
 * Warning: this is now legacy code and is no longer used in the program.
 */

package tonkincode.blink.utilities;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import tonkincode.blink.Popup;

public class PopupSustain extends TimerTask{
	
	Timer timer = new Timer(); //how long between breaks
	private PopupTimer pt;
	public Boolean closePopup = false;
	private int sustain = 2000; //how long to sustain for
	public PopupSustain(){
		timer.schedule(this, sustain);//currently set to dispose after 2 seconds
	}
	
	@Override
	public void run() {
		System.out.println("sustain active");
		PopupTimer.pop.setVisible(false);
		PopupTimer.pop.dispose();
		

	}

	public int getSustainTime(){
		return sustain;
	}
	
}
