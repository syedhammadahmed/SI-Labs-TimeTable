/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.CourseStruct;
import timetable.bo.CourseTimeSlotStruct;
import timetable.bo.TableStruct;
import timetable.dal.*;
import timetable.translate.CourseInfoTranslator;
import timetable.translate.DataBaseTranslator;
import timetable.translate.ScheduleTranslator;
import timetable.translate.StudentInfoTranslator;
import timetable.utility.Constants;

/**
 *
 * @author Qureshi
 */
public class Controller {

    private TableStruct[] semesterTables;
    private List<CourseStruct> coursesInfo;
    private HashMap<String, String> studentsInfo;
    private List<CourseTimeSlotStruct> scheduleInfo;
    private XSSFWorkbook workbook;
    private List<String> courseInsertStatements;
    private List<String> teacherInsertStatements;
    private List<String> studentInsertStatements;
    private List<String> scheduleInsertStatements;
    private List<String> classRoomInsertStatements;
    private List<String> enrolmentInsertStatements;
    private List<String> teacherList;
    private List<String> courseList;
    private List<String> studentList;

    public Controller() throws SQLException {
        semesterTables = new TableStruct[15];
        for (int i = 0; i < 15; i++) {
            semesterTables[i] = new TableStruct(5, 8);
        }
        coursesInfo = new ArrayList<>();
        studentsInfo = new HashMap<>();
        scheduleInfo = new ArrayList<>();
        workbook = new XSSFWorkbook();
        teacherList = new ArrayList<>();
        courseList = new ArrayList<>();
        studentList = new ArrayList<>();
    }

    public boolean clearDataBase() throws SQLException {
        DataBaseWriter dbWriter = new DataBaseWriter();
        return dbWriter.clearAllTables();
    }

    public boolean loadDataBase() throws SQLException, IOException {
        DataBaseTranslator dbTranslator = new DataBaseTranslator();
        CourseInfoReader ciReader = new CourseInfoReader();
        CourseInfoTranslator ciTranslator = new CourseInfoTranslator();
        ScheduleReader schReader = new ScheduleReader();
        DataBaseWriter dbWriter = new DataBaseWriter();

        ScheduleTranslator schTranslator = new ScheduleTranslator();
        StudentInfoReader stReader = new StudentInfoReader();
        StudentInfoTranslator stTranslator = new StudentInfoTranslator();
        classRoomInsertStatements = dbTranslator.classRoomInsertStatements(
                Constants.CLASSROOMS);
        dbWriter.runInsertStatements(classRoomInsertStatements);

        workbook = ciReader.read();
        ciTranslator.convertToCourseStruct(workbook, coursesInfo);
        teacherInsertStatements = dbTranslator.convertToTeacherInsertStatements(
                coursesInfo, teacherList);
        dbWriter.runInsertStatements(teacherInsertStatements);
        courseInsertStatements = dbTranslator.convertToCourseInsertStatements(
                coursesInfo, courseList, teacherList);
        dbWriter.runInsertStatements(courseInsertStatements);

        workbook = schReader.read();
        schTranslator.convertToTableStruct(workbook, semesterTables);
        scheduleInfo = schTranslator.parseSchedule(semesterTables, courseList);
        scheduleInsertStatements = dbTranslator.convertToScheduleInsertStatements(
                scheduleInfo);
        dbWriter.runInsertStatements(scheduleInsertStatements);

        workbook = stReader.read();
        stTranslator.convertToStudentMap(workbook, studentsInfo, coursesInfo);
        studentInsertStatements = dbTranslator.convertToStudentInsertStatements(studentsInfo, studentList);
        enrolmentInsertStatements = dbTranslator.convertToEnrolmentInsertStatements(coursesInfo, courseList);
        dbWriter.runInsertStatements(studentInsertStatements);
        dbWriter.runInsertStatements(enrolmentInsertStatements);

        return true;
    }

}
