package ping;

import modelo.TextAreaModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import modelo.IconModel;

public class View extends JFrame {

    private IconModel arquivoLabel = new IconModel(49, 45, 64, 64);
    private TextAreaModel arquivoText1 = new TextAreaModel(15, 5, 120, 20, "BHMN-ARQUIVO");
    private TextAreaModel arquivoText2 = new TextAreaModel(15, 25, 120, 20, "10.5.184.4");

    private IconModel webLabel = new IconModel(169, 45, 64, 64);
    private TextAreaModel webText1 = new TextAreaModel(135, 5, 120, 20, "BHMN-WEB");
    private TextAreaModel webText2 = new TextAreaModel(135, 25, 120, 20, "10.5.176.3");

    private IconModel bdLabel = new IconModel(289, 45, 64, 64);
    private TextAreaModel bdText1 = new TextAreaModel(255, 5, 120, 20, "BHMN-BD");
    private TextAreaModel bdText2 = new TextAreaModel(255, 25, 120, 20, "10.5.184.1");

    private IconModel mainLabel = new IconModel(464, 105, 64, 64);
    private TextAreaModel mainText1 = new TextAreaModel(430, 60, 120, 20, "BHMN-FÍSICO");
    private TextAreaModel mainText2 = new TextAreaModel(430, 80, 120, 20, "10.5.183.224");
    
    private IconModel backupLabel = new IconModel(1275, 40, 64, 64);
    private TextAreaModel backupText1 = new TextAreaModel(1240, 5, 120, 20, "BACKUP");
    private TextAreaModel backupText2 = new TextAreaModel(1240, 25, 120, 20, "10.5.185.13");

    private IconModel telematicaSWLabel = new IconModel(690, 40, 64, 64);
    private TextAreaModel telematicaSWText1 = new TextAreaModel(650, 8, 120, 20, "TELEMÁTICA");
    private TextAreaModel telematicaSWText2 = new TextAreaModel(650, 28, 120, 20, "10.5.183.244");

    private IconModel cltiSWLabel = new IconModel(890, 40, 64, 64);
    private TextAreaModel cltiSWText1 = new TextAreaModel(850, 8, 120, 20, "CLTI");
    private TextAreaModel cltiSWText2 = new TextAreaModel(850, 28, 120, 20, "0.0.0.0");

    private IconModel centralSWLabel = new IconModel(1090, 40, 64, 64);
    private TextAreaModel centralSWText1 = new TextAreaModel(1050, 8, 120, 20, "CENTRAL");
    private TextAreaModel centralSWText2 = new TextAreaModel(1050, 28, 120, 20, "0.0.0.0");

    private IconModel telematica2SWLabel = new IconModel(600, 160, 64, 64);
    private TextAreaModel telematica2SWText1 = new TextAreaModel(565, 226, 120, 20, "TELEMÁTICA-2");
    private TextAreaModel telematica2SWText2 = new TextAreaModel(565, 246, 120, 20, "10.5.176.72");

    private IconModel secomSWLabel1 = new IconModel(400, 310, 64, 64);
    private TextAreaModel secomSWText1 = new TextAreaModel(365, 374, 120, 20, "SECOM-2");
    private TextAreaModel secomSWText2 = new TextAreaModel(365, 394, 120, 20, "10.5.0.0");

    private IconModel secom2SWLabel1 = new IconModel(600, 310, 64, 64);
    private TextAreaModel secom2SWText1 = new TextAreaModel(565, 374, 120, 20, "SECOM");
    private TextAreaModel secom2SWText2 = new TextAreaModel(565, 394, 120, 20, "10.5.0.0");

    private IconModel academiaSWLabel = new IconModel(600, 460, 64, 64);
    private TextAreaModel academiaSWText1 = new TextAreaModel(565, 524, 120, 20, "ACADÊMIA");
    private TextAreaModel academiaSWText2 = new TextAreaModel(565, 544, 120, 20, "10.5.176.84");

    private IconModel ranchoSWLabel = new IconModel(400, 460, 64, 64);
    private TextAreaModel ranchoSWText1 = new TextAreaModel(365, 524, 120, 20, "RANCHO");
    private TextAreaModel ranchoSWText2 = new TextAreaModel(365, 544, 120, 20, "10.5.176.82");

    private IconModel intendenciaSWLabel = new IconModel(780, 160, 64, 64);
    private TextAreaModel intendenciaSWText1 = new TextAreaModel(745, 226, 120, 20, "INTENDÊNCIA");
    private TextAreaModel intendenciaSWText2 = new TextAreaModel(745, 246, 120, 20, "10.5.0.0");

    private IconModel saudeSWLabel = new IconModel(780, 310, 64, 64);
    private TextAreaModel saudeSWText1 = new TextAreaModel(745, 374, 120, 20, "SAÚDE");
    private TextAreaModel saudeSWText2 = new TextAreaModel(745, 394, 120, 20, "10.5.0.0");

    private TextAreaModel attRede = new TextAreaModel(430, 5, 140, 20, "Atualizando Rede...");

    private JLabel hora = null;
    private JPasswordField senha = null;
    private JLabel att = null;
    private JLabel teste = null;
    private JLabel teste2 = null;
    private JLabel teste3 = null;
    private JLabel senhatxt = null;
    private JTextField login = null;
    private ImagePanel interna = null;
    private JButton entra = null;
    private Timer timer;

    public View() {
        super();
        //JOptionPane.showMessageDialog(null, "Bem vindo ao teste do algoritmo de mem�rias associativas\nDe in�cio ser�o executados algumas rotinas\nPrimeiro iremos carregar os vetores de entrada e sa�da ja estipulados\nEm seguida a matrizResultado ser� treinada com o algoritmo para uma posterior compara��o e aproxima��o dos valores\nJust relax e acompanhe");
        initialize();
    }

    private void initialize() {
        this.setSize(300, 300);
        //this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/8.png")));
        this.setTitle("Status BHMN");
        this.setContentPane(getInterna());
        disparaRelogio();

    }

    private JPanel getInterna() {
        if (interna == null) {

            Image img = new ImageIcon(getClass().getResource("/img/login.jpg")).getImage();
            interna = new ImagePanel(img);
            interna.setLayout(null);
            interna.setBackground(new Color(0, 100, 0));

            interna.add(arquivoLabel.getIconLabel(), null);
            interna.add(arquivoText1.getTextField(), null);
            interna.add(arquivoText2.getTextField(), null);

            interna.add(webLabel.getIconLabel(), null);
            interna.add(webText1.getTextField(), null);
            interna.add(webText2.getTextField(), null);

            interna.add(bdLabel.getIconLabel(), null);
            interna.add(bdText1.getTextField(), null);
            interna.add(bdText2.getTextField(), null);

            interna.add(mainLabel.getIconLabel(), null);
            interna.add(mainText1.getTextField(), null);
            interna.add(mainText2.getTextField(), null);

            interna.add(telematicaSWLabel.getIconLabel(), null);
            interna.add(telematicaSWText1.getTextField(), null);
            interna.add(telematicaSWText2.getTextField(), null);

            interna.add(cltiSWLabel.getIconLabel(), null);
            interna.add(cltiSWText1.getTextField(), null);
            interna.add(cltiSWText2.getTextField(), null);

            interna.add(centralSWLabel.getIconLabel(), null);
            interna.add(centralSWText1.getTextField(), null);
            interna.add(centralSWText2.getTextField(), null);

            interna.add(backupLabel.getIconLabel(), null);
            interna.add(backupText1.getTextField(), null);
            interna.add(backupText2.getTextField(), null);

            interna.add(academiaSWLabel.getIconLabel(), null);
            interna.add(academiaSWText1.getTextField(), null);
            interna.add(academiaSWText2.getTextField(), null);

            interna.add(secomSWLabel1.getIconLabel(), null);
            interna.add(secomSWText1.getTextField(), null);
            interna.add(secomSWText2.getTextField(), null);

            interna.add(secom2SWLabel1.getIconLabel(), null);
            interna.add(secom2SWText1.getTextField(), null);
            interna.add(secom2SWText2.getTextField(), null);

            interna.add(ranchoSWLabel.getIconLabel(), null);
            interna.add(ranchoSWText1.getTextField(), null);
            interna.add(ranchoSWText2.getTextField(), null);

            interna.add(intendenciaSWLabel.getIconLabel(), null);
            interna.add(intendenciaSWText1.getTextField(), null);
            interna.add(intendenciaSWText2.getTextField(), null);

            interna.add(saudeSWLabel.getIconLabel(), null);
            interna.add(saudeSWText1.getTextField(), null);
            interna.add(saudeSWText2.getTextField(), null);

            interna.add(telematica2SWLabel.getIconLabel(), null);
            interna.add(telematica2SWText1.getTextField(), null);
            interna.add(telematica2SWText2.getTextField(), null);

            hora = new JLabel();
            hora.setBorder(null);
            hora.setBackground(Color.WHITE);
            hora.setForeground(new Color(0, 100, 0));
            //hora.setText(""); 
            hora.setBounds(205, 300, 250, 128);
            //welcome.setIcon(new ImageIcon(getClass().getResource("/img/48/enable-server-icon.png")));
            hora.setFont(new Font("Arial", Font.BOLD, 40));
            interna.add(hora, null);

            att = new JLabel("Atualizando rede...");
            att.setBorder(null);
            att.setBackground(new Color(0, 100, 0));
            att.setForeground(Color.RED);
            att.setBounds(430, 5, 140, 20);
            //teste.setIcon(new ImageIcon(getClass().getResource("/img/64/hwp016839_1.png")));
            att.setFont(new Font("Arial", Font.BOLD, 12));
            interna.add(att, null);

            teste = new JLabel("0 computaDores conectados");
            teste.setBorder(null);
            teste.setBackground(new Color(0, 100, 0));
            teste.setForeground(Color.WHITE);
            teste.setBounds(20, 460, 500, 50);
            //teste.setIcon(new ImageIcon(getClass().getResource("/img/64/hwp016839_1.png")));
            teste.setFont(new Font("Arial", Font.BOLD, 26));
//            interna.add(teste, null);

            teste2 = new JLabel("PING: ");
            teste2.setBorder(null);
            teste2.setBackground(new Color(0, 100, 0));
            teste2.setForeground(Color.WHITE);
            teste2.setBounds(20, 400, 300, 50);
            //teste.setIcon(new ImageIcon(getClass().getResource("/img/64/hwp016839_1.png")));
            teste2.setFont(new Font("Arial", Font.BOLD, 26));
//            interna.add(teste2, null);

            teste3 = new JLabel("Start ping: ");
            teste3.setBorder(null);
            teste3.setBackground(new Color(0, 100, 0));
            teste3.setForeground(Color.WHITE);
            teste3.setBounds(20, 520, 300, 50);
            //teste.setIcon(new ImageIcon(getClass().getResource("/img/64/hwp016839_1.png")));
            teste3.setFont(new Font("Arial", Font.BOLD, 26));
//            interna.add(teste3, null);

        }
        return interna;
    }

    public void disparaRelogio() {
        if (timer == null) {
            timer = new Timer(1000, new ClockListener());
            timer.setInitialDelay(0);
            timer.start();
        } else if (!timer.isRunning()) {
            timer.restart();
        }
    }

    public void setArquivo(boolean odin1) {
        if (odin1 == true) {
            arquivoLabel.setBounds(40, 45, 64, 64);
            arquivoLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/drive-system-tux-icon.png")));
        } else {
            arquivoLabel.setBounds(49, 45, 64, 64);
            arquivoLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setWeb(boolean odin1) {
        if (odin1 == true) {
            webLabel.setBounds(160, 45, 64, 64);
            webLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/drive-system-tux-icon.png")));
        } else {
            webLabel.setBounds(169, 45, 64, 64);
            webLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setBd(boolean odin1) {
        if (odin1 == true) {
            bdLabel.setBounds(280, 45, 64, 64);
            bdLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/drive-system-tux-icon.png")));
        } else {
            bdLabel.setBounds(289, 45, 64, 64);
            bdLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setFisico(boolean odin1) {
        if (odin1 == true) {
            mainLabel.setBounds(455, 105, 64, 64);
            mainLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/Home-Server-icon.png")));
        } else {
            mainLabel.setBounds(464, 105, 64, 64);
            mainLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setBackup(boolean odin1) {
        if (odin1 == true) {
            backupLabel.setBounds(1270, 40, 64, 64);
            backupLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/Internal-Drive-640GB-icon.png")));
        } else {
            backupLabel.setBounds(1275, 40, 64, 64);
            backupLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setTelematicaSW(boolean main_sw2) {
        if (main_sw2 == true) {
            telematicaSWLabel.setBounds(630, 60, 171, 23);
            telematicaSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/hp.png")));
        } else {
            telematicaSWLabel.setBounds(690, 40, 64, 64);
            telematicaSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setCltiSW(boolean main_sw2) {
        if (main_sw2 == true) {
            cltiSWLabel.setBounds(830, 60, 171, 23);
            cltiSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/hp.png")));
        } else {
            cltiSWLabel.setBounds(890, 40, 64, 64);
            cltiSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setCentralSW(boolean main_sw2) {
        if (main_sw2 == true) {
            centralSWLabel.setBounds(1030, 60, 171, 23);
            centralSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/64/hp.png")));
        } else {
            centralSWLabel.setBounds(1090, 40, 64, 64);
            centralSWLabel.setIcon(new ImageIcon(getClass().getResource("/img/48/Delete-icon.png")));
        }
    }

    public void setTeste(int teste) {
        this.teste.setText("" + teste + "pc Conectados");
    }

    public void setTeste2(String teste) {
        this.teste2.setText("PING: " + teste);
    }

    public void setTeste3(String teste) {
        this.teste3.setText("Start ping: " + teste);
    }

    public void setAtt(String teste) {
        this.att.setText("" + teste);
    }

    class ClockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Date hora1 = new Date();
            SimpleDateFormat hora_formato = new SimpleDateFormat("HH:mm:ss");
            hora.setText("" + hora_formato.format(hora1));

        }
    }

}  //  @jve:decl-index=0:visual-constraint="8,1"
