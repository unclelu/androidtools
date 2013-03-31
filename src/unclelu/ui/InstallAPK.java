/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.ui;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import unclelu.lib.command.Adb;
import unclelu.lib.path.AdtPath;

/**
 *
 * @author ZYJ
 */
public class InstallAPK extends javax.swing.JDialog {

    /**
     * Creates new form InstallAPK
     */
    public InstallAPK(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApkDir = new javax.swing.JTextField();
        btnOpenDir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listApk = new javax.swing.JList();
        btnInstallAll = new javax.swing.JButton();
        btnInstall = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("安装APK");

        jLabel1.setText("指定APK目录:");

        btnOpenDir.setText("...");
        btnOpenDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenDirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listApk);

        btnInstallAll.setText("安装全部APK");
        btnInstallAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstallAllActionPerformed(evt);
            }
        });

        btnInstall.setText("安装选中APK");
        btnInstall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInstallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApkDir, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOpenDir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInstall)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnInstallAll)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtApkDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOpenDir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInstallAll)
                    .addComponent(btnInstall))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpenDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenDirActionPerformed
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("请选择APK目录");
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jfc.setCurrentDirectory(new File(AdtPath.getUserDir()));
        jfc.showOpenDialog(null);
        if (jfc.getSelectedFile() == null) {
            return;
        }
        txtApkDir.setText(jfc.getSelectedFile().getAbsolutePath());
        scanDir(txtApkDir.getText());
    }//GEN-LAST:event_btnOpenDirActionPerformed

    private void btnInstallAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstallAllActionPerformed
        if (listApk.getModel().getSize() == 0) {
            JOptionPane.showMessageDialog(rootPane, "no file");
            return;
        }
        for (int i = 0; i < listApk.getModel().getSize(); i++) {
            Adb adb = new Adb();
            adb.install(listApk.getModel().getElementAt(i).toString());
        }
    }//GEN-LAST:event_btnInstallAllActionPerformed

    private void btnInstallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInstallActionPerformed
        if (listApk.getSelectedIndices().length == 0) {
            return;
        }
        for (int i = 0; i < listApk.getSelectedIndices().length; i++) {
            int index = listApk.getSelectedIndices()[i];
            Adb adb = new Adb();
            adb.install(listApk.getModel().getElementAt(index).toString());
        }
    }//GEN-LAST:event_btnInstallActionPerformed

    private void scanDir(String dir) {
        File d = new File(dir);
        if (d.isDirectory() == false) {
            return;
        }
        File[] list = d.listFiles(new java.io.FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().toLowerCase().endsWith(".apk")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        ArrayList<String> pathList = new ArrayList<String>();
        for (File f : list) {
            pathList.add(f.getAbsolutePath());
        }
        listApk.setListData(pathList.toArray());
    }

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
            java.util.logging.Logger.getLogger(InstallAPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstallAPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstallAPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstallAPK.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InstallAPK dialog = new InstallAPK(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInstall;
    private javax.swing.JButton btnInstallAll;
    private javax.swing.JButton btnOpenDir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listApk;
    private javax.swing.JTextField txtApkDir;
    // End of variables declaration//GEN-END:variables
}
