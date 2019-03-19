/*Author: Michael Tonkin
 * Created: 06/02/19
 * Revised: 06/02/19
 * Program Description:
 * Description: This class is simply used as a launch point for the program.
 * User advice: None.
 */

package tonkincode.blink;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		Options options = new Options();
		
		try {
			Popup pop = new Popup();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
