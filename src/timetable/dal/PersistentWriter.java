/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.dal;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import timetable.bo.TableStruct;

/**
 * Writes the table structure into a serialized .ser file to be accessed
 * and processed into further object structures for querying.
 *
 *
 * @author Qureshi
 */
public class PersistentWriter {
    public boolean writeObject(TableStruct _semesterTable) throws FileNotFoundException, IOException{
        BufferedOutputStream buffer = null;
        ObjectOutputStream objectOut = null;
        try {
            FileOutputStream fout = null;
            switch(_semesterTable.semester){
                case "Fall 2015":
                    fout = new FileOutputStream("CS/CS1/CS1.ser");
                    break;
                case "CS2":
                    fout = new FileOutputStream("CS/CS2/CS2.ser");
                    break;
                case "CS3":
                    fout = new FileOutputStream("CS/CS3/CS3.ser");
                    break;
                case "CS4":
                    fout = new FileOutputStream("CS/CS4/CS4.ser");
                    break;
                case "CS5":
                    fout = new FileOutputStream("CS/CS5/CS5.ser");
                    break;
                case "CS6":
                    fout = new FileOutputStream("CS/CS6/CS6.ser");
                    break;
                case "CS7":
                    fout = new FileOutputStream("CS/CS7/CS7.ser");
                    break;
                case "CS8":            
                    fout = new FileOutputStream("CS/CS8/CS8.ser");
                    break;
            }   
            buffer = new BufferedOutputStream(fout);
            objectOut = new ObjectOutputStream(buffer);
            objectOut.writeObject(_semesterTable);
            objectOut.close();
            
        } catch (IOException ex) {
            Logger.getLogger(PersistentWriter.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return true;
    }
    
    
    
}
