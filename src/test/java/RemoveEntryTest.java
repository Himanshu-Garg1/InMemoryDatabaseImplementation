import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class RemoveEntryTest {

    @Test
    public void removeEntry()
    {
        DatabaseManager dbmanager = new DatabaseManager(new HashMap<String, Database>());
        Database database = dbmanager.createDatabase("employeeDatabase");
        Table table = database.createTable("employeeTable");
        Row row = new Row("1", new HashMap<String, String>(), new Date(), new Date());
        row.insertColumnValues("name", "himanshu");
        row.insertColumnValues("surname", "garg");
        row.insertColumnValues("age", 20);
        ArrayList<String> mandatoryFields = new ArrayList<String>();
        mandatoryFields.add("name");
        table.setMandatoryFields(mandatoryFields);


        Row row2 = new Row("2", new HashMap<String, String>(), new Date(), new Date());
        row2.insertColumnValues("name", "himanshutest");
        row2.insertColumnValues("surname", "garg");
        row2.insertColumnValues("age", 21);

        table.insertRecords(row);
        table.insertRecords(row2);
        table.selectEntries();

        table.deleteRecords("2");
        System.out.println();
        table.selectEntries();

    }
}
