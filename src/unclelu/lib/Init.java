/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib;

import java.io.File;
import unclelu.lib.path.AdtPath;

/**
 *
 * @author ZYJ
 */
public class Init {

    public static void init() {
        mkDownloadDir();
        chmodAdbFile();
    }
    
    private static void mkDownloadDir(){
        File f = new File(AdtPath.getDownloadDir());
        if (f.exists() == false) {
            f.mkdir();
        }
    }
    
    private static void chmodAdbFile(){
        if(AdtPath.getOsName().equals("linux")){
            String adbFilePath=AdtPath.getAdbFile();
            File f=new File(adbFilePath);
            if(f.canExecute()==false)
                f.setExecutable(true);
            if(f.canRead()==false)
                f.setReadable(true);
            if(f.canWrite()==false)
                f.setWritable(true);
        }
    }
}
