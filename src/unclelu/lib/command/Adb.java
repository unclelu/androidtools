/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.command;

import unclelu.lib.path.AdtPath;

/**
 *
 * @author ZYJ
 */
public class Adb extends ExecCommand implements Runnable {

    public static final int REBOOT = 0;
    public static final int BOOTLOADER = 1;
    public static final int RECOVERY = 2;

    public void start() {
        String[] cmd = {AdtPath.getAdbFile(), "start-server"};
        setCommand(cmd);
        exec();
    }

    public void install(String apkFile) {
        String[] cmd = {AdtPath.getAdbFile(), "install", apkFile};
        setCommand(cmd);
        exec();
    }

    public void unInstall(String apkName) {
        String[] cmd = {AdtPath.getAdbFile(), "uninstall", apkName};
        setCommand(cmd);
        exec();
    }

    public void reboot(int op) {
        String opstr;
        if (op == REBOOT) {
            opstr = "";
        } else if (op == RECOVERY) {
            opstr = "recovery";
        } else {
            opstr = "bootloader";
        }
        String[] cmd = {AdtPath.getAdbFile(), "reboot", opstr};
        setCommand(cmd);
        exec();
    }

    @Override
    public void run() {
        start(); //To change body of generated methods, choose Tools | Templates.
    }
}
