package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import kamons.text.table.TextTableConfig;
import kamons.text.table.TextTableWriter;
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
        TextTableConfig config = new TextTableConfig(false, new int[]{4,4,4});
        TextTableWriter writer  = new TextTableWriter(os, config,"utf-8");
        writer.printRow("a","b","c");
        assertEquals("   a      b      c      \n", os.toString());
        
        os.reset();
        writer.printRow("abcde","b","c");
        assertEquals("   abcd   b      c      \n   e                    \n", os.toString());
        
    }
    
}
