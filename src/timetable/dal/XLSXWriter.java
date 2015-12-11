 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;
import java.io.*;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author Qureshi
 */
public class XLSXWriter {
    public static void main(String args[]) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        FileOutputStream out;
        out = new FileOutputStream(new File("newworkbook.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("newworkbook.xlsx written succesfully.");
        
        
    }
    
}


