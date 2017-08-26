package kamons.binary;

/**
 *
 * @author Kason Yang
 */
public class BinaryUtil {

    public static int readInt(byte[] buffer, int offset) {
        return ((0xFF & buffer[offset]) << 24)
                | ((0xFF & buffer[offset + 1]) << 16)
                | ((0xFF & buffer[offset + 2]) << 8)
                | (0xFF & buffer[offset + 3]);
    }

    public static void writeInt(byte[] buffer, int offset, int len) {
        buffer[offset] = (byte) ((len & 0xFF000000) >>> 24);
        buffer[offset + 1] = (byte) ((len & 0xFF0000) >>> 16);
        buffer[offset + 2] = (byte) ((len & 0xFF00) >>> 8);
        buffer[offset + 3] = (byte) (len & 0xFF);
    }

    public static int readUnsignShort(byte[] buffer, int offset) {
        return ((0xFF & buffer[offset]) << 8)
                | ((0xFF & buffer[offset + 1]));
    }

    public static void writeUnsignShort(byte[] buffer, int offset, int value) {
        buffer[offset] = (byte) ((value & 0xFF00) >>> 8);
        buffer[offset + 1] = (byte) ((value & 0xFF));
    }

}
