/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.CourseStruct;
import timetable.bo.TableStruct;
import timetable.dal.*;
import timetable.translate.CourseInfoTranslator;
import timetable.translate.DataBaseTranslator;
import timetable.translate.ScheduleTranslator;
//import timetable.dal.ScheduleReader; 
/**
 *
 * @author Qureshi
 */
public class Controller {
    private TableStruct[] semesterTables; 
    private List<CourseStruct> coursesInfo;
    private XSSFWorkbook workbook;
    private ScheduleReader sReader;
    private CourseInfoReader cReader;
    private ScheduleTranslator sTranslator;
    private CourseInfoTranslator cTranslator;
    private DataBaseReader dbReader;
    private DataBaseWriter dbWriter;
    private DataBaseTranslator dbTranslator;
    private List<String> courseInsertStatements;
//    private Reader = new ScheduleReader();
    
    public Controller() throws SQLException{
        semesterTables = new TableStruct[15];
        
        for(int i=0; i<15; i++){
            semesterTables[i] = new TableStruct(5, 8);
        }
        coursesInfo = new ArrayList<>();
        sReader = new ScheduleReader();
        cReader = new CourseInfoReader();
        sTranslator = new ScheduleTranslator();
        cTranslator = new CourseInfoTranslator();
        workbook = new XSSFWorkbook();
        dbReader = new DataBaseReader();
        dbWriter = new DataBaseWriter();
        dbTranslator = new DataBaseTranslator();
    }
    
    public boolean clearDataBase() throws SQLException{
        return dbWriter.clearTables();
    }
    
    public boolean loadCourseInfo() throws IOException{
        
        workbook = cReader.read();
        cTranslator.convertToCourseStruct(workbook, coursesInfo);
        courseInsertStatements = dbTranslator.convertToInsertStatements(coursesInfo);
        return true;
    }
    
    public boolean writeCourseInfo() throws SQLException{
        dbWriter.runInsertStatements(courseInsertStatements);
        
        return true;
    }
    
    public boolean loadSchedule() throws IOException{
        workbook = sReader.read();
        sTranslator.convertToTableStruct(workbook, semesterTables);
        
//        if(reader.read(workbook)){        
//            return translator.convertToTableStruct(workbook, semesterTables);
//        }        
        return true;
    }
    
    
    
    public boolean fetchTimeSlots() throws SQLException{
        return dbReader.queryTest();
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
