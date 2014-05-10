package df.pages;


import java.io.PrintWriter;
import java.util.Map;

public abstract class Page
{

    public abstract void view(PrintWriter writer,
                              Map<String, String> params);

    protected void begin(final PrintWriter w,
                        final String title)
    {
        out(w, "<html><head><title>" + title + "</title><body>");
        out(w, "<h1>" + title + "</h1>");

    }

    protected void out(final PrintWriter w,
                       final String message)

    {
        w.println(message);
    }


    protected void end(final PrintWriter w)
    {
        out(w, "</body></html>");
    }

}
