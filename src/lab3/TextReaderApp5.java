package lab3;

import lab1.*;
import java.io.*;
/**
 * TextReaderApp.java	1.00 Nov 25, 2003
 *
 */
public class TextReaderApp5{
	
   public static void main(String[] args) {
       
	int recordCount = 0;
        String line = null;
	File data = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "contact.txt");

        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data));
           
           line = in.readLine();
           recordCount += 1;   
           
	   
	   while(line != null) 
           {
               
               if (recordCount == 2) {
               String[] pieces = line.split("\\|");
                  System.out.println("City: " + pieces [3] + "\n");
                  break;
	   }
               line = in.readLine();  // strips out any carriage return chars
               recordCount += 1;
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
