
import unclelu.lib.path.AdtPath;
import unclelu.lib.path.FilePath;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZYJ
 */
public class Test {

    public static void main(String[] args) {
        String a = FilePath.getFileName(AdtPath.getAdbFile()+".exe", FilePath.Extension);
        System.out.println(a);
    }
}
