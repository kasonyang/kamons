package test;

import kamons.binary.BinaryUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang
 */
public class BinaryUtilTest {
    
    public BinaryUtilTest() {
    }
    
    @Test
    public void test(){
        int[] ints = {1,2,3,233,666};
        for(int i:ints) testInt(i);
        int[] ushorts = {1,2,3,666,Short.MAX_VALUE+100};
        for(int i:ushorts) testUnsignShort(i);
    }
    
    
    private void testInt(int value){
        byte[] buffer = new byte[4];
        BinaryUtil.writeInt(buffer, 0, value);
        int tmp = BinaryUtil.readInt(buffer, 0);
        assertEquals(value, tmp);
    }
    
    private void testUnsignShort(int value){
        byte[] buffer = new byte[2];
        BinaryUtil.writeUnsignShort(buffer, 0, value);
        int tmp = BinaryUtil.readUnsignShort(buffer, 0);
        assertEquals(value, tmp);
    }
    
}
