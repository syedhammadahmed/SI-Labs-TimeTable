/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.view;

import timetable.controller.Controller;

/**
 * This tester can be used to test the controller's collateData() and
 * printTest() functions. It reads the .xlsx file into a table structure owned
 * by controller (to be written to file using the XLSXWriter class). The
 * resulting TableStruct is printed to console.
 *
 * @author Qureshi
 */
public class ReaderTest {

    public static void main(String args[]) {
        Controller controller = new Controller();
        if (controller.collateData()) {
            System.out.println("Collated!!");
        } else {
            System.out.println("Collate Fail!!");
        }

        controller.printTest();

    }

}
