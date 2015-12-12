/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
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


