package kamons.text.streamtable;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kason Yang
 */
public class TextStreamTableWriter {
    
    private OutputStream os;
    
    private TableConfig config;
    
    private Charset charset;

    public TextStreamTableWriter(OutputStream os, TableConfig config) {
        this(os,config,Charset.defaultCharset());
    }
    
    public TextStreamTableWriter(OutputStream os, TableConfig config,String charset) {
        this(os,config,Charset.forName(charset));
    }

    public TextStreamTableWriter(OutputStream os,TableConfig config,Charset charset) {
        this.os = os;
        this.config = config;
        this.charset = charset;
    }
    
    private void printLeftRowBorder() throws IOException{
        String text = config.hasBorder() ? " | " : "   ";
        os.write(text.getBytes(charset));
    }
    
    private void printMiddleRowBorder() throws IOException{
        this.printLeftRowBorder();
    }
    
    private void printRightRowBorder() throws IOException{
        this.printLeftRowBorder();
    }
    
    public void printRow(String... columns) throws IOException{
        int[] widths = config.getColumnWidths();
        StringBuilder[] sbs = new StringBuilder[widths.length];
        for(int i=0;i<widths.length;i++){
            sbs[i] =new StringBuilder( columns.length > i ? columns[i] : "");
        }
        boolean empty = false;
        while(!empty){
            empty =true;
            this.printLeftRowBorder();
            for(int i=0;i<sbs.length;i++){
                if(i>0) this.printMiddleRowBorder();
                int textWidth = sbs[i].toString().getBytes("utf-8").length;
                int columnWidth = widths[i];
                int deleteLen = Math.min( textWidth, columnWidth);
                int charCount = sbs[i].codePointCount(0, deleteLen);
                byte[] suffix =new byte[columnWidth > textWidth ? columnWidth - textWidth : 0];
                for(int j=0;j<suffix.length;j++) suffix[j] = ' ';
                String text = sbs[i].substring(0, charCount);
                sbs[i].delete(0, charCount);
                if(sbs[i].length()>0) empty = false;
                os.write(text.getBytes(charset));
                if(suffix.length>0) os.write(suffix);
            }
            this.printRightRowBorder();
            os.write('\n');
        }
    }
    
}
