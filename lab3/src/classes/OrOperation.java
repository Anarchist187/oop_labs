package classes;

public class OrOperation implements IOperation
{
    @Override
    public String getName ()
    {
        return "Логическое ИЛИ (OR)";
    }

    @Override
    public String getSign ()
    {
        return "|";
    }

    @Override
    public int estimate (int a, int b)
    {
        return a | b;
    } 
}
