/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.path;

import java.io.File;

/**
 *
 * @author ZYJ
 */
public class AdtPath {

    private static String UserDir;
    private static String OsName;
    private static String ToolDir;
    //ADB
    private static String AdbDir;
    private static String AdbFile;
    //download
    private static String DownloadDir;
    //signapk
    private static String SignDir;
    private static String SignApkFile;
    private static String SignPk8File;
    private static String SignPemFile;
    //apktool
    private static String ApktoolDir;
    private static String ApktoolFile;
    private static String ApkAaptFile;

    /**
     * @return 返回用户当前目录
     */
    public static String getUserDir() {
        UserDir = System.getProperty("user.dir") + File.separator;
        return UserDir;
    }

    /**
     * @return 返回系统名称
     */
    public static String getOsName() {
        OsName = System.getProperty("os.name");
        if (OsName.toLowerCase().contains("windows")) {
            OsName = "windows";
        } else {
            OsName = "linux";
        }
        return OsName;
    }

    /**
     * @return 返回工具文件目录
     */
    public static String getToolDir() {
        ToolDir = getUserDir() + "tools" + File.separator;
        return ToolDir;
    }

    /**
     * @return 返回adb目录
     */
    public static String getAdbDir() {
        AdbDir = getToolDir() + "adb" + File.separator;
        return AdbDir;
    }

    /**
     * @return 返回adb执行文件路径
     */
    public static String getAdbFile() {
        String filename;
        if (getOsName().toLowerCase().equals("linux")) {
            filename = "adb";
        } else {
            filename = "adb.exe";
        }
        AdbFile = getAdbDir() + filename;
        return AdbFile;
    }

    /**
     * @return 返回下载目录
     */
    public static String getDownloadDir() {
        DownloadDir = getUserDir() + "download" + File.separator;
        return DownloadDir;
    }

    /**
     * @return the SignApkFile
     */
    public static String getSignApkFile() {
        SignApkFile = getSignDir() + "signapk.jar";
        return SignApkFile;
    }

    /**
     * @return the SignPk8File
     */
    public static String getSignPk8File() {
        SignPk8File = getSignDir() + "testkey.pk8";
        return SignPk8File;
    }

    /**
     * @return the SignPemFile
     */
    public static String getSignPemFile() {
        SignPemFile = getSignDir() + "testkey.x509.pem";
        return SignPemFile;
    }

    /**
     * @return the SignDir
     */
    public static String getSignDir() {
        SignDir = getToolDir() + "signapk" + File.separator;
        return SignDir;
    }

    /**
     * @return the ApktoolDir
     */
    public static String getApktoolDir() {
        ApktoolDir = getToolDir() + "apktool" + File.separator;
        return ApktoolDir;
    }

    /**
     * @return the ApktoolFile
     */
    public static String getApktoolFile() {
        ApktoolFile = getApktoolDir() + "apktool.jar";
        return ApktoolFile;
    }

    /**
     * @return the ApkAaptFile
     */
    public static String getApkAaptFile() {
        if (getOsName().equals("windows") == false) {
            ApkAaptFile = getApktoolDir() + "aapt";
        } else {
            ApkAaptFile = getApktoolDir() + "aapt.exe";
        }
        return ApkAaptFile;
    }
}
