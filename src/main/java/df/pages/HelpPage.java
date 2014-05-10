package df.pages;


import java.io.PrintWriter;
import java.util.Map;

// one instance serves all - don't use class variables
public class HelpPage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params)
    {
        out(w, "Drunk Fish");
    }
}
