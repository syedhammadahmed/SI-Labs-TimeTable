/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;

/**
 *
 * @author Qureshi
 */
public class TableStruct {
    
    public String university;
    public String department;
    public String semester;
    public String section;
    public String classRoom;
    public String[][] table;
    
    public TableStruct(int _rows, int _columns){
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
    }

    public boolean fixMergedRegions(){
        
        
        
        
        
        return true;
    }
    
}
