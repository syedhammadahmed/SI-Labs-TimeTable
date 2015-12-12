/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;

/**
 * An interface for different readers for the two different file types such i.e.
 * .xlsx and .xls.
 *
 * @author Qureshi
 */
public interface Reader {
    public boolean read(TableStruct _semesterTable);
}
