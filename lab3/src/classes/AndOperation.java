package classes;

public class AndOperation implements IOperation
{
    @Override
    public String getName ()
    {
        return "Логическое И (AND)";
    }

    @Override
    public String getSign ()
    {
        return "&";
    }

    @Override
    public int estimate (int a, int b)
    {
        return a & b;
    } 
}
