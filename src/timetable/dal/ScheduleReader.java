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
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Qureshi
 */
public class ScheduleReader{
    public XSSFWorkbook read() throws IOException {
        File file = new File("CSTimeTableSpring2015.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(file));
        return workbook;
    }
}

        