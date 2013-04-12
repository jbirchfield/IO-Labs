package lab1;

import java.io.*;
/**
 * TextReaderApp1.java	1.00 Nov 25, 2003
 *
 * A class that reads data from a text file, with buffering. Uses
 * the file "test.txt" which is in this project. Try reading your
 * own text file stored in a different directory.
 */
public class TextReaderApp1{
	
   public static void main(String[] args) {
	/* This uses System properties to extract the correct
	*/

	File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "contact.txt");

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
} // end class
