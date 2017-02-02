package kamons.classpath;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import kamons.stream.InputStreamUtil;

/**
 *
 * @author Kason Yang
 */
public class ResourceUtil {
    
    public static String  readAsString(ClassLoader classLoader,String resourceName,String charset) throws IOException{
        return readAsString(classLoader, resourceName,Charset.forName(charset));
    }
    
    public static String  readAsString(ClassLoader classLoader,String resourceName,Charset charset) throws IOException{
        InputStream is = classLoader.getResourceAsStream(resourceName);
        if(is!=null) return InputStreamUtil.readAsString(is, charset);
        return null;
    }
    
}
