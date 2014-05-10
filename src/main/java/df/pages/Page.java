package df.pages;


import java.io.PrintWriter;

public abstract class Page
{

    public abstract void view(PrintWriter writer,
                              String query);


    protected void out(final PrintWriter writer,
                       final String message)

    {
        writer.println("<h1>" + message + "</h1>");
    }


}
