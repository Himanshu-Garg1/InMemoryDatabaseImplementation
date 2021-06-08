import java.util.Date;
import java.util.HashMap;

public class Row {

    String rowid;
    HashMap<String,String>columnMaps;
    Date createdDate;
    Date updateDate;

    public Row(String rowid, HashMap<String, String> columnMaps, Date createdDate, Date updateDate) {
        this.rowid = rowid;
        this.columnMaps = columnMaps;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }


    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public HashMap<String, String> getColumnMaps() {
        return columnMaps;
    }

    public void setColumnMaps(HashMap<String, String> columnMaps) {
        this.columnMaps = columnMaps;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public void insertColumnValues(String key, String value)
    {
        ColumnValidation columnValidation= new ColumnValidation();
        if(columnValidation.validateColumn(value))
        {
            columnMaps.put(key,value);
            return;
        }
        else
        {
            System.out.println("Validation Failed");
        }

    }
    public void insertColumnValues(String key, int value)
    {
        ColumnValidation columnValidation= new ColumnValidation();
        if(columnValidation.validateColumn(value))
        {
            columnMaps.put(key,String.valueOf(value));
            return;
        }
        else
        {
            System.out.println("Validation Failed");
        }

    }

}
