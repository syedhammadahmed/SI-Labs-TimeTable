/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.translate;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.CourseStruct;
import timetable.bo.StudentStruct;

/**
 *
 * @author Qureshi
 */
public class StudentInfoTranslator {

    public boolean convertToStudentMap(XSSFWorkbook workbook, 
            HashMap<String, String> studentMap, 
            List<CourseStruct> coursesInfo) {
        XSSFSheet[] enrolmentSheets = new XSSFSheet[workbook.getNumberOfSheets()];
//        XSSFRow[] row = new XSSFRow[workbook.getNumberOfSheets()];
//        XSSFCell[] cell = new XSSFCell[workbook.getNumberOfSheets()];

        for (int iSheet = 0; iSheet < workbook.getNumberOfSheets(); iSheet++) {
            enrolmentSheets[iSheet] = workbook.getSheetAt(iSheet);
            if (enrolmentSheets[iSheet] != null) {
                for (Row row : enrolmentSheets[iSheet]) {
                    StudentStruct tempStudent = new StudentStruct();
                    tempStudent.studentID = row.getCell(0).getStringCellValue();
                    tempStudent.studentName = row.getCell(1).getStringCellValue();
                    if ((!tempStudent.studentID.equals("Registration Number"))
                            && (!tempStudent.studentID.equals("Name"))) {
                        coursesInfo.get(iSheet).enrolledStudents.add(tempStudent);
                        studentMap.put(tempStudent.studentID, tempStudent.studentName);
                    }

//                    studentMap.remove("Registration Number", "Name");
                }
            }

        }
        return true;
    }
}
