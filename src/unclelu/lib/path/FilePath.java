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
public class FilePath {

    public static final int FullName = 0;
    public static final int NotExtension = 1;
    public static final int Extension = 2;

    public static String getFileName(String filePath, int status) {
        File f = new File(filePath);
        String name = f.getName();
        if (status == NotExtension) {
            name = name.substring(0, name.lastIndexOf("."));
        } else if (status == Extension) {
            name = name.substring(name.lastIndexOf("."), name.length());
        }
        return name;
    }
}
