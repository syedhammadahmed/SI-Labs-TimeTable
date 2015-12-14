/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.view;

import java.io.IOException;
import timetable.controller.Controller;

/**
 *
 * @author Qureshi
 */
public class SaveTest {
    

    public static void main(String args[]) throws IOException {
        Controller controller = new Controller();
        controller.collateData();
        controller.printTest();
        //controller.saveData();
                
        if (controller.saveData()) {
            System.out.println("Saved!!");
        } else {
            System.out.println("Save Fail!!");
        }

        

    }


}
