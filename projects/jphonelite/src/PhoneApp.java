import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.URL;
import javaforce.*;

/** Entry point for jphonelite application. */

public class PhoneApp extends JFrame implements WindowListener, WindowController {
  public static void main(String args[]) {
    final String configFileUrl;
    if (args.length > 0) {
        configFileUrl = args[0];
    } else {
        configFileUrl = null;
    }
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PhoneApp(configFileUrl).setVisible(true);
      }
    });
  }

  private PhonePanel panel;

  private PhoneApp(String configFileUrl) {
    if (!BasePhone.lockFile()) {
      JF.showError("Error", "Another instance of jPhoneLite is already running!");
      System.exit(0);
    }
    if (configFileUrl != null) {
        setupConfig(configFileUrl);
    }
    panel = new PhonePanel(this, false);
    addWindowListener(this);
    setResizable(false);
    setContentPane(panel);
    pack();
    setTitle("jPhoneLite/" + PhonePanel.version);
    JFImage icon = new JFImage();
    icon.loadPNG(this.getClass().getClassLoader().getResourceAsStream("jphonelite.png"));
    setIconImage(icon.getImage());
    setPosition();
  }
  
  public void setupConfig(String url) {
    System.out.println("Loading config : " + url);
    try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
      FileOutputStream fos = new FileOutputStream(JF.getUserPath() + "/.jphone.xml");
      String line;
      do {
        line = reader.readLine();
        if (line == null) break;
        fos.write(line.getBytes());
      } while (true);
      fos.close();
    } catch (Exception e) {
      System.out.println("Error loading config : " + e);
    }
  }
  
//interface WindowListener
  public void windowOpened(WindowEvent e) { }
  public void windowClosing(WindowEvent e) {
    if (Settings.current.exitWhenClosed) {
      panel.unRegisterAll();
      Settings.saveSettings();
      BasePhone.unlockFile();
      System.exit(0);
    }
  }
  public void windowClosed(WindowEvent e) { }
  public void windowIconified(WindowEvent e) {
    if (Settings.current.hideWhenMinimized) {
      setVisible(false);
    }
  }
  public void windowDeiconified(WindowEvent e) { }
  public void windowActivated(WindowEvent e) {
    panel.active = true;
  }
  public void windowDeactivated(WindowEvent e) {
    panel.active = false;
  }
//interface WindowController
  public void setPanelSize() {
    pack();
  }
  public void setPanelVisible() {
    setVisible(true);
    setExtendedState(NORMAL);
  }
  public void setPanelAlwaysOnTop(boolean state) {
    setAlwaysOnTop(state);
  }
  public void startFlash() {}
  public void stopFlash() {}
  public void setPosition() {
    Dimension d = getPreferredSize();
    Rectangle s = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    setLocation(s.width/2 - d.width/2, s.height/2 - d.height/2);
  }
}
