package kamons.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Kason Yang
 */
public class LiteralParser {
    
    private Map<Character,String> escapeMap = new HashMap();
    
    public static LiteralParser createDefault(){
        LiteralParser p = new LiteralParser();
        p.addEscapeChar('\\', "\\");
        p.addEscapeChar('b', "\b");
        p.addEscapeChar('t', "\t");
        p.addEscapeChar('n', "\n");
        p.addEscapeChar('r', "\r");
        p.addEscapeChar('f', "\f");
        p.addEscapeChar('"', "\"");
        p.addEscapeChar('\'', "\'");
        return p;
    }
    
    private void addEscapeChar(char ch,String value){
        this.escapeMap.put(ch, value);
    }
    
    public char[] getSupportedEscapeChars(){
        Set<Character> ks = this.escapeMap.keySet();
        char[] res = new char[ks.size()];
        int i = 0;
        Iterator<Character> iterator = ks.iterator();
        while(iterator.hasNext()) res[i++] = iterator.next();
        return res;
    }

    public String parse(String literal) {
        //TODO parse unicode
        char[] chars = literal.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            char c = chars[i++];
            if (c == '\\') {
                if(i>=chars.length){
                    throw new InvalidLiteralFormat("illegal end of string literal");
                }
                char nextChar = chars[i++];
                String value = escapeMap.get(nextChar);
                if(value==null){
                    throw new InvalidLiteralFormat("illegal escape character \\" + nextChar);
                }
                sb.append(value);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
