/*Author: Michael Tonkin
 * Created: 09/02/19
 * Revised: 09/02/19
 * Description: general purpose class for reading data from a file
 * User advice: None.
 */


package tonkincode.blink.utilities;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ReadData {
	
	private String output;
	private int[] numOutputs;
	/*
	 * Function: ReadData
	 * Description: uses a scanner to read data from file
	 * Parameters: String dataFile - the path for the file to be read from
	 * Warnings: None
	 */
	public ReadData(String dataFile) throws IOException {
	Path path = Paths.get(dataFile);
	
	Scanner scanner = new Scanner(path);
	int i = 0;
	//read the data
	while(scanner.hasNext()){
	    //process each character
	    String output = scanner.next();
	    numOutput[i] = scanner.nextInt();
	    System.out.println(output);
	    i++;
	}
	scanner.close();
}
	/*
	 * Function: getOutput
	 * Description: returns output from read data operation
	 * Parameters: None
	 * Warnings: None
	 */
	public String getOutput() {
		return output;
	}
}