package src.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import ping.Loger;


public class DaoPing {
    private ConnectDataBase connectDataBase = null;
    private Statement statement;
        Loger log = null;

    
    public DaoPing() {
        connectDataBase = new ConnectDataBase();  
    }    
    
    public boolean inserehost(int pc, String t)  {
       Timestamp tm = new Timestamp(System.currentTimeMillis());
       Date date = new Date();
       LocalTime thisSec = LocalTime.parse(t);
       String insere2TableSQL = "insert into  number_host(qnt, data, hora)"
               + "  values ('"+pc+"', '"+date+"', '"+thisSec+"');";
       try{
                if(connectDataBase.openConection() == null)
                    return false;
                statement = connectDataBase.openConection().createStatement();   
                statement.executeUpdate(insere2TableSQL);
                //statement.close();
                //connectDataBase.closeConnection();
                return true;
            }catch (SQLException e){
                log.Gravar(e.getMessage());
                return false;
            }
        finally {
             connectDataBase.closeConnection();
         }
    }
}
