/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import static timetable.utility.Constants.NUMBER_OF_SHEETS;

/**
 *
 * @author Qureshi
 */
public class XLSXReader implements Reader {
    public boolean read(TableStruct _semesterTable) {
        
        File file = new File("CS1A.xlsx");
    //            FileInputStream input = new FileInputStream(file);
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException ex) {
            Logger.getLogger(XLSXReader.class.getName()).log(Level.SEVERE, null, ex);
        }

        XSSFSheet semesterSheet = null;
//        semesterSheet = workbook.getSheetAt(0);
        XSSFRow row;
        XSSFCell cell;
        int firstCell = 0;
        int lastCell = 0;
        int firstRow = 0;
        int lastRow = 0;


        for(int iSheet=0; iSheet<workbook.getNumberOfSheets(); iSheet++){
            semesterSheet = workbook.getSheetAt(iSheet);
            if(semesterSheet!=null){

                _semesterTable.university = 
                        semesterSheet.getRow(0).getCell(1).getStringCellValue();
                _semesterTable.department = 
                        semesterSheet.getRow(1).getCell(1).getStringCellValue();
                _semesterTable.semester = 
                        semesterSheet.getRow(2).getCell(1).getStringCellValue();
                _semesterTable.section = 
                        semesterSheet.getRow(3).getCell(1).getStringCellValue();
                _semesterTable.classRoom = 
                        semesterSheet.getRow(3).getCell(1).getStringCellValue();

                firstRow = 6;
                lastRow = 10;

                for (int iRow = firstRow; iRow <= lastRow; iRow++){
                    row = semesterSheet.getRow(iRow);

                    if(row!=null){
                        firstCell = 1;
                        lastCell = 8;

                        for(int iCell = firstCell; iCell < lastCell; iCell++){
                            cell = row.getCell(iCell);
                            _semesterTable.table[iRow-6][iCell-1] = cell.getStringCellValue();



                        }
                    }
                }
            }

        }
    return true;

    }
}
    
    