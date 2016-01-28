/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.bo;

/**
 *
 * @author Qureshi
 */
public class CourseTimeSlotStruct {
    public int courseNo;
    public int altCourseNo;
    public String courseCode;
    public String altCourseCode;
    public int timeSlotNo;
    public int roomNo;    
    public int altRoomNo;    
    public String roomNoStr;
    public String altRoomNoStr;

    public CourseTimeSlotStruct() {
        this.courseNo = 0;
        this.courseCode = "";
        this.timeSlotNo = 0;
        this.roomNo = 0;
        this.roomNoStr = "";
        this.altCourseNo = 0;
        this.altCourseCode = "";        
        this.altRoomNo = 0;
        this.altRoomNoStr = "";
    }
    
    
    
}
