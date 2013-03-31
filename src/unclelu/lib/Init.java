/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;
import unclelu.lib.command.ExecCommand;
import unclelu.lib.path.AdtPath;

/**
 *
 * @author ZYJ
 */
public class Init {

    public static void init() {
        mkDownloadDir();
        chmodAdbFile();
        copyAaptFile();
    }

    private static void mkDownloadDir() {
        File f = new File(AdtPath.getDownloadDir());
        if (f.exists() == false) {
            f.mkdir();
        }
    }

    private static void chmodAdbFile() {
        if (AdtPath.getOsName().equals("linux")) {
            String adbFilePath = AdtPath.getAdbFile();
            File f = new File(adbFilePath);
            if (f.canExecute() == false) {
                f.setExecutable(true);
            }
            if (f.canRead() == false) {
                f.setReadable(true);
            }
            if (f.canWrite() == false) {
                f.setWritable(true);
            }
        }
    }

    private static void copyAaptFile() {
        String path = null;
        if (AdtPath.getOsName().equals("linux")) {
            path = "/usr/local/bin/aapt";
        } else {
            path = System.getenv("windir") + File.separator + "aapt.exe";
        }
        File f = new File(path);
        if (f.exists() == false) {
            copyFile(new File(AdtPath.getApkAaptFile()), new File(path));
            f.setExecutable(true);
            f.setReadable(true);
            f.setWritable(true);
            if (AdtPath.getOsName().equals("linux")) {
                if (f.exists() == false) {
                    JOptionPane.showMessageDialog(null, "拷贝文件失败\nlinux系统下第一次运行程序请使用root账户\n或手动将/tools/apktool/aapt文件拷贝至系统目录中\n否则将无法回编译apk");
                }
                ExecCommand ec = new ExecCommand();
                String[] cmd = {"chmod", "777", path};
                ec.setCommand(cmd);
                ec.exec();
            }
        }
    }

    public static void copyFile(File sourceFile, File targetFile) {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));

            // 新建文件输出流并对它进行缓冲
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024 * 5];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            // 刷新此缓冲的输出流
            outBuff.flush();
            inBuff.close();
            outBuff.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
