/*
 * Author: Michael Tonkin
 * Date Created: 08/03/19
 * Date Revised: 09/03/19
 * Description: This is the popup box that will appear when the user needs to take a break.
 * User Advice: None.
 */

package tonkincode.blink;

import java.awt.Point;
import java.io.IOException;

import javax.swing.JFrame;

import tonkincode.blink.utilities.ReadData;

public class Popup extends JFrame{

	private int locX = 0; //default is set to 0 in order to prevent crashes.
	private int locY = 0;
	private Point location;
	private ReadData openLocation;
	private String stringLocation;
	
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
		setLocation(locationSet());
		setVisible(true);
	}
	
	private Point locationSet() {
		try {
			openLocation = new ReadData("location.txt");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("error reading from location")
		}
		
		stringLocation = openLocation.getOutput();
		String[] stringLocation = openLocation.getOutput().split(',');

		location = new Point(Integer.parseInt(stringLocation[0]), Integer.parseInt(stringLocation[1]));
		return location;
	}
	
	
	
}
