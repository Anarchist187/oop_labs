import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {

    public static void main (String[] args) {
        Book[] books = new Book[] {
            new Book ("Отец Сергий", "Лев Толстой", 500, 3, true),
            new Book ("Детство", "Максим Горький", 700, 4, true),
            new Book ("В людях", "Максим Горький", 300, 1, false),
            new Book ("Код Да Винчи", "Дэн Браун", 500, 2, true),
            new Book ("Вишневый сад", "Антон Чехов", 200, 1, true),
            new Book ("Преступление и наказание", "Фёдор Достоевский", 650, 5, false),
            new Book ("Идиот", "Фёдор Достоевский", 550, 2, true),
            new Book ("Мастер и Маргарита", "Михаил Булгаков", 800, 3, true),
            new Book ("Собачье сердце", "Михаил Булгаков", 350, 1, false),
            new Book ("Евгений Онегин", "Александр Пушкин", 450, 4, true),
            new Book ("Герой нашего времени", "Михаил Лермонтов", 400, 2, true),
            new Book ("Мёртвые души", "Николай Гоголь", 600, 3, false),
            new Book ("Ревизор", "Николай Гоголь", 250, 1, true),
            new Book ("Тихий Дон", "Михаил Шолохов", 900, 2, true)
        };

        System.out.println ("=== Исходный массив ===");
        printArray (books);

        sortByPrice (books);
        System.out.println ("\n=== Сортировка по цене ===");
        printArray (books);

        sortByTitle (books);
        System.out.println ("\n=== Сортировка по названию ===");
        printArray (books);

        writeToFile (books, "data.txt");
        System.out.println ("\nФайл data.txt записан.");
    }

    static void printArray (Book[] books)
    {
        for (Book b : books)
        {
            System.out.println (b.convertToString());
        }
    }

    static void sortByPrice (Book[] books)
    {
        for (int i = 0; i < books.length - 1; i++)
        {
            for (int j = i + 1; j < books.length; j++)
            {
                if (books[j].getPrice () > books[i].getPrice ())
                {
                    swap (books, i, j);
                }
            }
        }
    }

    static void sortByTitle (Book[] books)
    {
        for (int i = 0; i < books.length - 1; i++)
        {
            for (int j = i + 1; j < books.length; j++)
            {
                if (books[j].getTitle().compareToIgnoreCase (books[i].getTitle ()) < 0) 
                {
                    swap(books, i, j);
                }
            }
        }
    }

    static void swap (Book[] books, int i, int j)
    {
        Book tmp = books[i];
        books[i] = books[j];
        books[j] = tmp;
    }

    static void writeToFile (Book[] books, String fileName)
    {
        try (PrintStream out = new PrintStream (new File (fileName)))
        {
            out.println ("title | author | price | edition | available");
            for (Book b : books) 
            {
                b.printToFile (out);
            }
        } catch (FileNotFoundException e) 
        {
            System.err.println ("Error: " + e.getMessage ());
        }
    }
}