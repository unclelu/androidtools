/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib;

/**
 *
 * @author ZYJ
 */
public class SystemInfo {

    private static String systemName;
    private static String systemArch;
    private static String systemVersion;

    /**
     * @return the systemName
     */
    public static String getSystemName() {
        systemName = System.getProperty("os.name");
        return systemName;
    }

    /**
     * @return the systemArch
     */
    public static String getSystemArch() {
        systemArch = System.getProperty("os.arch");
        return systemArch;
    }

    /**
     * @return the systemVersion
     */
    public static String getSystemVersion() {
        systemVersion = System.getProperty("os.version");
        return systemVersion;
    }
}
