/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.path;

import java.io.File;

/**
 *
 * @author unclelu
 */
public class OutPath {
    
    private static String SignDir;
    private static String ApkDir;

    /**
     * @return the SignDir
     */
    public static String getSignDir() {
        SignDir = AdtPath.getUserDir() + "Sign" + File.separator;
        MkDir(SignDir);
        return SignDir;
    }

    /**
     * @return the ApkDir
     */
    public static String getApkDir() {
        ApkDir = AdtPath.getUserDir() + "Apk" + File.separator;
        MkDir(ApkDir);
        return ApkDir;
    }
    
    public static void MkDir(String dirPath) {
        File f = new File(dirPath);
        if (f.exists() == false) {
            f.mkdir();
        }
    }
}
