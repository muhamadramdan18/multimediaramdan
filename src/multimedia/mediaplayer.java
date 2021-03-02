package multimedia;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class mediaplayer extends javax.swing.JFrame {
    long total_length;
    long pause;
    FileInputStream FIS;
    BufferedInputStream BIS;
    Player player;
    
    File myFile = null;
    private long total_length_pause;
    
    public mediaplayer() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_play = new javax.swing.JButton();
        btn_pause = new javax.swing.JButton();
        btn_resume = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btn_stop = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        lbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(getForeground());

        btn_play.setText("Play");
        btn_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_playMouseReleased(evt);
            }
        });
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        btn_pause.setText("Pause");
        btn_pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_pauseMouseReleased(evt);
            }
        });

        btn_resume.setText("Resume");
        btn_resume.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_resumeMouseReleased(evt);
            }
        });

        btn_stop.setText("Stop");
        btn_stop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btn_stopMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btn_play)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_pause)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_resume)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_stop)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_play)
                    .addComponent(btn_pause)
                    .addComponent(btn_resume)
                    .addComponent(btn_stop))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_playMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_playMouseReleased
    JFileChooser chooser = new JFileChooser();
    int val = chooser.showOpenDialog(null);
    if(val == JFileChooser.APPROVE_OPTION)
    {
        myFile = chooser.getSelectedFile();
        String song = myFile+"";
        
        String name = chooser.getSelectedFile().getName();
        lbl.setText(name);
    }
        try {
        FIS = new FileInputStream(myFile);
        BIS = new BufferedInputStream(FIS);
        player = new Player (BIS);
        total_length= FIS.available();
        
        new Thread()
        {
            public void run()
            {
                try{
                    player.play();
                }catch(JavaLayerException ex){
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }.start();
        }catch(IOException ex){
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch(JavaLayerException ex){
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btn_playMouseReleased

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_playActionPerformed
    
    }//GEN-LAST:event_btn_playActionPerformed

    private void btn_pauseMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_pauseMouseReleased
        if(player !=null)
        {
            try{
                pause = FIS.available();
                player.close();
            } catch(IOException ex){
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_pauseMouseReleased

    private void btn_resumeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_resumeMouseReleased
    try {
        FIS = new FileInputStream(myFile);
        BIS = new BufferedInputStream(FIS);
        player = new Player (BIS);
        FIS.skip(total_length-pause);
        new Thread()
        {
            public void run()
            {
                try{
                    player.play();
                }catch(JavaLayerException ex){
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            }.start();
        }catch(IOException ex){
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch(JavaLayerException ex){
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    }//GEN-LAST:event_btn_resumeMouseReleased

    private void btn_stopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_stopMouseReleased
    if(player != null)
    {
        player.close();
        lbl.setText(null);
    }
    }//GEN-LAST:event_btn_stopMouseReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mediaplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mediaplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mediaplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mediaplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mediaplayer().setVisible(true);
                new MainFrame().setVisible(true);
            }
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_pause;
    private javax.swing.JButton btn_play;
    private javax.swing.JButton btn_resume;
    private javax.swing.JButton btn_stop;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl;
    // End of variables declaration//GEN-END:variables

    private static class MainFrame {

        public MainFrame() {
        }

        private void setVisible(boolean b) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
