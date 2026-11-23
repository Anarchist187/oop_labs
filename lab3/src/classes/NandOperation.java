package classes;

public class NandOperation implements IOperation
{
    @Override
    public String getName ()
    {
        return "Штрих Шеффера (NAND)";
    }

    @Override
    public String getSign ()
    {
        return "!&";
    }

    @Override
    public int estimate (int a, int b)
    {
        return (a & b) == 1 ? 0 : 1;
    } 
}
