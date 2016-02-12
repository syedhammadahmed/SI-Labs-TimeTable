/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.bo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Qureshi
 */
public class CourseStruct {
    public String courseCode;
    public String courseTitle;
    public String batch;
    public String teacher;
    public List<StudentStruct> enrolledStudents;

    public CourseStruct() {
        this.courseCode = "";
        this.courseTitle = "";
        this.batch = "";
        this.teacher = "";
        this.enrolledStudents = new ArrayList<>();
    }
    
    
    
}
