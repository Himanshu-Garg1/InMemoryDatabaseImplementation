import javafx.scene.chart.PieChart;

import java.util.Date;
import java.util.HashMap;

public class DatabaseManager {
    HashMap<String,Database> databaseMap;
    public DatabaseManager(HashMap<String, Database> databaseMap) {
        this.databaseMap = databaseMap;
    }

    public HashMap<String, Database> getDatabaseMap() {
        return databaseMap;
    }

    public void setDatabaseMap(HashMap<String, Database> databaseMap) {
        this.databaseMap = databaseMap;
    }

    public Database createDatabase(String dbName)
    {
        if(databaseMap.containsKey(dbName))
        {
            System.out.println("the db with same exists, Please try different name");
            return null;
        }
        else {
            Database database = new Database(dbName, new HashMap(), new Date());
            System.out.println("The Database created succesfully");
            return database;
        }
    }






}
