package classes;

public class BinaryConverter
{
    public static String toBinary(int number)
    {
        if (number == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int n = number;
        while (n > 0)
        {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }

    public static String toPowersOfTwo(int number)
    {
        if (number == 0) return "0";
        StringBuilder sb = new StringBuilder();

        int highest = 31 - Integer.numberOfLeadingZeros(number);
        for (int p = highest; p >= 0; p--)
        {
            int value = 1 << p;
            if ((number & value) != 0)
            {
                if (sb.length() > 0) sb.append("+");
                sb.append(value);
            }
        }
        return sb.toString();
    }
}