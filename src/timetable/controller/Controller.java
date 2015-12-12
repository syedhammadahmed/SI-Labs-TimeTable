/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.controller;

import timetable.dal.Reader;
import timetable.dal.TableStruct;
import timetable.dal.XLSXReader;

/**
 *
 * @author Qureshi
 */
public class Controller {
    private Reader reader;
    private TableStruct semesterTable;
            
    public boolean collateData(){
        semesterTable = new TableStruct(5, 8);  //5 days, 8 time-slots each
        reader = new XLSXReader();
        reader.read(semesterTable);     //Reads into semesterTable
        
        return true;
    }
    
    public void printTest(){
        System.out.println(semesterTable.university);
        System.out.println(semesterTable.department);
        System.out.println(semesterTable.semester);
        System.out.println(semesterTable.section);
        System.out.println(semesterTable.classRoom);
        
        for(int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                System.out.print(semesterTable.table[i][j] + " ");
            }
        }
    }
    
}

