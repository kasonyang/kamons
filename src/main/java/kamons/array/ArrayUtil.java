package kamons.array;

/**
 *
 * @author Kason Yang
 */
public class ArrayUtil {

    public static int[] toInts(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        int[] res = new int[bytes.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = bytes[i];
        }
        return res;
    }

    public static int[] toInts(char[] chars) {
        if (chars == null) {
            return null;
        }
        int[] res = new int[chars.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = chars[i];
        }
        return res;
    }

    public static int[] toInts(Integer[] ints) {
        if (ints == null) {
            return null;
        }
        int[] res = new int[ints.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = ints[i];
        }
        return res;
    }

    public static long[] toLongs(byte[] bytes) {
        if (bytes == null) {
            return null;
        }
        long[] res = new long[bytes.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = bytes[i];
        }
        return res;
    }

    public static long[] toLongs(int[] ints) {
        if (ints == null) {
            return null;
        }
        long[] res = new long[ints.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = ints[i];
        }
        return res;
    }

    public static long[] toLongs(Long[] longs) {
        if (longs == null) {
            return null;
        }
        long[] res = new long[longs.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = longs[i];
        }
        return res;
    }

}
