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
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import tonkincode.blink.utilities.WriteData;

public class Options extends JFrame{

	private static int timeGap = 300000; //used in PopupTimer to set how long between popup appearance. Default 5 minutes.
	private String timeGapString[] = {"5 Minutes", "10 Minutes", "15 Minutes"}; //sorts the time user wants to take a gap in order of minutes: 5, 10, 15.
	private String getSelection;
	private int width = 300; 
	private int height = 200;
	
	private JComboBox<String> selectGap = new JComboBox<String>();
	private JButton locationButton = new JButton("Set Location");
	private FlowLayout layout = new FlowLayout();
	private Point windowLocation;
	private JPanel panel = new JPanel();
	
	private void optionsLayout(){
		panel.add(selectGap);
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*Function: selectGapTime
	*Description: organise the combobox for the time gap in between breaks
	*Parameters: None.
	*Warnings: timeGap[0] is currently set to 3 seconds for testing purposes.
	*/
	private void selectGapTime(){
		//add items to dropdown menu
		selectGap.addItem(timeGapString[0]);
		selectGap.addItem(timeGapString[1]);
		selectGap.addItem(timeGapString[2]);
		
		selectGap.setSize(this.getWidth()/2, this.getHeight()/10);
		
		//set string equal to selection
		String getSelection = (String) selectGap.getSelectedItem();
		
		//use the selection to get a time for the popupTimer class (in ms)
		if(getSelection == timeGapString[0]) {timeGap = 3000; System.out.println("fetched timegap 0");} // five minutes
		if(getSelection == timeGapString[1]) {timeGap = 600000; System.out.println("fetched timegap 1");} // ten minutes
		if(getSelection == timeGapString[2]) {timeGap = 900000; System.out.println("fetched timegap 2");} // fifteen minutes
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
	
	public static int getTimeGap()
	{
		return timeGap;
	}
	
}
