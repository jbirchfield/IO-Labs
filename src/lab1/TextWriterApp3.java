package lab1;

import java.io.*;
import java.util.*;

/**
 * TextWriterApp3.java	1.00 Nov 25, 2003
 *
 * A class that writes data to a text file, with buffering.
 */
public class TextWriterApp3{
	
   public static void main(String[] args) throws IOException{
   	  boolean append = true;   // you can change this

	  // This references the file in the working directory
	  File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "contact.txt");
	  		
      // This is where we setup our streams (append = true means add to)
      // new FileWriter() creates the file if doesn't exit
	  PrintWriter out = new PrintWriter(
						new BufferedWriter(
						new FileWriter(data, append)));
	  
	  // print statements do actual work of writing data
	  // note that print statements work similar to Sytem.out.println,
	  // where data is converted to strings
          
          out.println();
	  out.print("Thompson|Tammy|6666 Ash Street|Pewaukee|WI|53000|TT@yahoo.com|414-555-4567|");
	  out.close();  // be sure you close your streams when done!!
          
          
	  System.out.println("Wrote file to: " + data.getAbsolutePath());
          
        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
	   String line = in.readLine();
	   while(line != null){
               String[] pieces = line.split("\\|");
                  System.out.println("First Name: " + pieces[1] +
                                     "    Last Name: " + pieces[0] + "\n" +
                                     "Address: " + pieces[2] + "\n" +
                                     "City: " + pieces [3] +
                                     "   State: " + pieces[4] +
                                     "   Zip Code: " + pieces[5] + "\n" +
                                     "Email Address: " + pieces[6] +
                                     "   Phone Number: " + pieces[7] + "\n");
		  
		  line = in.readLine();  // strips out any carriage return chars
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Houston, we have a problem! reading this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
    } // end main
   }

