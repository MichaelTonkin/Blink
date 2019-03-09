/*
 * Author: Michael Tonkin
 * Date Created: 09/03/19
 * Date Revised: 09/03/19
 * Description: The utility we will use to write data to a text file for this program
 * 
 */

package tonkincode.blink.utilities;

import java.io.FileWriter;
import java.io.IOException;

public class WriteData {
		
	private FileWriter fileWriter;
	
	/*
	 * Function: WriteData
	 * Description: Used to write data to file
	 * Parameters: String content - the content or data to be written to file
	 *			   String name - the name of the file
	 * Warnings: None
	 */
	public WriteData(String name, String content) throws IOException {
		
		fileWriter = new FileWriter(name + ".txt");
		fileWriter.write(content);
		fileWriter.close();
		
	}
	
}
