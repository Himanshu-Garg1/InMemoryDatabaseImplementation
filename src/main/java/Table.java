import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Table {
    String tableName;
    HashMap<String,Row> rowValues;
    ArrayList<String> mandatoryFields;
    Date createdDate;
    HashMap<String,Integer> tableSchema;

    public Table(String tableName, HashMap<String, Row> rowValues, ArrayList<String> mandatoryFields, Date createdDate, HashMap<String, Integer> tableSchema) {
        this.tableName = tableName;
        this.rowValues = rowValues;
        this.mandatoryFields = mandatoryFields;
        this.createdDate = createdDate;
        this.tableSchema = tableSchema;
    }


    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public HashMap<String, Row> getRowValues() {
        return rowValues;
    }

    public void setRowValues(HashMap<String, Row> rowValues) {
        this.rowValues = rowValues;
    }

    public ArrayList<String> getMandatoryFields() {
        return mandatoryFields;
    }

    public void setMandatoryFields(ArrayList<String> mandatoryFields) {
        this.mandatoryFields = mandatoryFields;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public HashMap<String, Integer> getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(HashMap<String, Integer> tableSchema) {
        this.tableSchema = tableSchema;
    }

    public void insertRecords(Row row)
    {
        if(rowValues.containsKey(row.rowid))
        {
            System.out.println("the row with same primary key exists.");
            return;
        }
        else
        {
            HashMap<String,String> columnMap= row.getColumnMaps();
            for(String mandatory: mandatoryFields) {
                if (!columnMap.containsKey(mandatory)) {
                    System.out.println("The Mandatory Column doesnot exist");
                    return;
                }
            }
            rowValues.put(row.rowid, row);
            System.out.println("the row inserted successfully");
            return;
        }


    }

    public void deleteRecords(String rowid)
    {
        if(!rowValues.containsKey(rowid))
        {
            System.out.println("this value doesn't exist, so this row cannot be deleted");
            return;
        }
        else
        {
            rowValues.remove(rowid);
            System.out.println("Row deleted successfully!");
            return;
        }
    }

    public void selectEntries()
    {
        for(Map.Entry row:rowValues.entrySet())
        {
                Row r=(Row)row.getValue();
                HashMap<String,String>columnMap=r.getColumnMaps();
                for(Map.Entry column:columnMap.entrySet())
                {
                    System.out.print("**"+ column.getValue()+"**");
                }

            System.out.println();
        }
    }

    public void selectEntries(String key,String value)
    {
        for(Map.Entry row:rowValues.entrySet())
        {
            Row r=(Row)row.getValue();
            HashMap<String,String>columnMap=r.getColumnMaps();
            if(columnMap.get(key).equals(value)) {
                for (Map.Entry column : columnMap.entrySet()) {
                    System.out.print("**" + column.getValue() + "**");
                }
            }

            System.out.println();
        }

    }

    public void selectEntries(String key,int value)
    {
        selectEntries(key,String.valueOf(value));
    }

    public void createSchema(String key,String value)
    {
        if(value.equals("int"))
        {
            tableSchema.put(key,2);
        }
        else
        {
            tableSchema.put(key,1);
        }
    }
}
