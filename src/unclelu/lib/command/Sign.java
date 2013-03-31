/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.command;

import javax.swing.JOptionPane;
import unclelu.lib.path.AdtPath;
import unclelu.lib.path.FilePath;
import unclelu.lib.path.OutPath;

/**
 *
 * @author ZYJ
 */
public class Sign extends ExecCommand {

    private String oldFile;
    private String newFile;

    public Sign() {
        OutPath.MkDir(OutPath.getSignDir());
    }

    public void setAutoNewFile() {
        String oldFile = getOldFile();
        String newFile_q = FilePath.getFileName(oldFile, FilePath.NotExtension);
        String newFile_h = FilePath.getFileName(oldFile, FilePath.Extension);
        String newFile = OutPath.getSignDir() + newFile_q + "_sign" + newFile_h;
        setNewFile(newFile);
    }

    public void signFile() {
        String[] cmd = {
            "java",
            "-jar",
            AdtPath.getSignApkFile(),
            AdtPath.getSignPemFile(),
            AdtPath.getSignPk8File(), getOldFile(), getNewFile()};
        setCommand(cmd);
        exec();
        if (getResultErr().isEmpty()) {
            JOptionPane.showMessageDialog(null, "签名完毕");
        } else {
            JOptionPane.showMessageDialog(null, "签名失败");
        }

    }

    /**
     * @return the oldFile
     */
    public String getOldFile() {
        return oldFile;
    }

    /**
     * @param oldFile the oldFile to set
     */
    public void setOldFile(String oldFile) {
        this.oldFile = oldFile;
    }

    /**
     * @return the newFile
     */
    public String getNewFile() {
        return newFile;
    }

    /**
     * @param newFile the newFile to set
     */
    public void setNewFile(String newFile) {
        this.newFile = newFile;
    }
}
