/**
 *
 * @author pquiring
 */

import javaforce.gl.*;

public class CreateCubePanel extends javax.swing.JPanel implements Runnable {

  /**
   * Creates new form CreateCubePanel
   */
  public CreateCubePanel(CreatePanel parent) {
    initComponents();
    this.parent = parent;
    create();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    fSize = new javax.swing.JSpinner();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    fX = new javax.swing.JSpinner();
    jLabel3 = new javax.swing.JLabel();
    fY = new javax.swing.JSpinner();
    jLabel4 = new javax.swing.JLabel();
    fZ = new javax.swing.JSpinner();
    jButton1 = new javax.swing.JButton();

    fSize.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(1.0f), null, null, Float.valueOf(0.1f)));

    jLabel1.setText("Size");

    jLabel2.setText("X");

    jLabel3.setText("Y");

    jLabel4.setText("Z");

    jButton1.setText("Done");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2)
              .addComponent(jLabel3)
              .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(fZ, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
              .addComponent(fY)
              .addComponent(fX)
              .addComponent(fSize)))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(jButton1)))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(fSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(fX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel3)
          .addComponent(fY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel4)
          .addComponent(fZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
        .addComponent(jButton1)
        .addContainerGap())
    );
  }// </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    parent.finish();
  }//GEN-LAST:event_jButton1ActionPerformed


  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JSpinner fSize;
  private javax.swing.JSpinner fX;
  private javax.swing.JSpinner fY;
  private javax.swing.JSpinner fZ;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  // End of variables declaration//GEN-END:variables

  private CreatePanel parent;

  private float _xyz[][] = {
    { 1, 1, 1},
    {-1, 1, 1},
    {-1,-1, 1},
    { 1,-1, 1},
    { 1, 1,-1},
    {-1, 1,-1},
    {-1,-1,-1},
    { 1,-1,-1},
  };

  private int pts[] = {
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
    0,0,0,
  };

  private void create() {
    //create cube with default settings
    GLObject obj = new GLObject();
    float xyz[][] = new float[3][8];
    float uv[][] = new float[2][8];

    int size = (Integer)fSize.getValue();
    float x = (Float)fX.getValue();
    float y = (Float)fY.getValue();
    float z = (Float)fZ.getValue();

    for(int a=0;a<8;a++) {
      for(int b=0;b<3;b++) {
        xyz[a][b] = _xyz[a][b] * size;
      }
      obj.addVertex(xyz[a], uv[a]);
    }
    obj.addPoly(pts);
  }

  public void run() {
    //nothing to do, just close panel
  }
}
