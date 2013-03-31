
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
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
        Map m = System.getenv();
        for (Iterator it = m.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            String value = (String) m.get(key);
            System.out.println(key + ":" + value);
        }
        System.out.println("--------------------------------------");
        Properties p = System.getProperties();

        for (Iterator it = p.keySet().iterator(); it.hasNext();) {
            String key = (String) it.next();
            String value = (String) p.get(key);
            System.out.println(key + ":" + value);
        }
    }
}
