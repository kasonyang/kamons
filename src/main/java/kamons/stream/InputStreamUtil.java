package kamons.stream;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 *
 * @author Kason Yang
 */
public class InputStreamUtil {
    
    public static String readAsString(InputStream is,String charset) throws IOException{
        return readAsString(is, Charset.forName(charset));
    }
    
    public static String readAsString(InputStream is,Charset charset) throws IOException{
        InputStreamReader isr = new InputStreamReader(is,charset);
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[4096];
        int rlen;
        while((rlen=isr.read(buffer))>=0){
            sb.append(buffer, 0, rlen);
        }
        return sb.toString();
    }

}
