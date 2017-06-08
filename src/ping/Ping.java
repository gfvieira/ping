package ping;

import java.awt.Dimension;
import java.awt.Toolkit;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Ping {

    boolean packFrame = false;
    View view = null;
    View_Computer view2 = null;

    public Ping() {
        view = new View();
        view2 = new View_Computer();
        PingServer pingserver = new PingServer(view);
        Thread threadserver = new Thread(pingserver);
        threadserver.start();
        PingSW pingsw = new PingSW(view);
        Thread threadsw = new Thread(pingsw);
        threadsw.start();
        PingComputer pingip = new PingComputer(view, view2);
        Thread threadip = new Thread(pingip);
        threadip.start();
        // Validate frames that have preset sizes
        // Pack frames that have useful preferred size info, e.g. from their layout
        if (packFrame) {
            view.pack();
        } else {
            view.validate();
        }

        // Center the window
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = view.getSize();
        if (frameSize.height > screenSize.height) {
            frameSize.height = screenSize.height;
        }
        if (frameSize.width > screenSize.width) {
            frameSize.width = screenSize.width;
        }

        view.setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
        view.setSize(1300, 625);
        view.setDefaultCloseOperation(EXIT_ON_CLOSE);
        view.setVisible(true);
        view.setLocation(0, 0);
        view.setResizable(true);

        //login2.setSize(800,800);
        //login2.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //login2.setVisible(true);
        //login2.setResizable(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.
                            getSystemLookAndFeelClassName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                new Ping();
            }
        });
    }

}
