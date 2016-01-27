/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.translate;

import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.CourseStruct;

/**
 *
 * @author Qureshi
 */
public class CourseInfoTranslator {
    public boolean convertToCourseStruct(XSSFWorkbook workbook, List<CourseStruct> courseInfo){
        XSSFSheet courseInfoSheet = workbook.getSheetAt(0);
        
        XSSFCell cell;
        for(Row row : courseInfoSheet){
            
            
            
            CourseStruct tempCourseStruct = new CourseStruct();
            tempCourseStruct.courseCode = row.getCell(0).getStringCellValue();
            tempCourseStruct.courseTitle = row.getCell(1).getStringCellValue();
            tempCourseStruct.batch = row.getCell(2).getStringCellValue();
            if(row.getCell(3)!=null){
                tempCourseStruct.teacher = row.getCell(3).getStringCellValue();
            }else{
                tempCourseStruct.teacher = "";
            }
            
            courseInfo.add(tempCourseStruct);
        }
        
        
        return true;
    }
}
