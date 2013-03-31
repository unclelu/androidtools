/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.command;

import java.io.File;
import javax.swing.JOptionPane;
import unclelu.lib.path.AdtPath;
import unclelu.lib.path.FilePath;
import unclelu.lib.path.OutPath;

/**
 *
 * @author ZYJ
 */
public class Apktool extends ExecCommand {

    private String apkFile;
    private boolean isSign;
    public static final int Decompile = 0;
    public static final int Compile = 1;

    public Apktool(String apkFile) {
        this.apkFile = apkFile;
        isSign = false;
    }

    /**
     * @return the apkFile
     */
    public String getApkFile() {
        return apkFile;
    }

    /**
     * @param apkFile the apkFile to set
     */
    public void setApkFile(String apkFile) {
        this.apkFile = apkFile;
    }

    /**
     * @return the isSign
     */
    public boolean isIsSign() {
        return isSign;
    }

    /**
     * @param isSign the isSign to set
     */
    public void setIsSign(boolean isSign) {
        this.isSign = isSign;
    }

    private String getApkCodeDir() {
        String dirName = FilePath.getFileName(this.apkFile, FilePath.NotExtension);
        String dirPath = OutPath.getApkDir() + dirName + File.separator;
        return dirPath;
    }

    private String getDecompileApkPath() {
        String file = getApkCodeDir() + "dist" + File.separator + FilePath.getFileName(this.apkFile, FilePath.FullName);
        return file;
    }

    public void deCompile() {
        String[] cmd = {"java", "-jar", AdtPath.getApktoolFile(), "d", this.apkFile, getApkCodeDir()};
        setCommand(cmd);
        exec();
        if (!getResultErr().isEmpty()) {
            JOptionPane.showMessageDialog(null, "反编译文件完毕");
        } else {
            JOptionPane.showMessageDialog(null, "反编译失败");
        }
    }

    public void compile() {
        //String apk=getDecompileApkPath();
        String[] cmd = {"java", "-jar", AdtPath.getApktoolFile(), "b", getApkCodeDir()};
        setCommand(cmd);
        exec();
        if (!getResultErr().isEmpty()) {
            JOptionPane.showMessageDialog(null, "回编译成功");
            if (this.isSign) {
                Sign s = new Sign();
                s.setOldFile(getDecompileApkPath());
                s.setAutoNewFile();
                s.signFile();
            }
        } else {
            JOptionPane.showMessageDialog(null, "回编译失败");
        }
    }

    public void importFramework() {
        String[] cmd = {"java", "-jar", AdtPath.getApktoolFile(), "if", this.apkFile};
        setCommand(cmd);
        exec();
        if (!getResultErr().isEmpty()) {
            JOptionPane.showMessageDialog(null, "框架导入成功");
        } else {
            JOptionPane.showMessageDialog(null, "框架导入失败");
        }
    }
}
