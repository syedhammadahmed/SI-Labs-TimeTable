/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Qureshi
 */
public class StudentInfoReader {
    public XSSFWorkbook read() throws IOException {
        File file = new File("CSEnrolments.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));        
        return workbook;
    }
}
