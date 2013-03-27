/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unclelu.lib.command;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZYJ
 */
public class ExecCommand {

    private String[] command;
    private List<String> resultErr;
    private List<String> result;

    public ExecCommand() {
        result = new ArrayList<String>();
        resultErr = new ArrayList<String>();
    }

    /**
     * @param command the command to set
     */
    public void setCommand(String[] command) {
        this.command = command;
    }

    public void exec() {
        try {
            Process process = Runtime.getRuntime().exec(command);
            InputStream isEr = process.getErrorStream();
            InputStreamReader isrEr = new InputStreamReader(isEr);
            BufferedReader brEr = new BufferedReader(isrEr);

            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = brEr.readLine()) != null) {
                getResultErr().add(line);
                System.out.println(line);
            }
            while ((line = br.readLine()) != null) {
                getResult().add(line);
                System.out.println(line);
            }
            br.close();
            brEr.close();
            //process.destroy();
        } catch (Exception e) {
            getResultErr().add(e.getMessage());
            e.printStackTrace();
        }

    }

    /**
     * @return the resultErr
     */
    public List<String> getResultErr() {
        return resultErr;
    }

    /**
     * @return the result
     */
    public List<String> getResult() {
        return result;
    }
}
