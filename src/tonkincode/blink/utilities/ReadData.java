/*Author: Michael Tonkin
 * Created: 09/02/19
 * Revised: 09/02/19
 * Description: general purpose class for reading data from a file
 * User advice: None.
 */


package tonkincode.blink.utilities;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class ReadData {
	
	public static int[] numOutputs = new int[2];
	private String output;

	public ReadData() throws IOException{
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
	
	/*
	 * Function: locationSet
	 * Description: reads the location popup should be at from .txt file and stores in a point. 
	 * Parameters: None
	 * Warnings: None
	 */

