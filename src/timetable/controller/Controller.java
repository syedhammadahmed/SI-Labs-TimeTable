/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.controller;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.TableStruct;
import timetable.dal.*;
import timetable.translate.TableStructTranslator;
//import timetable.dal.ScheduleReader;
 
/**
 *
 * @author Qureshi
 */
public class Controller {
    private TableStruct[] semesterTables; 
    private XSSFWorkbook workbook;
    private ScheduleReader reader;
    private TableStructTranslator translator;
//    private Reader = new ScheduleReader();
    
    public Controller(){
        semesterTables = new TableStruct[15];
        for(int i=0; i<15; i++){
            semesterTables[i] = new TableStruct(5, 8);
        }
        reader = new ScheduleReader();
        translator = new TableStructTranslator();
        workbook = new XSSFWorkbook();
    }
    
    public boolean loadSchedule() throws IOException{
        workbook = reader.read();
        translator.convertToTableStruct(workbook, semesterTables);
        
//        if(reader.read(workbook)){        
//            return translator.convertToTableStruct(workbook, semesterTables);
//        }        
        return true;
    }
    
    public void printTest(){
        for(int i=0; i<5; i++){
            for(int j=0; j<8; j++){
                System.out.print(semesterTables[0].table[i][j]);
                System.out.println("\n");
            }
        }
    }
}
