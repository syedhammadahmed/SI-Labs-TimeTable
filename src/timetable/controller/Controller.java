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
import timetable.bo.CourseTimeSlotStruct;
import timetable.bo.TableStruct;
import timetable.dal.*;
import timetable.translate.CourseInfoTranslator;
import timetable.translate.DataBaseTranslator;
import timetable.translate.ScheduleTranslator;
import timetable.utility.Constants;
//import timetable.dal.ScheduleReader; 
/**
 *
 * @author Qureshi
 */
public class Controller {
    private TableStruct[] semesterTables; 
    private List<CourseStruct> coursesInfo;
    private List<CourseTimeSlotStruct> scheduleInfo;
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
    private List<String> teacherInsertStatements;
    private List<String> scheduleInsertStatements;
    private List<String> classRoomInsertStatements;
    private List<String> teacherList;
    private List<String> courseList;
    private int numberOfSheets;
    
    public Controller() throws SQLException{
        semesterTables = new TableStruct[15];
        
        for(int i=0; i<15; i++){
            semesterTables[i] = new TableStruct(5, 8);
        }
        coursesInfo = new ArrayList<>();
        scheduleInfo = new ArrayList<>();
        sReader = new ScheduleReader();
        cReader = new CourseInfoReader();
        sTranslator = new ScheduleTranslator();
        cTranslator = new CourseInfoTranslator();
        workbook = new XSSFWorkbook();
        dbReader = new DataBaseReader();
        dbWriter = new DataBaseWriter();
        dbTranslator = new DataBaseTranslator();
        teacherList = new ArrayList<>();
        courseList = new ArrayList<>();
    }
    
    public boolean clearDataBase() throws SQLException{
        return dbWriter.clearTables();
    }
    
    public boolean loadCourseInfo() throws IOException{
        
        workbook = cReader.read();
//        cTranslator.convertToCourseStruct(workbook, coursesInfo);
        courseInsertStatements = dbTranslator.convertToCourseInsertStatements(coursesInfo, courseList, teacherList);
        
        return true;
    }
    
    public boolean writeCourseInfo() throws SQLException{
        dbWriter.runInsertStatements(courseInsertStatements);
        
        return true;
    }
    
    public boolean loadTeacherInfo() throws IOException{
        
        workbook = cReader.read();
        cTranslator.convertToCourseStruct(workbook, coursesInfo);
        teacherInsertStatements = dbTranslator.convertToTeacherInsertStatements(coursesInfo, teacherList);
        return true;
    }
    
    public boolean writeTeacherInfo() throws SQLException{
        dbWriter.runInsertStatements(teacherInsertStatements);
        
        return true;
    }
    
    
    public boolean loadSchedule() throws IOException{
        workbook = sReader.read();
        sTranslator.convertToTableStruct(workbook, semesterTables);
        scheduleInfo = sTranslator.parseSchedule(semesterTables, courseList);
        scheduleInsertStatements = dbTranslator.convertToScheduleInsertStatements(scheduleInfo);
//        if(reader.read(workbook)){        
//            return translator.convertToTableStruct(workbook, semesterTables);
//        }        
        return true;
    }
    
    public boolean loadClassRooms(){
        
        classRoomInsertStatements = dbTranslator.classRoomInsertStatements(Constants.CLASSROOMS);
        return true;
    }
    
    public boolean writeClassRooms() throws SQLException{
        
        dbWriter.runInsertStatements(classRoomInsertStatements);
        return true;
    }
    
    public boolean writeSchedule() throws SQLException{
        dbWriter.runInsertStatements(scheduleInsertStatements);
        
        return true;
    }
    
    
//    
//    public boolean fetchTimeSlots() throws SQLException{
//        return dbReader.queryTest();
//    }
//    
//    
//    public void printTest(){
//        for(int i=0; i<5; i++){
//            for(int j=0; j<8; j++){
//                System.out.print(semesterTables[0].table[i][j]);
//                System.out.println("\n");
//            }
//        }
//    }
    
    
    
}
