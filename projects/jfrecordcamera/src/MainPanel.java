/**
 *
 * @author pquiring
 *
 * Created : Sept 25, 2013
 */

import java.io.*;
import javax.swing.*;

import javaforce.*;
import javaforce.media.*;

public class MainPanel extends javax.swing.JPanel implements MediaIO {

  public static String version = "0.3";

  /**
   * Creates new form MainPanel
   */
  public MainPanel() {
    initComponents();
    listCameras();
    listAudioDevices();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
   * content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    buttonGroup2 = new javax.swing.ButtonGroup();
    jLabel1 = new javax.swing.JLabel();
    cameraDevices = new javax.swing.JComboBox();
    audio = new javax.swing.JRadioButton();
    noaudio = new javax.swing.JRadioButton();
    timeLapse = new javax.swing.JRadioButton();
    start = new javax.swing.JButton();
    freq = new javax.swing.JComboBox();
    mono = new javax.swing.JRadioButton();
    stereo = new javax.swing.JRadioButton();
    seconds = new javax.swing.JSpinner();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    fps = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    audioDevices = new javax.swing.JComboBox();
    preview = new javax.swing.JCheckBox();
    previewVideo = new javax.swing.JLabel();
    previewAudio = new javax.swing.JProgressBar();
    jLabel5 = new javax.swing.JLabel();
    vBitRate = new javax.swing.JComboBox();
    jLabel6 = new javax.swing.JLabel();
    aBitRate = new javax.swing.JComboBox();
    jLabel7 = new javax.swing.JLabel();
    stopMotion = new javax.swing.JRadioButton();
    next = new javax.swing.JButton();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();

    jLabel1.setText("Camera Device");

    buttonGroup1.add(audio);
    audio.setSelected(true);
    audio.setText("Audio");

    buttonGroup1.add(noaudio);
    noaudio.setText("No Audio");

    buttonGroup1.add(timeLapse);
    timeLapse.setText("Time Lapse");

    start.setText("Start");
    start.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        startActionPerformed(evt);
      }
    });

    freq.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "44100", "22050", "11025", "8000" }));

    buttonGroup2.add(mono);
    mono.setSelected(true);
    mono.setText("mono");

    buttonGroup2.add(stereo);
    stereo.setText("stereo");

    seconds.setModel(new javax.swing.SpinnerNumberModel(60, 1, 3600, 1));

    jLabel2.setText("Seconds delay per frame");

    jLabel3.setText("FPS");

    fps.setModel(new javax.swing.SpinnerNumberModel(24, 1, 60, 1));

    jLabel4.setText("Audio Device");

    preview.setSelected(true);
    preview.setText("Preview");
    preview.setToolTipText("Preview (can reduce frame rate)");

    previewVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    previewVideo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

    previewAudio.setOrientation(1);
    previewAudio.setToolTipText("");

    jLabel5.setText("Video Quality");

    vBitRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "8M", "6M", "4M", "2M", "1M", "800k", "400k", "200k" }));
    vBitRate.setSelectedIndex(4);
    vBitRate.setToolTipText("");

    jLabel6.setText("Audio Quality");

    aBitRate.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "256k", "192k", "128k", "64k", "32k" }));
    aBitRate.setSelectedIndex(2);
    aBitRate.setToolTipText("");

    jLabel7.setText("Freq:");

    buttonGroup1.add(stopMotion);
    stopMotion.setText("Stop Motion (user advance frame)");

    next.setText("Next Frame");
    next.setEnabled(false);
    next.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        nextActionPerformed(evt);
      }
    });

    jLabel8.setText("bits/sec");

    jLabel9.setText("bits/sec");

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(aBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel9)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(start))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(jLabel4))
            .addGap(13, 13, 13)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(cameraDevices, 0, 206, Short.MAX_VALUE)
              .addComponent(audioDevices, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addComponent(audio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7))
              .addComponent(noaudio))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(mono)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(stereo))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(fps, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(stopMotion)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(next))
          .addGroup(layout.createSequentialGroup()
            .addComponent(timeLapse)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(seconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel2))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(vBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel8)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(preview)
          .addGroup(layout.createSequentialGroup()
            .addComponent(previewVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(previewAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(cameraDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(preview))
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(audioDevices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(fps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel3))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(audio)
              .addComponent(freq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(mono)
              .addComponent(stereo)
              .addComponent(jLabel7))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(noaudio)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(timeLapse)
              .addComponent(seconds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(next)
              .addComponent(stopMotion))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(vBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel8))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(aBitRate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(start)
              .addComponent(jLabel9))
            .addGap(5, 5, 5))
          .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(previewAudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(previewVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addContainerGap(12, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
    start();
  }//GEN-LAST:event_startActionPerformed

  private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
    synchronized(doNext) {
      doNext.notify();
    }
  }//GEN-LAST:event_nextActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JComboBox aBitRate;
  private javax.swing.JRadioButton audio;
  private javax.swing.JComboBox audioDevices;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.ButtonGroup buttonGroup2;
  private javax.swing.JComboBox cameraDevices;
  private javax.swing.JSpinner fps;
  private javax.swing.JComboBox freq;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JRadioButton mono;
  private javax.swing.JButton next;
  private javax.swing.JRadioButton noaudio;
  private javax.swing.JCheckBox preview;
  private javax.swing.JProgressBar previewAudio;
  private javax.swing.JLabel previewVideo;
  private javax.swing.JSpinner seconds;
  private javax.swing.JButton start;
  private javax.swing.JRadioButton stereo;
  private javax.swing.JRadioButton stopMotion;
  private javax.swing.JRadioButton timeLapse;
  private javax.swing.JComboBox vBitRate;
  // End of variables declaration//GEN-END:variables

  private Camera camera;
  private AudioInput mic;
  private RandomAccessFile raf;
  private boolean active = false;
  private boolean working = false;
  private Object doNext = new Object();

  public void listCameras() {
    camera = new Camera();
    camera.init();
    String list[] = camera.listDevices();
    camera.uninit();
    camera = null;
    cameraDevices.removeAllItems();
    for(int a=0;a<list.length;a++) {
      cameraDevices.addItem(list[a]);
    }
  }

  public void listAudioDevices() {
    mic = new AudioInput();
    String list[] = mic.listDevices();
    audioDevices.removeAllItems();
    for(int a=0;a<list.length;a++) {
      audioDevices.addItem(list[a]);
    }
  }

  public void setState(boolean state) {
    start.setEnabled(state);
    if (state) start.setText("Start");
    cameraDevices.setEnabled(state);
    audioDevices.setEnabled(state);
    audio.setEnabled(state);
    noaudio.setEnabled(state);
    timeLapse.setEnabled(state);
    seconds.setEnabled(state);
    mono.setEnabled(state);
    stereo.setEnabled(state);
    freq.setEnabled(state);
    fps.setEnabled(state);
    preview.setEnabled(state);
  }

  public void start() {
    if (working) {
      active = false;
      start.setText("Stopping");
      if (stopMotion.isSelected()) {
        synchronized(doNext) {
          doNext.notify();
        }
      }
      return;
    }
    working = true;
    setState(false);
    new Worker().start();
  }

  public void failed(String msg) {
    JF.showError("Error", msg);
    setState(true);
    working = false;
  }

  public int amplitude(short sams[]) {
    short peak = 0;
    int len = sams.length;
    for(int a=0;a<len;a++) {
      if (sams[a] > peak) peak = sams[a];
    }
    return (peak * 100) / 32768;
  }

  public void swapEndian(byte in[], short out[]) {
    int p = 0;
    for(int a=0;a<out.length;a++) {
      out[a] = in[p++];
      out[a] <<= 8;
      out[a] += in[p++] & 0xff;
    }
  }

  public class Worker extends Thread {
    public void run() {
      int idx = cameraDevices.getSelectedIndex();
      if (idx == -1) {
        failed("Please select a camera device");
        return;
      }
      setState(false);

      JFileChooser chooser = new JFileChooser();
      chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      chooser.setMultiSelectionEnabled(false);
      chooser.setCurrentDirectory(new File(JF.getUserPath() + "/Videos"));
      javax.swing.filechooser.FileFilter ffAVI = new javax.swing.filechooser.FileFilter() {
        public boolean accept(File file) {
          if (file.isDirectory()) return true;
          if (file.getName().endsWith(".avi")) return true;
          return false;
        }
        public String getDescription() {
          return "AVI (*.avi)";
        }
        public String toString() {
          return ".avi";
        }
      };
      chooser.addChoosableFileFilter(ffAVI);
      chooser.setFileFilter(ffAVI);
      if (chooser.showSaveDialog(MainPanel.this) != JFileChooser.APPROVE_OPTION) {
        setState(true);
        working = false;
        return;
      }
      String fn = chooser.getSelectedFile().getAbsolutePath();
      String fnlc = fn.toLowerCase();
      if ((!fnlc.endsWith(".avi"))) {
  //      javax.swing.filechooser.FileFilter ff = chooser.getFileFilter();
  //      fn += ff.toString();
        fn += ".avi";
      }
      boolean doAudio = audio.isSelected();
      int audioRate = JF.atoi((String)freq.getSelectedItem());
      if (audioRate < 8000 || audioRate > 44100) audioRate = 44100;
      int chs = mono.isSelected() ? 1 : 2;
      int frameRate = (Integer)fps.getValue();
      int secondsDelay = (Integer)seconds.getValue();
      int samples = audioRate * chs / frameRate;
      try {
        raf = new RandomAccessFile(fn, "rw");
        raf.setLength(0);
      } catch (Exception e) {
        JFLog.log(e);
        failed("Unable to create output file");
        return;
      }

      camera = new Camera();
      camera.init();
      camera.listDevices();
      if (!camera.start(cameraDevices.getSelectedIndex(), 640, 480)) {
        failed("Unable to start recording from camera");
        return;
      }

      MediaEncoder encoder = new MediaEncoder();
      encoder.setAudioBitRate(getAudioBitRate());
      encoder.setVideoBitRate(getVideoBitRate());
      int width = camera.getWidth();
      int height = camera.getHeight();
      JFLog.log("size=" + width + "," + height);
      JFLog.log("frameRate=" + frameRate);
      JFLog.log("audioRate=" + audioRate + ",chs=" + chs);
      if (!encoder.start(MainPanel.this, width, height, frameRate, chs
        , audioRate, "avi", true, doAudio))
      {
        failed("Unable to create output file");
        return;
      }
      if (doAudio) {
        mic = new AudioInput();
        if (!mic.start(chs, audioRate, 16, samples * 2, (String)audioDevices.getSelectedItem())) {
          failed("Unable to start recording audio");
          return;
        }
      }

      active = true;
      start.setText("Stop");
      start.setEnabled(true);
      byte sams8[] = new byte[samples*2];
      short sams16[] = new short[samples];
      boolean skip_frame = false;

      //sync video/audio
      boolean ready;
      do{
        ready = camera.getFrame() != null;
        if (doAudio) {
          while (mic.read(sams8)) {}
        }
      } while (active && !ready);

      double current = System.currentTimeMillis();
      double delay = 1000.0 / frameRate;
      int px[] = null;
      boolean doPreview = preview.isSelected();
      int previewWidth = previewVideo.getWidth();
      int previewHeight = previewVideo.getHeight();
      JFImage previewImg = new JFImage(previewWidth, previewHeight);
      JFImage videoImg = new JFImage(width, height);
      Icon orgPreview = previewVideo.getIcon();

      if (stopMotion.isSelected()) {
        next.setEnabled(true);
      }

      while (active) {
        if (!skip_frame) {
          px = camera.getFrame();
          if (px != null && doPreview) {
            videoImg.putPixels(px, 0,0,width,height,0);
            previewImg.putJFImageScale(videoImg, 0, 0, previewWidth, previewHeight);
            previewVideo.setIcon(previewImg);
            previewVideo.repaint();
          }
        } else {
          skip_frame = false;
        }
        if (px == null) {
          JFLog.log("no video frame:sleeping 5ms");
          JF.sleep(5);
          continue;
        }
        encoder.addVideo(px);
        if (doAudio) {
          while (mic.read(sams8)) {
            swapEndian(sams8, sams16);
            encoder.addAudio(sams16);
            if (doPreview) {
              previewAudio.setValue(amplitude(sams16));
            }
          }
        }
        if (stopMotion.isSelected()) {
          synchronized(doNext) {
            try {doNext.wait();} catch (Exception e) {}
          }
          continue;
        }
        if (timeLapse.isSelected()) {
          for(int a=0;a<secondsDelay;a++) {
            JF.sleep(1000);
            if (!active) break;
          }
        } else {
          double now = System.currentTimeMillis();
          int sleep = (int)(delay - (now - current));
          if (sleep > 0) {
            JF.sleep(sleep);
          } else {
            JFLog.log("sleep <= 0");
            skip_frame = true;  //system too slow
          }
          current += delay;
        }
      }
      encoder.stop();
      camera.stop();
      camera.uninit();
      camera = null;
      if (doAudio) mic.stop();
      try {
        raf.close();
      } catch (Exception e) {
        JFLog.log(e);
      }
      working = false;
      if (stopMotion.isSelected()) next.setEnabled(false);
      setState(true);
      previewVideo.setIcon(orgPreview);
      previewAudio.setValue(0);
    }
  }

  public int read(MediaCoder coder, byte[] bytes) {
    return 0;
  }

  public int write(MediaCoder coder, byte[] bytes) {
    try {
      raf.write(bytes);
      return bytes.length;
    } catch (Exception e) {
      JFLog.log(e);
      return 0;
    }
  }

  public long seek(MediaCoder coder, long pos, int how) {
    try {
      switch (how) {
        case MediaCoder.SEEK_SET: break;
        case MediaCoder.SEEK_CUR: pos += raf.getFilePointer(); break;
        case MediaCoder.SEEK_END: pos += raf.length(); break;
      }
      raf.seek(pos);
      return pos;
    } catch (Exception e) {
      JFLog.log(e);
    }
    return 0;
  }

  private int getRate(String rate) {
    int scale = 1;
    if (rate.endsWith("M")) {
      rate = rate.substring(0, rate.length()-1);
      scale = 1024 * 1024;
    }
    else if (rate.endsWith("k")) {
      rate = rate.substring(0, rate.length()-1);
      scale = 1024;
    }
    int value = JF.atoi(rate) * scale;
    System.out.println("rate=" + value);
    return value;
  }

  private int getAudioBitRate() {
    return getRate((String)aBitRate.getSelectedItem());
  }

  private int getVideoBitRate() {
    return getRate((String)vBitRate.getSelectedItem());
  }
}
