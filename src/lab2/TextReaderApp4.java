package lab2;

import lab1.*;
import java.io.*;
import java.util.Scanner;
/**
 * TextReaderApp.java	1.00 Nov 25, 2003
 *
 */
public class TextReaderApp4{
	
   public static void main(String[] args) {
       
	int recordCount = 0;
        String line = null;
        int pickRecord;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number of record you want to see: ");
        pickRecord = keyboard.nextInt();
        
	File data1 = new File(File.separatorChar + "temp" + File.separatorChar 
                        + "contact.txt");

        BufferedReader in = null;
        try {
	   in = new BufferedReader(new FileReader(data1));
           
           line = in.readLine();
           recordCount += 1;   
           
	   
	   while(line != null) 
           {
               
               if (recordCount == pickRecord) {
               String[] pieces = line.split("\\|");
                  System.out.println("First Name: " + pieces[1] +
                                     "    Last Name: " + pieces[0] + "\n" +
                                     "Address: " + pieces[2] + "\n" +
                                     "City: " + pieces [3] +
                                     "   State: " + pieces[4] +
                                     "   Zip Code: " + pieces[5] + "\n" +
                                     "Email Address: " + pieces[6] +
                                     "   Phone Number: " + pieces[7] + "\n");
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
                if (pickRecord > recordCount) {
                   System.out.println("Value entered is greater than the number"
                                      + " of records on the file");
                                  }
            } catch(Exception e) {
                
            }
        }
    } // end main
} // end class
