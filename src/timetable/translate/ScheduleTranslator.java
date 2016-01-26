/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.translate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import timetable.bo.CellStruct;
import timetable.bo.TableStruct;

/**
 *
 * @author Qureshi
 */
public class ScheduleTranslator {

    public boolean convertToTableStruct(XSSFWorkbook workbook, TableStruct[] semesterTables) {
        XSSFSheet[] semesterSheets = new XSSFSheet[workbook.getNumberOfSheets()];
        XSSFRow[] row = new XSSFRow[workbook.getNumberOfSheets()];
        XSSFCell[] cell = new XSSFCell[workbook.getNumberOfSheets()];
        int firstCell = 1;
        int lastCell = 8;
        int firstRow = 6;
        int lastRow = 10;

        for (int iSheet = 0; iSheet < workbook.getNumberOfSheets(); iSheet++) {
            semesterSheets[iSheet] = workbook.getSheetAt(iSheet);
            if (semesterSheets[iSheet] != null) {

                //Setting the headers
                semesterTables[iSheet].university
                        = semesterSheets[iSheet].getRow(0).getCell(1).
                        getStringCellValue();
                semesterTables[iSheet].department
                        = semesterSheets[iSheet].getRow(1).getCell(1).
                        getStringCellValue();
                semesterTables[iSheet].semester
                        = semesterSheets[iSheet].getRow(2).getCell(1).
                        getStringCellValue();
                semesterTables[iSheet].section
                        = semesterSheets[iSheet].getRow(3).getCell(1).
                        getStringCellValue();
                semesterTables[iSheet].classRoom
                        = semesterSheets[iSheet].getRow(3).getCell(1).
                        getStringCellValue();

                List<CellRangeAddress> allMergedRegions = semesterSheets[iSheet].getMergedRegions();
                List<CellStruct> mergedRegions = new ArrayList<>();
                Iterator<CellRangeAddress> iter = allMergedRegions.iterator();
                while (iter.hasNext()) {
                    CellRangeAddress region = iter.next();
                    if ((region.getFirstRow() >= firstRow)
                            && (region.getLastRow() <= lastRow)
                            && (region.getFirstColumn() >= firstCell - 1)
                            && (region.getLastColumn() <= lastCell)) {

                        mergedRegions.add(new CellStruct(region.getFirstRow(), region.getFirstColumn()));
                    }
                }
//                mergedRegions.sort(comparator);

                int iRow = firstRow;
                for (int physRow = 0; physRow < 5; physRow++) {
                    row[iSheet] = semesterSheets[iSheet].getRow(iRow);
                    CellStruct currentDayCell = new CellStruct(iRow, firstCell - 1);
                    if (mergedRegions.contains(currentDayCell)) {     //This is a merged row.
                        int iCell = firstCell;
                        for (int physCol = 0; physCol < 8; physCol++) {
                            CellStruct currentCell = new CellStruct(iRow, iCell);
                            if (mergedRegions.contains(currentCell)) {        //This is a merged cell.
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                                physCol++;
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                                iCell++;
                            } else {
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                            }
                            iCell++;
                        }
                        iRow++;
                        iCell = firstCell;
                        row[iSheet] = semesterSheets[iSheet].getRow(iRow);
                        for (int physCol = 0; physCol < 8; physCol++) {
                            CellStruct currentCell = new CellStruct(iRow, iCell);
                            if (mergedRegions.contains(currentCell)) {        //This is a merged cell.
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].altTable[physRow][physCol] = currentStr;
                                physCol++;
                                semesterTables[iSheet].altTable[physRow][physCol] = currentStr;
                                iCell++;
                            } else {
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].altTable[physRow][physCol] = currentStr;
                            }
                            iCell++;
                        }
                    } else {      //Not a merged row.
                        int iCell = firstCell;
                        for (int physCol = 0; physCol < 8; physCol++) {
                            CellStruct currentCell = new CellStruct(iRow, iCell);
                            if (mergedRegions.contains(currentCell)) {        //This is a merged cell.
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                                physCol++;
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                                iCell++;
                            } else {
                                cell[iSheet] = row[iSheet].getCell(iCell);
                                String currentStr = cell[iSheet].getStringCellValue();
                                semesterTables[iSheet].table[physRow][physCol] = currentStr;
                            }
                            iCell++;
                        }

                    }
                    iRow++;

                }

            }
        }
        return true;
    }

    public boolean parseSchedule(TableStruct[] semesterTables) {
//        TableStruct[] temp = new TableStruct[semesterTables.length];

        for (int i = 0; i < semesterTables.length; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 8; k++) {
                    if (semesterTables[i].table[j][k].contains(" L ")) {
                        semesterTables[i].table[j][k] = semesterTables[i].table[j][k].split(" ")[0] + semesterTables[i].table[j][k].split(" ")[1].split("SEC ")[1];
                        semesterTables[i].altTable[j][k] = semesterTables[i].altTable[j][k].split(" ")[0];
                    }
                    semesterTables[i].table[j][k] = semesterTables[i].table[j][k].split(" ")[0];
                    semesterTables[i].altTable[j][k] = semesterTables[i].altTable[j][k].split(" ")[0];

                }

            }
        }
        return true;
    }

//    public static Comparator<CellStruct> comparator = new Comparator<CellStruct>() {
//
//        @Override
//        public int compare(CellStruct c1, CellStruct c2) {
//            if (c1.row < c2.row) {
//                return -1;
//            } else if (c1.row > c2.row) {
//                return 1;
//            } else if (c1.row == c2.row) {
//                if (c1.column < c2.column) {
//                    return -1;
//                } else if (c1.column > c2.column) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//            return 0;
//
//        }
//
//    };
}
