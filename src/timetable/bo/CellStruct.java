/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.bo;

/**
 *
 * @author Qureshi
 */
public class CellStruct implements Comparable{
    public int row;
    public int column;

    public CellStruct(int row, int column) {
        this.row = row;
        this.column = column;
    }

    
    @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (other == this) {
                return true;
            }
            if (!(other instanceof CellStruct)) {
                return false;
            }
            CellStruct c2 = (CellStruct) other;  
            if((this.row == c2.row)&&(this.column == c2.column)){
                return true;
            }
            else{
                return false;
            }

        }

    @Override
    public int compareTo(Object o) {
        CellStruct c2 = (CellStruct)o;
        if (this.row < c2.row) {
                return -1;
            } else if (this.row > c2.row) {
                return 1;
            } else if (this.row == c2.row) {
                if (this.column < c2.column) {
                    return -1;
                } else if (this.column > c2.column) {
                    return 1;
                } else {
                    return 0;
                }
            }
        return 0;
    }

    
}
