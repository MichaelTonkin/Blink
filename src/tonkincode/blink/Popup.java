/*
 * Author: Michael Tonkin
 * Description: This is the popup box that will appear when the user needs to take a break.
 */

package tonkincode.blink;

import javax.swing.JFrame;

public class Popup extends JFrame{

	private int locX;
	private int locY;

	/*
	 * Function: Popup
	 * Description: used to set up the specs for the actual popup box
	 * Parameters: None
	 * Warnings: None
	 */
	public Popup() {
		
		setSize(400,200);
		setUndecorated(true);
		setOpacity(0.7F);
		setVisible(true);
	}

	/*
	 * Function: setLocXY
	 * Description: Taking input from the button in the options class (set location), this will then set the 
	 * default location for the popup whenever it appears
	 * Parameters: int x, int y - the x and y coordinates
	 * Warnings: This will need to be improved to read the location from a save file in the release edition
	 * as currently you will have to set up a the location each time you run the app. 
	 */
	public void setLocXY(int x, int y) {
		locX = x;
		locY = y;
	}
	
}
