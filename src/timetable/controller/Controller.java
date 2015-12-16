/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import timetable.bl.CourseBL;
import timetable.bl.TableStructBL;
import timetable.dal.Reader;
import timetable.bo.TableStruct;
import timetable.dal.PersistentWriter;
import timetable.dal.XLSXReader;

/**
 *
 * @author Qureshi
 */
public class Controller {
    TableStructBL tbl; 
    CourseBL cbl;
    
    public boolean loadFiles(){
        tbl = new TableStructBL();
        tbl.readFile();
        tbl.writeData();
        return true;
        
    }
    
    public void printTest() throws IOException, FileNotFoundException, ClassNotFoundException {
        cbl = new CourseBL();
        cbl.readTables();
        cbl.printTest();
    }

//    private Reader reader;
//    private TableStruct tbl.semesterTable;
//    public boolean collateData() {
//        tbl.semesterTable = new TableStruct(5, 8);  //5 days, 8 time-slots each
//        reader = new XLSXReader();
//        //Read into tbl.semesterTable
//        if (reader.read(tbl.semesterTable)) {
//            System.out.println("Table Read!!");
//        } else {
//            System.out.println("Read Fail!!");
//        }
//
//        return true;
//    }

    
    
//    public boolean saveData() throws IOException{
//        PersistentWriter writer = new PersistentWriter();
//        return writer.writeObject(tbl.getSemesterTable());
//    }
    
    
    
    
    

}
