/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.bl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import timetable.bo.TableStruct;
import timetable.dal.PersistentWriter;
import timetable.dal.Reader;
import timetable.dal.XLSXReader;

/**
 *
 * @author Qureshi
 */
public class TableStructBL {
    
    private Reader reader;
    private PersistentWriter pWriter;
    private TableStruct semesterTable;

    public TableStruct getSemesterTable() {
        return semesterTable;
    }    
    
    public boolean readFile() {
        semesterTable = new TableStruct(5, 8);  //5 days, 8 time-slots each
        reader = new XLSXReader();
        //Read into semesterTable
        if (reader.read(semesterTable)) {
            return true;
        } else {
            return false;
        }

        
    }
    
    public boolean writeData(){
        pWriter = new PersistentWriter();
        try {
            pWriter.writeTableObject(semesterTable);
        } catch (IOException ex) {
            Logger.getLogger(TableStructBL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return true;
    }
}
