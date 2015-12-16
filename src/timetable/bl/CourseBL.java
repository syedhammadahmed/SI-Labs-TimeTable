/*
 * Suffa Innovation Labs - Time Table
 *
 * A Unified Time Table and Calendar app.
 *
 * SI Labs (2015)
 */
package timetable.bl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import timetable.bo.Course;
import timetable.bo.TableStruct;
import timetable.dal.PersistentReader;
import timetable.dal.PersistentWriter;

/**
 *
 * @author Qureshi
 */
public class CourseBL {
    private PersistentWriter pWriter;
    private PersistentReader pReader;
    private ArrayList<TableStruct> semesterTables;
    private ArrayList<Course> courseList;
    
    public boolean readTables() throws IOException, FileNotFoundException, ClassNotFoundException{
//        for(int i=0; i<8; i++){
//            semesterTable.set(i, pReader.readTableObject(i+1));
//        }
        pReader = new PersistentReader();
        semesterTables = new ArrayList<>();
        semesterTables.add(pReader.readTableObject(1));
        
        return true;
    }
    
    public void printTest() {
        System.out.println(semesterTables.get(0).university);
        System.out.println(semesterTables.get(0).department);
        System.out.println(semesterTables.get(0).semester);
        System.out.println(semesterTables.get(0).section);
        System.out.println(semesterTables.get(0).classRoom);

        for (int i = 0; i < 5; i++) {
            System.out.println("Someday");
            for (int j = 0; j < 8; j++) {
                System.out.println("____");
                System.out.println(semesterTables.get(0).table[i][j] + " ");
                System.out.println("___********___");
//                System.out.println("\n");
            }
        }
    }

}
