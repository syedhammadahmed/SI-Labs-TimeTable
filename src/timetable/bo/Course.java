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
public class Course {
    private String courseTitle;
    private char section;
    private Teacher teacher;
    private int numEnrolled;
    public ArrayList<TimeSlot> classTimes;

    

    public Course(String courseTitle, char section, Teacher teacher) {
        this.courseTitle = courseTitle;
        this.section = section;
        this.teacher = teacher;
        
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public char getSection() {
        return section;
    }

    public void setSection(char section) {
        this.section = section;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    
    public int getNumEnrolled() {
        return numEnrolled;
    }

    public void setNumEnrolled(int numEnrolled) {
        this.numEnrolled = numEnrolled;
    }


    
    
}
