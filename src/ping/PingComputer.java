package ping;

import modelo.model;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.dao.DaoPing;


public class PingComputer implements Runnable {
    
    View login = null;
    View_Computer login2 = null;
    int pc = 0;
    String ip = "";
    ArrayList<model> list = null;
    Loger log = null;

    
    PingComputer(View login, View_Computer login2) {
        this.login = login;
        this.login2 = login2;
    }
    @Override
    public void run () {
        while(true){
            list = new ArrayList();
            log = new Loger();
            Timestamp tm = new Timestamp(System.currentTimeMillis());
            String t = new SimpleDateFormat("HH:mm:ss").format(tm);
            login.setTeste3(t);
            try {
                for(int j=183; j<=184; j++){
                    for(int i=0; i<255; i++){
                        ip = "10.5."+j+"."+i+"";
                        login.setTeste2(ip);
                        if(isReachablebyPing(ip) == true){
                            model mod = new model();
                            mod.setIp(ip);
                            mod.setHost(ip);
                            list.add(mod);
                            pc++;
                            login.setTeste(pc);
                            Timestamp tm2 = new Timestamp(System.currentTimeMillis());
                            String t2 = new SimpleDateFormat("HH:mm:ss").format(tm2);
                            login2.setStatus(ip, t2);
                        }
                    }
                }
            sleep(60000);
            DaoPing daoping = new DaoPing();
            boolean check = daoping.inserehost(pc, t);
            pc = 0;
            login.setTeste(pc);
            log.Gravar(list);
            } catch (InterruptedException ex) {
                Logger.getLogger(PingComputer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }
    
     public boolean isReachablebyPing(String ip) {

        try {
            String command;

        if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            // For Windows
            command = "ping -n 2 " + ip;
        } else {
            // For Linux and OSX
            command = "ping -c 2 " + ip;
        }

        Process proc = Runtime.getRuntime().exec(command);
        StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");
        outputGobbler.start();

        proc.waitFor();
        return checkAvailability(outputGobbler.getOutputLines());

        } catch(IOException | InterruptedException ex) {
        Logger.getLogger(StreamGobbler.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }
  private static boolean checkAvailability(List<String> outputLines) {

        for(String line : outputLines) {
            if(line.contains("unreachable")) {
                return false;
            }
            if(line.contains("TTL=")) {
                return true;
            }
        }
        return false;

    }



class StreamGobbler extends Thread {

    protected InputStream is;

    protected String type;

    protected List<String> outputLines;

    StreamGobbler(InputStream is, String type) {
        this.is = is;
        this.type = type;
        outputLines = new ArrayList<>();
    }

    public List<String> getOutputLines() {
        return outputLines;
    }

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while((line = br.readLine()) != null) {
                outputLines.add(line);
            }
        } catch(IOException ex) {
                Logger.getLogger(StreamGobbler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
}