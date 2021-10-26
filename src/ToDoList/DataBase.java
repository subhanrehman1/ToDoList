package ToDoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DataBase {
   
    public static void createTable() throws Exception{
        try{
            Connection conn=getConnection();
            PreparedStatement smt;
            smt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS Todoli(TASK VARCHAR(10000) NOT NULL, DUEDATE DATE);");
            smt.executeUpdate();
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static Connection getConnection() throws Exception{
        try{
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/sr";
            String user="root";
            String pass="Business123";
            Class.forName(driver);
            
            Connection conn= DriverManager.getConnection(url,user,pass);
            System.out.println("success");
            return conn;
             }
        catch(Exception e){
            System.out.println(e);
        }
        return null;
}
}