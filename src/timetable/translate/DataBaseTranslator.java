/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.translate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import timetable.bo.CourseStruct;
import timetable.bo.CourseTimeSlotStruct;
import timetable.bo.TableStruct;

/**
 *
 * @author Qureshi
 */
public class DataBaseTranslator {


    public List<String> classRoomInsertStatements(String[] classrooms){
        List<String> instructions = new ArrayList<>();
        for(int i=1; i<classrooms.length; i++){
            String temp = "INSERT into ROOM (RoomNo, RoomName) VALUES ("
                    + i + ", '"
                    + classrooms[i] + "')";
            instructions.add(temp);
        }
        return instructions;
    }

    public List<String> convertToCourseInsertStatements(List<CourseStruct> coursesInfo, List<String> courseList, List<String> teacherList) {
        List<String> instructions = new ArrayList<>();
        String course;
        

        for(int i=1; i<coursesInfo.size(); i++){
            String temp = "INSERT into COURSE (CNo, CCode, CName, TID_FK) VALUES ("
                    + (i) + ", '"
                    + coursesInfo.get(i).courseCode + "', '"
                    + coursesInfo.get(i).courseTitle + "', "
                    + (teacherList.indexOf(coursesInfo.get(i).teacher)+1) + ")";
            instructions.add(temp);
            courseList.add(coursesInfo.get(i).courseCode);
        }    
        return instructions;
    }
    
    public List<String> convertToScheduleInsertStatements(List<CourseTimeSlotStruct> coursesInfo){ 
        List<String> instructions = new ArrayList<>();
        String tempCCode;
        int i=0;
        int index = 1;
        while (i < coursesInfo.size()) {
            if (!coursesInfo.get(i).courseCode.equals("")) {
                String temp = "INSERT into COURSE_TIMESLOT (CTSNo, CNo_FK, TSNo_FK, RoomNo_FK) VALUES ("
                        + index + ", "
                        + coursesInfo.get(i).courseNo + ", "
                        + coursesInfo.get(i).timeSlotNo + ", "
                        + coursesInfo.get(i).roomNo + ")";
                instructions.add(temp);
                index++;
                
                if (!coursesInfo.get(i).altCourseCode.equals("")) {
                    temp = "INSERT into COURSE_TIMESLOT (CTSNo, CNo_FK, TSNo_FK, RoomNo_FK) VALUES ("
                            + index + ", "
                            + coursesInfo.get(i).altCourseNo + ", "
                            + coursesInfo.get(i).timeSlotNo + ", "
                            + coursesInfo.get(i).altRoomNo + ")";
                    instructions.add(temp);
                    index++;
                    i++;
                }
                
            } 
            i++;
        }
//        for (int i = 0; i < coursesInfo.size(); i++) {
//            
//
//            
//            
//            
//        }        
        
        
        return instructions;
    }
    
    public List<String> convertToTeacherInsertStatements(List<CourseStruct> coursesInfo, List<String> teacherList){
        
        List<String> instructions = new ArrayList<>();
        HashSet<String> teacherSet = new HashSet<>();
        for(int i=1; i<coursesInfo.size(); i++){
            if(!"".equals(coursesInfo.get(i).teacher)){
                teacherSet.add(coursesInfo.get(i).teacher);
            }
        }
        teacherList.addAll(teacherSet);
        for(int i=0; i<teacherList.size(); i++){
            if(!"".equals(teacherList.get(i))){
                String temp = "INSERT into TEACHER (TID, TName) VALUES ("
                    + (i+1) + ", '"
                    + teacherList.get(i) + "')";
                instructions.add(temp);
            }
            
        }
        return instructions;
    }

}
