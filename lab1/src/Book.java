public class Book {
    private String title;
    private String author;
    private float price;
    private int edition;
    private boolean available;

    public Book (String title, String author, float price, int edition, boolean available)
    {
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.available = available;
    }

    public String getTitle ()
    {
        return title;
    }

    public String getAuthor ()
    {
        return author;
    }

    public float getPrice ()
    {
        return price;
    }

    public int getEdition ()
    {
        return edition;
    }

    public String isAvailable ()
    {
        return available ? "в наличии" : "нет в наличии";
    }

    public String convertToString ()
    {
        return String.format ("%s | %s | %f | издание %d | %s",
                              title, author, price, edition, this.isAvailable());
    }

    public void printToFile (java.io.PrintStream fdOut)
    {
        fdOut.printf ("%s | %s | %f | издание %d | %s\n",
                      title, author, price, edition, this.isAvailable());
    }
}
