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
public class Sign extends ExecCommand {

    private String oldFile;
    private String newFile;

    public Sign(String oldFile, String newFile) {
        this.oldFile = oldFile;
        this.newFile = newFile;
    }

    public void signFile() {
        String[] cmd = {
            "java",
            "-jar",
            AdtPath.getSignApkFile(),
            AdtPath.getSignPemFile(),
            AdtPath.getSignPk8File(),
            oldFile,
            newFile
        };
        setCommand(cmd);
        exec();
    }
}
