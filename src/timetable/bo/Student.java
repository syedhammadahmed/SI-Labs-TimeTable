/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.bo;

import java.util.ArrayList;

/**
 *
 * @author Qureshi
 */
public class Student {
    private String studentID;
    private String FirstName;
    private String LastName;
    public ArrayList<CourseStruct> courseList;

    public Student(String studentID, String FirstName, String LastName) {
        this.studentID = studentID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        courseList = null;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    
    
}
