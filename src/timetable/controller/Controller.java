/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.controller;

import timetable.dal.Reader;
import timetable.bo.TableStruct;
import timetable.dal.XLSXReader;

/**
 *
 * @author Qureshi
 */
public class Controller {

    private Reader reader;
    private TableStruct semesterTable;

    public boolean collateData() {
        semesterTable = new TableStruct(5, 8);  //5 days, 8 time-slots each
        reader = new XLSXReader();
        //Read into semesterTable
        if (reader.read(semesterTable)) {
            System.out.println("Table Read!!");
        } else {
            System.out.println("Read Fail!!");
        }

        return true;
    }

    public void printTest() {
        System.out.println(semesterTable.university);
        System.out.println(semesterTable.department);
        System.out.println(semesterTable.semester);
        System.out.println(semesterTable.section);
        System.out.println(semesterTable.classRoom);

        for (int i = 0; i < 5; i++) {
            System.out.println("Someday");
            for (int j = 0; j < 8; j++) {
                System.out.println("____");
                System.out.println(semesterTable.table[i][j] + " ");
                System.out.println("___********___");
            }
        }
    }

}
