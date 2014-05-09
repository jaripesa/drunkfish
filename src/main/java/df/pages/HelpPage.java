package df.pages;


import java.io.PrintWriter;

// one instance serves all - don't use class variables
public class HelpPage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final String query)
    {
        out(w, "Help Page");
    }
}
