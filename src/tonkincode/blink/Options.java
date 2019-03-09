/*Author: Michael Tonkin
 * Created: 06/02/19
 * Revised: 09/02/19
 * Description: Set up the options window and all its componenets
 * User advice: None.
 */

package tonkincode.blink;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import tonkincode.blink.utilities.WriteData;

public class Options extends JFrame{

	private int locationX = 0;
	private int locationY = 0;
	private int timeGap[] = {300, 600, 900, 1200}; //sorts the time user wants to take a gap in order of minutes: 5, 10, 15, 20.
	
	private JComboBox<Integer> selectGap = new JComboBox<Integer>();
	private JButton locationButton = new JButton("Set Location");
	private FlowLayout layout = new FlowLayout();
	private Point windowLocation;
	
	/*Function: Options
	*Description: sets up the window
	*Parameters: None.
	*Warnings: None.
	*/
	public Options()
	{	
		setSize(400, 800); //TODO fix sizing error
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //temporary. will minimize to tray later.
		setLayout(layout);
		
		//add time selection
		selectGapTime();
		add(selectGap);
		
		//add location setting button
		selectLocation();
		add(locationButton);
		
		pack();
		setVisible(true);
	}
	
	/*Function: selectGapTime
	*Description: organise the combobox for the time gap
	*Parameters: None.
	*Warnings: None.
	*/
	private void selectGapTime(){
		selectGap.addItem(timeGap[0]);
		selectGap.addItem(timeGap[1]);
		selectGap.addItem(timeGap[2]);
		selectGap.addItem(timeGap[3]);
		selectGap.setSize(this.getWidth()/2, this.getHeight()/10);
	}
	
	/*Function: location
	*Description: drag the notification box to where you want it to start next time
	*Parameters: None.
	*Warnings: None.
	*/
	private void selectLocation(){
		
		
	locationButton.addActionListener(new ActionListener() {
			
		@Override
		public void actionPerformed(ActionEvent e) {
			locationGrabber();
			try {
				WriteData writeLoca = new WriteData("location", windowLocation.toString());
			} catch (IOException e1) {
				e1.printStackTrace();
				System.out.println("error writing to file in selectLocation");
			}
	}
	}
	);

	}
	
	private void locationGrabber() {
		windowLocation = this.getLocationOnScreen();
	}
	
}
