/*Author: Michael Tonkin
 * Created: 06/02/19
 * Revised: 06/02/19
 * Program Description:
 * Description: This class is simply used as a launch point for the program.
 * User advice: None.
 */

package tonkincode.blink;

import java.io.IOException;

import tonkincode.blink.utilities.PopupSustain;
import tonkincode.blink.utilities.PopupTimer;
import tonkincode.blink.utilities.ReadData;

public class Main {

	public static void main(String[] args) {
		
		Options options = new Options();
		PopupTimer popTimer = new PopupTimer();
		try {
			ReadData read = new ReadData();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//PopupSustain popSustain = new PopupSustain();
	}

}
