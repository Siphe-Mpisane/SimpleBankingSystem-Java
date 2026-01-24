package util;

public class Validation {

    public boolean isValidAmount(double amount)
    {
        return amount>0;
    }
    public boolean isCorrectString(String str)
    {
        if(str==null||str.trim().isEmpty()==true)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
