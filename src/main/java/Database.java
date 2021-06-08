import sun.security.krb5.internal.crypto.HmacSha1Aes128CksumType;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Database {

    String dbname;
    HashMap<String,Table> tablesMap;
    Date createdDate;

    public Database(String dbname, HashMap<String, Table> tablesMap, Date createdDate) {
        this.dbname = dbname;
        this.tablesMap = tablesMap;
        this.createdDate = createdDate;
    }


    public String getDbname() {
        return dbname;
    }

    public void setDbname(String dbname) {
        this.dbname = dbname;
    }

    public HashMap<String, Table> getTablesMap() {
        return tablesMap;
    }

    public void setTablesMap(HashMap<String, Table> tablesMap) {
        this.tablesMap = tablesMap;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Table createTable(String tableName)
    {
        if(tablesMap.containsKey(tableName))
        {
            System.out.println("Table with same name cannot be created! Please try different name");
            return null;
        }
        else
        {
            Table table= new Table(tableName,new HashMap(),new ArrayList(),new Date(), new HashMap());
            return table;
        }
    }

    public void dropTable(String tableName)
    {
        if(!tablesMap.containsKey(tableName))
        {
            System.out.println("Table with this name doesnot exist");
            return ;
        }
        else
        {
            tablesMap.remove(tableName);
            return ;
        }
    }

}
