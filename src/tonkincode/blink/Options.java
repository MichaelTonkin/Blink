/*Author: Michael Tonkin
 * Created: 06/02/19
 * Revised: 30/03/19
 * Description: Set up the options window and all its componenets
 * User advice: None.
 */

package tonkincode.blink;

import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.LookAndFeel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tonkincode.blink.utilities.WriteData;

public class Options extends JFrame{

	private static int timeGap = 300000; //used in PopupTimer to set how long between popup appearance. Default 5 minutes.
	private static String timeGapString[] = {"5 Minutes", "10 Minutes", "15 Minutes"}; //sorts the time user wants to take a gap in order of minutes: 5, 10, 15.
	private static String getSelection;
	private int width = 800; 
	private int height = 140;
	
	private static JComboBox<String> selectGap = new JComboBox<String>();
	private JButton locationButton = new JButton("Set Location");
	private FlowLayout layout = new FlowLayout();
	private Point windowLocation;
	private JPanel panel = new JPanel();
	
	private static SpinnerModel durationModel = new SpinnerNumberModel(8, 5, 240, 1);
	private static JSpinner durationSpinner = new JSpinner(durationModel); // allows the user to set the duration of the popup message in seconds.
	private static int duration = 8;
	
	private void optionsLayout()
	{
		
		JLabel descGap = new JLabel("Set time between breaks: ");
		JLabel descDur = new JLabel("Set how long to take a break for (seconds):");
		JLabel descPop = new JLabel("To set where you would like the notification\n to apprear, move this menu to the\n desired location and hit the 'select location' button.");
		
		panel.add(descGap);
		panel.add(selectGap);
		panel.add(descDur);
		panel.add(durationSpinner);
		panel.add(descPop);
		panel.add(locationButton);
		panel.setSize(width, height);
		panel.setLayout(layout);
	}
	
	/*Function: Options
	*Description: sets up the window
	*Parameters: None.
	*Warnings: None.
	*/
	public Options()
	{	
		setTitle("Blink - options");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //temporary. will minimize to tray later.

		//add time selection
		selectGapTime();
		
		//add location setting button
		selectLocation();
		
		optionsLayout();
		
		add(panel);
		pack();
		setSize(width, height); 
		setResizable(false);
		setVisible(true);
		setOptionsDecoration();
	}
	
	/*Function: setOptionsDecoration
	*Description: Used to detect which operating system the program is installed on, and change the application appearance accordingly.
	*Parameters: None.
	*Warnings: Currently only works for Windows 10. Currently not working
	*/
	private void setOptionsDecoration()
	{
		if(System.getProperty("os.name") == "Windows 10")
		{
			try {
				UIManager.setLookAndFeel((LookAndFeel) Class.forName(UIManager.getCrossPlatformLookAndFeelClassName()).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*Function: selectGapTime
	*Description: organise the combobox for the time gap in between breaks
	*Parameters: None.
	*Warnings: None.
	*/
	private void selectGapTime(){
		//add items to dropdown menu
		selectGap.addItem(timeGapString[0]);
		selectGap.addItem(timeGapString[1]);
		selectGap.addItem(timeGapString[2]);
		
		selectGap.setSize(this.getWidth()/2, this.getHeight()/10);
		
	}
	
	/*
	* Function: updateGapTime
	*Description: for use in the PopupTimer thread, updates which gap time the user has selected
	*Parameters: None.
	*Warnings: None.
	*/
	public static void updateGapTime()
	{
		//set string equal to selection
		getSelection = (String) selectGap.getSelectedItem();
		//use the selection to get a time for the popupTimer class (in ms)
		if(getSelection == timeGapString[0]) {timeGap = 300000; System.out.println("fetched timegap 0");} // five minutes
		if(getSelection == timeGapString[1]) {timeGap = 600000; System.out.println("fetched timegap 1");} // ten minutes
		if(getSelection == timeGapString[2]) {timeGap = 900000; System.out.println("fetched timegap 2");} // fifteen minutes
	}
	
	/*
	* Function: updateDuration
	*Description: for use in the PopupTimer thread, updates the duration the message will last for as selected in the durationSpinner
	*Parameters: None.
	*Warnings: None.
	*/
	public static void updateDuration()
	{
		duration = (int) durationSpinner.getValue();
	}
	
	/*Function: location
	*Description: drag the notification box to where you want it to start next time
	*Parameters: None.
	*Warnings: None.
	*/
	private void selectLocation() {

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
		});

	}

	private void locationGrabber() {
		windowLocation = this.getLocationOnScreen();
	}

	public static int getTimeGap() {
		return timeGap;
	}
	
	public static int getDuration() {
		return duration;
	}
}
