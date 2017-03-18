package kamons.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 *
 * @author Kason Yang
 */
public class StatusBar {

    private int statusCharCount = 0;

    private String statusText;

    public void output(String content) {
        this.clearStatus();
        print(content);
        status(statusText);
    }

    public void clearStatus() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < statusCharCount; i++) {
            sb.append("\b");
        }
        print(sb.toString());
    }

    private void print(String content) {
        System.out.print(content);
    }

    public void status(String content) {
        this.clearStatus();
        try {
            StringReader sr = new StringReader(content);
            BufferedReader br = new BufferedReader(sr);
            statusText = br.readLine();
            print(statusText);
            this.statusCharCount = statusText.length();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
