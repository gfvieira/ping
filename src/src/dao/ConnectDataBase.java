package src.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {  
        public static Connection connection = null;
      
    public ConnectDataBase(){  
        try {  
            Class.forName("org.postgresql.Driver"); 
            //Class.forName("org.firebirdsql.jdbc.FBDriver");//org.firebirdsql.jdbc.FBDriver  
        } catch (ClassNotFoundException e) {  

        }  
    }  
      
    public Connection openConection(){  
        if(connection == null){  
            try {  
                connection = DriverManager.getConnection("jdbc:postgresql://10.5.176.19:5432/sigbase", "postgres", "postgres");  
                //connection = DriverManager.getConnection("jdbc:postgresql://10.5.176.19:5432/sigbase_teste", "postgres", "postgres");  
                //connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sigbase", "postgres", "teste");  
                //connection = DriverManager.getConnection("jdbc:firebirdsql://localhost/3050:C:\\Firebird\\sisfolhan\\bd\\SISFOLHAN.GBD", "SYSDBA", "masterkey");  
                //connection = DriverManager.getConnection("jdbc:firebirdsql://10.5.176.4:3050/c:\\sistemas\\sisfolhan\\bd\\sisfolhan.gdb", "SYSDBA", "masterkey");  
                int i =0;
            } catch (SQLException e) {  
                return null;
            } 
        }  
        return connection;  
    }  
      
    public void closeConnection(){  
        if(connection != null){  
            try {  
                connection.close();
                connection = null;
            } catch (SQLException e) {  
            }  
        }  
    }  
}  
