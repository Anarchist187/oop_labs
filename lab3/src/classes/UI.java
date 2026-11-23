package classes;

import java.util.Scanner;

public class UI
{
    public static void main (String[] args)
    {
        IOperation[] operations =
        {
            new AndOperation(),
            new OrOperation(),
            new XorOperation(),
            new NandOperation()
        };

        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("\n-----Меню операций-----\n");

            for (int i = 0; i < operations.length; i++)
            {
                System.out.printf("%d. %s (%s)\n",i+1, operations[i].getName(), operations[i].getSign());
            }
            System.out.println("0. Выход");
            System.out.print("Выберите операцию: ");

            if (!scanner.hasNextInt())
            {
                System.out.println("Ошибка. Введите число");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            if (choice == 0)
            {
                System.out.println("Выходим...");
                break;
            }

            if (choice < 1 || choice > operations.length)
            {
                System.out.println("Ошибка. Неверный номер операции");
                continue;
            }

            int a = readInt(scanner, "Введите первое число: ");
            int b = readInt(scanner, "Введите второе число: ");
            IOperation op = operations[choice-1];

            int result = op.estimate(a, b);

            System.out.printf("\nРезультат: %d %s %d = %d\n", a, op.getSign(), b, result);
        }

        scanner.close();
    }

    private static int readInt(Scanner scanner, String format)
    {
        while (true)
        {
            System.out.print(format);
            if (scanner.hasNextInt())
            {
                return scanner.nextInt();
            }
            else
            {
                System.out.println("Ошибкаю Введите целое число.");
                scanner.next();
            }
        }
    }
}
