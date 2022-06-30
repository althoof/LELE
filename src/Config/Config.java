/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Muh
 */
public class Config {
    //Init var
    private Connection conn;
    private Statement stm;
    ResultSet rs;
    String url = "jdbc:mysql://localhost/penjualan";
    String user = "root";
    String pass = "";
    
    public Config(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,pass);
            stm = conn.createStatement();
        }catch(SQLException ex){
            System.err.print(ex);
        }catch(ClassNotFoundException ex){
            System.err.print(ex);
        } 
    }
    
    public ResultSet getData(String SQLString){
        try {
            rs = stm.executeQuery(SQLString);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "error :"
                    +e.getMessage(),"Communication Error pada method getdata",
                    JOptionPane.WARNING_MESSAGE);
        }
        return rs;
    }
     
    public void query (String SQLString){
        try {
            stm.execute(SQLString);
        }
        catch (Exception e){
            JOptionPane.showMessageDialog
                    (null, "error"+e.getMessage(),
                            "Communication Error pada method query",
                            JOptionPane.WARNING_MESSAGE);
        }
    }
}
