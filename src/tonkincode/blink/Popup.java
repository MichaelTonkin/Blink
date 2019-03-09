/*
 * Author: Michael Tonkin
 * Date Created: 08/03/19
 * Date Revised: 09/03/19
 * Description: This is the popup box that will appear when the user needs to take a break.
 */

package tonkincode.blink;

import java.awt.Point;

import javax.swing.JFrame;

public class Popup extends JFrame{

	private int locX = 0; //default is set to 0 in order to prevent crashes.
	private int locY = 0;

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
		setLocation(locX, locY);
		setVisible(true);
	}
	
}
