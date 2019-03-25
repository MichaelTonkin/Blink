/*
 * Author: Michael Tonkin
 * Date Created: 08/03/19
 * Date Revised: 09/03/19
 * Description: This is the popup box that will appear when the user needs to take a break.
 * User Advice: Do not try to get variables from this class from another class. Move them to PopMeasurements instead.
 */

package tonkincode.blink;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tonkincode.blink.utilities.PopupSustain;
import tonkincode.blink.utilities.ReadData;

public class Popup extends JFrame{

	private Point location;
	private ReadData openLocation;
	private String[] stringLocation = new String[1];
	private JPanel ui = new JPanel();

			

	
	/*
	 * Function: Popup
	 * Description: used to set up the specs for the actual popup box
	 * Parameters: None
	 * Warnings: None
	 */
	public Popup()
	{	
		setUndecorated(true);
		setOpacity(0.8F);
		setLocation(ReadData.numOutputs[0], ReadData.numOutputs[1]);
		popUI();
		pack();
		setSize(PopMeasurements.pWidth, PopMeasurements.pHeight);
		setVisible(true);
		setAlwaysOnTop(true);
	}
	/*
	 * Function: PopUI
	 * Description: change the appearance of the popup box
	 * Parameters: None
	 * Warnings: None
	 */
	private void popUI()
	{
		Canvas uiCanvas = new PopUI();
		uiCanvas.setSize(PopMeasurements.pWidth, PopMeasurements.pHeight);
		ui.setBackground(Color.black);
		ui.add(uiCanvas);
		this.add(ui);
	}

	
	
}
