package df.pages;


import java.io.PrintWriter;

// one instance serves all - don't use class variables
public class HomePage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final String query)
    {
        out(w, "Home Page x");
        out(w, query);
    }
}
