package tonkincode.blink;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Options extends JFrame{

	private int locationX = 0;
	private int locationY = 0;
	private int timeGap[] = {300, 600, 900, 1200}; //sorts the time user wants to take a gap in order of minutes: 5, 10, 15, 20.
	private JComboBox<Integer> selectGap = new JComboBox<Integer>();
	private FlowLayout layout = new FlowLayout();
	
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
		
		selectGapTime();
		add(selectGap);
		
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
	
	/*Function: dragLocation
	*Description: drag the notification box to where you want it to start next time
	*Parameters: None.
	*Warnings: None.
	*/
	private void dragLocation(){
		
	}
}
