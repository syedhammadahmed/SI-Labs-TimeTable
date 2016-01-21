/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.bo;


/**
 *
 * @author Qureshi
 */
public class TableStruct{
    
    public String university;
    public String department;
    public String semester;
    public String section;
    public String classRoom;
    public String[][] table;
    public String[][] altTable;
    
    public TableStruct(int _rows, int _columns) {
        this.university = "";
        this.department = "";
        this.semester = "";
        this.section = "";
        this.classRoom = "";        
        table = new String[_rows][_columns];
        for(int i=0; i<_rows; i++ ){
            for(int j=0; j<_columns; j++){
                table[i][j] = "";
            }
        }
        altTable = new String[_rows][_columns];
        for(int i=0; i<_rows; i++ ){
            for(int j=0; j<_columns; j++){
                altTable[i][j] = "";
            }
        }
    }
}
