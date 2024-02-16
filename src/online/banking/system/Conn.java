
package online.banking.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Hell0mysql@");//create connection
            s = c.createStatement();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
