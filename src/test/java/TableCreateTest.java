import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TableCreateTest {

    @Test
    public void createTableTest()
    {
        DatabaseManager dbmanager= new DatabaseManager(new HashMap<String, Database>());
        Database database=dbmanager.createDatabase("employeeDatabase");
        Table table= database.createTable("employeeTable");
        Row row= new Row("1",new HashMap<String, String>(),new Date(),new Date());
        row.insertColumnValues("name","himanshu");
        row.insertColumnValues("surname","garg");
        row.insertColumnValues("age",20);
        ArrayList<String> mandatoryFields= new ArrayList<String>();
        mandatoryFields.add("name");


        Row row2= new Row("2",new HashMap<String, String>(),new Date(),new Date());
        row2.insertColumnValues("name","himanshutest");
        row2.insertColumnValues("surname","garg");
        row2.insertColumnValues("age",21);

        table.insertRecords(row);
        table.insertRecords(row2);
        table.selectEntries();
        table.selectEntries("age",10);
        System.out.println("table created successfully");


    }


}
