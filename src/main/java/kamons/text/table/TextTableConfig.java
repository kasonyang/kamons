package kamons.text.table;
/**
 *
 * @author Kason Yang
 */
public class TextTableConfig {
    
    private boolean hasBorder;
    
    private int[] columnWidths;

    public TextTableConfig(boolean hasBorder, int[] columnWidths) {
        this.hasBorder = hasBorder;
        this.columnWidths = columnWidths;
    }

    public boolean hasBorder() {
        return hasBorder;
    }

    public void setHasBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
    }

    public int[] getColumnWidths() {
        return columnWidths;
    }

    public void setColumnWidths(int[] columnWidths) {
        this.columnWidths = columnWidths;
    }

}
