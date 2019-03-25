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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class WriteData {
		
	private FileWriter fileWriter;
	private int[] numOutputs = new int[2];
	private String output;
	
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
}
