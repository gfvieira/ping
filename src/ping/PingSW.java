package ping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PingSW implements Runnable {

    View view = null;

    PingSW(View view) {
        this.view = view;
    }

    @Override
    public void run() {
        while (true) {
            String ipSWTelematica = "10.7.81.10";    //BHMN-ARQUIVO
            String ipSWCentral = "10.7.81.1";    //BHMN-ARQUIVO
            String ipSWCLTI = "10.7.81.1";    //BHMN-ARQUIVO
            String ipSWTelematica2 = "10.7.81.72";    //BHMN-ARQUIVO
            String ipSWSaude = "10.7.81.2";    //BHMN-ARQUIVO
            String ipSWAcademia = "10.7.81.5";    //BHMN-ARQUIVO
            String ipSWRancho = "10.7.81.4";    //BHMN-ARQUIVO
            String ipSWIntendencia = "10.7.81.8";    //BHMN-ARQUIVO
            
            view.setAtt("Atualizando rede...");

            view.setTelematicaSW(isReachablebyPing(ipSWTelematica));
            view.setCltiSW(isReachablebyPing(ipSWCLTI));
            view.setCentralSW(isReachablebyPing(ipSWCentral));

            view.setAtt("");

            try {
                sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(PingServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean isReachablebyPing(String ip) {
        try {
            String command;
            if (System.getProperty("os.name").toLowerCase().startsWith("windows")) {
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
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(StreamGobbler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private static boolean checkAvailability(List<String> outputLines) {

        for (String line : outputLines) {
            if (line.contains("unreachable")) {
                return false;
            }
            if (line.contains("TTL=")) {
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
                while ((line = br.readLine()) != null) {
                    outputLines.add(line);
                }
            } catch (IOException ex) {
                Logger.getLogger(StreamGobbler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
