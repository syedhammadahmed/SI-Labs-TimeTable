/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.controller;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.TableStruct;
import timetable.dal.*;
//import timetable.dal.ScheduleReader;
 
/**
 *
 * @author Qureshi
 */
public class Controller {
    private TableStruct[] semesterTables; 
    private XSSFWorkbook workbook;
//    private Reader = new ScheduleReader();
    public boolean loadSchedule(){
//        semesterTables = new TableStruct[15];
         
        for(int i=0; i<15; i++){
            semesterTables[i] = new TableStruct(5, 8);
        }
        ScheduleReader reader = new ScheduleReader();
        return reader.read(semesterTables);
    }
    
    public void printTest(){
        for(int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                System.out.print(semesterTables[0].altTable[i][j]);
                System.out.println("\n");
            }
        }
    }
}
