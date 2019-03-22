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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFrame;

import tonkincode.blink.utilities.ReadData;

public class Popup extends JFrame{

	private int locX = 0; //default is set to 0 in order to prevent crashes.
	private int locY = 0;
	private Point location;
	private ReadData openLocation;
	private String[] stringLocation = new String[1];
	private String output;
	private int[] numOutputs = new int[2];
	
	/*
	 * Function: locationSet
	 * Description: reads the location popup should be at from .txt file and stores in a point. 
	 * Parameters: None
	 * Warnings: None
	 */
	private void locationSet() throws IOException {
		Path path = Paths.get("location.txt");
		
		Scanner scanner = new Scanner(path);
		int i = 0;
		//read the data
		while(scanner.hasNext()){
		    //process each character
		    output = scanner.next();
		    
		    
		    System.out.println(output);
		    i++;
		}
		scanner.close();
		
		String clean = output.replaceAll("\\D+","");
	    System.out.println(clean);
	    
	    if(clean.length() > 6)
	    {
		numOutputs[0] = Integer.parseInt(clean.substring(0, clean.length()/2 + 1));
		numOutputs[1] = Integer.parseInt(clean.substring(clean.length()/2 + 1));
	    }
	    else
	    {
		numOutputs[0] = Integer.parseInt(clean.substring(0, clean.length()/2));
		numOutputs[1] = Integer.parseInt(clean.substring(clean.length()/2));	
	    }
	    System.out.println(numOutputs[0] + " " + numOutputs[1]);
	}
	
	/*
	 * Function: Popup
	 * Description: used to set up the specs for the actual popup box
	 * Parameters: None
	 * Warnings: None
	 */
	public Popup() throws IOException {
		
		locationSet();
		
		setSize(400,200);
		setUndecorated(true);
		setOpacity(0.7F);
		setLocation(numOutputs[0], numOutputs[1]);
		setVisible(true);
	}

	
	
	
}
