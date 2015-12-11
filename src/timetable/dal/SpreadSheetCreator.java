/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Qureshi
 */
public class SpreadSheetCreator {
    public static void main(String[] args) throws Exception{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(" Member Info ");
        XSSFRow row;
        Map < String, Object[] > meminfo = new TreeMap <  >();
        meminfo.put( "1", new Object[] {
            "MEM ID", "MEM NAME", "EMAIL" });
        meminfo.put( "2", new Object[] {
            "CS01", "Asad Shafi", "asadshafi09@gmail.com" });
        meminfo.put( "3", new Object[] {
            "CS02", "Bilal", "bilal.champ18@gmail.com" });
        meminfo.put( "4", new Object[] {
            "CS03", "Hammad Shahid", "hammads48@gmail.com" });
        meminfo.put( "5", new Object[] {
            "CS04", "Mohsin Mehboob", "mohsinmehboob13@gmail.com" });
        meminfo.put( "6", new Object[] {
            "CS05", "Mustafa Naviwala", "naviwala1995@gmail.com" });
        meminfo.put( "7", new Object[] {
            "CS06", "Saad Abid", "saadabid15@gmail.com" });
        meminfo.put( "8", new Object[] {
            "CS07", "Sami Qureshi", "samiqureshi2004@gmail.com" });
        meminfo.put( "9", new Object[] {
            "CS08", "Shaharyar", "shaharyar.95@gmail.com" });
        meminfo.put( "10", new Object[] {
            "CS09", "Shiraz Malkani", "shmalkani09@gmail.com" });
        meminfo.put( "11", new Object[] {
            "CS10", "Umer Saleem", "umersaleem6540@gmail.com" });
        
        //Iterate over data and write to sheet
        Set < String > keyid = meminfo.keySet();
        int rowid = 0;
        for (String key : keyid){
            row = spreadsheet.createRow(rowid++);
            Object [] objectArr = meminfo.get(key);
            int cellid = 0;
            for (Object obj : objectArr){
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
            
        }
        
        //Write the workbook in file system
        FileOutputStream out = new FileOutputStream(
                new File("Writesheet.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("Writesheet.xlsx written successfully" );
    }
    
}
