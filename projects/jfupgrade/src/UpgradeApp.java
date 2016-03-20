/**
 * Created : Mar 31, 2012
 *
 * @author pquiring
 */

import java.awt.*;
import java.io.*;

import javaforce.*;
import javaforce.jbus.*;
import javaforce.linux.*;

public class UpgradeApp extends javax.swing.JFrame {

  /**
   * Creates new form UpgradeApp
   */
  public UpgradeApp() {
    initComponents();
    setContentPane(new MainPanel());
    getScreenSize();
    setPosition();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Upgrades");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 593, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 649, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    if ((args != null) && (args.length > 0) && (args[0].equals("--cron"))) {
      cron();
      return;
    }
    /*
     * Create and display the form
     */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new UpgradeApp().setVisible(true);
      }
    });
  }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

  private int sx,sy;

  private void getScreenSize() {
    Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    sx = r.width;
    sy = r.height;
  }

  private static void cron() {
    Linux.detectDistro();
    ShellProcess sp = new ShellProcess();
    sp.removeEnvironmentVariable("TERM");
    String output;
    switch (Linux.distro) {
      case Ubuntu:
        output = sp.run(new String[] {"apt-get", "--yes", "update"}, true);
        if (output == null) {
          System.out.println("Error : Failed to exec apt-get");
        } else {
          ubuntuGetCounts();
        }
        break;
      case Fedora:
        output = sp.run(new String[] {"yum", "-y", "check-update"}, true);
        if (output == null) {
          System.out.println("Error : Failed to exec yum");
        } else {
          fedoraGetCounts();
        }
        break;
    }
  }

  private static void ubuntuGetCounts() {
    ShellProcess sp = new ShellProcess();
    sp.removeEnvironmentVariable("TERM");
    String output = sp.run(new String[] {"apt-get", "--yes", "upgrade", "-s"}, false);
    if (output == null) {
      System.out.println("Error : Failed to exec apt-get");
      return;
    }
    String lns[] = output.split("\n");
    int cnts = -1;
    for(int a=0;a<lns.length;a++) {
      if (lns[a].indexOf("upgraded") != -1 && lns[a].indexOf("newly installed") != -1 && lns[a].indexOf("to remove") != -1) {
        cnts = a;
        break;
      }
    }
    if (cnts == -1) {
      //No upgrades found
      return;
    }
    int i1 = lns[cnts].indexOf("and");
    int i2 = lns[cnts].indexOf("not");
    int notUpgradedCnt = JF.atoi(lns[cnts].substring(i1+3, i2).trim());
    int i3 = lns[cnts].indexOf(" ");
    int upgradedCnt = JF.atoi(lns[cnts].substring(0, i3));
    try {
      //write to /etc/upgrade.cnts
      String str = "" + upgradedCnt + " upgrades available\n";
      if (notUpgradedCnt > 0) {
        str += "" + notUpgradedCnt + " kept back\n";
      }
      FileOutputStream fos = new FileOutputStream("/etc/upgrade.cnts");
      fos.write(str.getBytes());
      fos.close();
      //send counts to jLogon which will broadcast to jDesktop's
      sendCounts(upgradedCnt);
    } catch (Exception e) {
      System.out.println("Error:" + e);
    }
  }

  private static void fedoraGetCounts() {
    ShellProcess sp = new ShellProcess();
    sp.removeEnvironmentVariable("TERM");
    String output = sp.run(new String[] {"yum", "--assumeno", "update", null}, true);
    if (output == null) {
      System.out.println("Error : Failed to exec yum");
      return;
    }
    String lns[] = output.split("\n");
    int cnts = -1;
    boolean summary = false;
    for(int a=0;a<lns.length;a++) {
      if (lns[a].startsWith("Transaction Summary")) summary = true;
      if (!summary) continue;
      if (lns[a].startsWith("Upgrade")) {
        cnts = a;
        break;
      }
    }
    if (cnts == -1) {
      //No upgrades found
      return;
    }
    String f[] = lns[cnts].split(" +");  //greedy spaces
    int upgradedCnt = JF.atoi(f[1]);
    try {
      //write to /etc/upgrade.cnts
      String str = "" + upgradedCnt + " upgrades available\n";
      FileOutputStream fos = new FileOutputStream("/etc/upgrade.cnts");
      fos.write(str.getBytes());
      fos.close();
      //send counts to jLogon which will broadcast to jDesktop's
      sendCounts(upgradedCnt);
    } catch (Exception e) {
      System.out.println("Error:" + e);
    }
  }

  private static void sendCounts(int upgrade) {
    JBusClient client = new JBusClient(null, null);
    client.start();
    client.call("org.jflinux.jfsystemmgr", "upgradesAvailable", "" + upgrade);
    client.close();
  }

  private void setPosition() {
    Dimension d = getSize();
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    if ((d.width > s.width) || (d.height > s.height)) {
      if (d.width > s.width) d.width = s.width;
      if (d.height > s.height) d.height = s.height;
      setSize(d);
    }
    setLocation(s.width/2 - d.width/2, s.height/2 - d.height/2);
  }
}
