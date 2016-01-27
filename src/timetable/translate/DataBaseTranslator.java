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

//    public List<String> convertToTimeSlotInsertStatements(TableStruct[] semesterTables) {
//        List<String> instructions = null;
//        String course;
//        for (int i = 0; i <= semesterTables.length; i++) {
//            for (int j = 0; j < 5; j++) {
//                for (int k = 0; k < 8; k++) {
//                    course = semesterTables[i].table[j][k].substring(0, 5);
//                    instructions.add("INSERT into ");
//                }
//            }
//        }
//
//        return instructions;
//    }

    public List<String> convertToCourseInsertStatements(List<CourseStruct> coursesInfo, List<String> teacherList) {
        List<String> instructions = new ArrayList<>();
        String course;
        

        for(int i=1; i<coursesInfo.size(); i++){
            String temp = "INSERT into COURSE (CNo, CCode, CName, TID_FK) VALUES ("
                    + (i) + ", '"
                    + coursesInfo.get(i).courseCode + "', '"
                    + coursesInfo.get(i).courseTitle + "', "
                    + (teacherList.indexOf(coursesInfo.get(i).teacher)+1) + ")";
            instructions.add(temp);
        }       
        
       
//        instructions.remove(0);
//        "INSERT INTO example1 (descr,number,date0)  VALUES( 'Show must go off',-1110.55446,#11/22/2003 10:42:58 PM#)");
//        for(int i=0; i<=coursesInfo.size(); i++){
//            
//            for(int j=0; j<5; j++){
//                for(int k=0; k<8; k++){
//                    course = semesterTables[i].table[j][k].substring(0, 5);
//                    instructions.add("INSERT into ");
//                }
//            }
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

//    public List<InsertStatement> convertToInsertStatements(TableStruct[] semesterTables){
//        List<InsertStatement> statements = new ArrayList<>();
//        for(TableStruct table : semesterTables){
//            for(int i=0; i<5; i++){
//                for(int j=0; j<8; j++){
//                    InsertStatement temp = new InsertStatement();
//                    temp.setStatement("INSERT into COURSE_TIMESLOT");
//                }
//            }
//        }
}
