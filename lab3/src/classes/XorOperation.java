package classes;

public class XorOperation implements IOperation
{
    @Override
    public String getName ()
    {
        return "Исключающее ИЛИ (XOR)";
    }

    @Override
    public String getSign ()
    {
        return "^";
    }

    @Override
    public int estimate (int a, int b)
    {
        return a ^ b;
    } 
}
