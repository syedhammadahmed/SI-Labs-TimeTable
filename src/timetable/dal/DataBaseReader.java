/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package timetable.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Qureshi
 */
public class DataBaseReader {
    
    Connection conn;

    public DataBaseReader() throws SQLException {
        this.conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Qureshi/Documents/SI Labs/SI-Labs-TimeTable/SILABS_DB.accdb");
    }
    
    public boolean queryTest() throws SQLException{
    Statement s = conn.createStatement();
    ResultSet rs = s.executeQuery("SELECT [Time] FROM [TIMESLOT] WHERE Day like 'Wednesday'");
    while (rs.next()) {
        System.out.println(rs.getString(1));
    }
        
        return true;
    }
    
}
