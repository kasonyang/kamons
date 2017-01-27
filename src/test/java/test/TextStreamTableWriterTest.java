package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kamons.text.streamtable.TableConfig;
import kamons.text.streamtable.TextStreamTableWriter;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang
 */
public class TextStreamTableWriterTest {
    
    public TextStreamTableWriterTest() {
    }
    
    @Test
    public void test() throws IOException{
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        TableConfig config = new TableConfig(false, new int[]{4,4,4});
        TextStreamTableWriter writer  = new TextStreamTableWriter(os, config,"utf-8");
        writer.printRow("a","b","c");
        assertEquals("   a      b      c      \n", os.toString());
        
        os.reset();
        writer.printRow("abcde","b","c");
        assertEquals("   abcd   b      c      \n   e                    \n", os.toString());
        
    }
    
}
