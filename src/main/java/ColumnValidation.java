public class ColumnValidation {

    public boolean validateColumn(String value)
    {
        if(value.length()<=20)
        {
            return true;
        }
        else
        {
            System.out.println("the Value size is greater than 20 for branch temp");
            return false;
        }

    }

    public boolean validateColumn(int value)
    {
        if(value>-1024 && value<1024)
        {
            return true;
        }
        else
        {
            System.out.println("the Value must be present between -1024 and 1024!");
            return false;
        }

    }
}
