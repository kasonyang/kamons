package kamons.text.streamtable;
/**
 *
 * @author Kason Yang
 */
public class TableConfig {
    
    private boolean hasBorder;
    
    private int[] columnWidths;

    public TableConfig(boolean hasBorder, int[] columnWidths) {
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
