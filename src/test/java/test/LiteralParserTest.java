package test;

import kamons.string.LiteralParser;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang
 */
public class LiteralParserTest {
    
    public LiteralParserTest() {
    }
    
    @Test
    public void test(){
        String literal = "\\b\\t\\n\\f\\r\\\"\\\'\\\\";
        String str = "\b\t\n\f\r\"\'\\";
        LiteralParser parser = LiteralParser.createDefault();
        assertEquals(str, parser.parse(literal));
    }
    
}
