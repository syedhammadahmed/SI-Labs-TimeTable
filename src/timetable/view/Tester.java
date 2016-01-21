/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.view;

import timetable.controller.Controller;

/**
 *
 * @author Qureshi
 */
public class Tester {
    public static void main(String[] args ){
        Controller controller = new Controller();
        controller.loadSchedule();
        controller.printTest();
        
    }
}
