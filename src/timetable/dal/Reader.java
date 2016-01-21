/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.dal;

import timetable.bo.TableStruct;

/**
 * An interface for different readers for the two different file types such i.e.
 * .xlsx and .xls.
 *
 * @author Qureshi
 */
public interface Reader {
    public boolean read(TableStruct[] _semesterTable);
}
