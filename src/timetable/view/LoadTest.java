/*
 * Suffa Innovation Labs - Time Table
 * 
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.view;

import java.io.FileNotFoundException;
import java.io.IOException;
import timetable.controller.Controller;

/**
 * This tester can be used to test the controller's collateData() and
 * printTest() functions. It reads the .xlsx file into a table structure owned
 * by controller (to be written to file using the XLSXWriter class). The
 * resulting TableStruct is printed to console.
 *
 * @author Qureshi
 */
public class LoadTest {

    public static void main(String args[]) 
            throws IOException, FileNotFoundException, ClassNotFoundException {
        Controller controller = new Controller();
        if (controller.loadFiles()) {
            System.out.println("Loaded!!");
        } else {
            System.out.println("Load Fail!!");
        }
        controller.printTest();

    }

}
