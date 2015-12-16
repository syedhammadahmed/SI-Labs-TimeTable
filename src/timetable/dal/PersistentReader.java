/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.dal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import timetable.bo.TableStruct;

/**
 *
 * @author Qureshi
 */
public class PersistentReader {
    public TableStruct readTableObject(int semester) 
            throws FileNotFoundException, IOException, ClassNotFoundException{
        TableStruct semesterTable;
        BufferedInputStream buffer;
        ObjectInputStream objectIn;
        FileInputStream fin = null;
        switch(semester){
            case 1:
                fin = new FileInputStream("CS/CS1/CS1.ser");
                break;
            case 2:
                fin = new FileInputStream("CS/CS2/CS2.ser");
                break;
            case 3:
                fin = new FileInputStream("CS/CS3/CS3.ser");
                break;
            case 4:
                fin = new FileInputStream("CS/CS4/CS4.ser");
                break;
            case 5:
                fin = new FileInputStream("CS/CS5/CS5.ser");
                break;
            case 6:
                fin = new FileInputStream("CS/CS6/CS6.ser");
                break;
            case 7:
                fin = new FileInputStream("CS/CS7/CS7.ser");
                break;
            case 8:
                fin = new FileInputStream("CS/CS8/CS8.ser");
                break;
        }
        buffer = new BufferedInputStream(fin);
        objectIn = new ObjectInputStream (buffer);
        semesterTable = (TableStruct)objectIn.readObject();
        return semesterTable;
        
    }
}
