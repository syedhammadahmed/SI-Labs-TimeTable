/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.view;

import java.io.IOException;
import java.sql.SQLException;
import timetable.controller.Controller;

/**
 *
 * @author Qureshi
 */
public class Tester {
    public static void main(String[] args ) throws IOException, SQLException{
        Controller controller = new Controller();
        controller.clearDataBase();
        controller.loadDataBase();
        
        
//        controller.writeClassRooms();
//        controller.loadTeacherInfo();
//        controller.writeTeacherInfo();  
//        controller.loadStudentInfo();
//        controller.writeStudentInfo();
//        controller.loadCourseInfo();
//        controller.writeCourseInfo();        
//        controller.loadSchedule();
//        controller.writeSchedule();      
//        controller.loadEnrolment();
//        controller.writeEnrolment();      
        
        
        
        
//        controller.fetchTimeSlots();
//        controller.printTest();
        
    }
}
