package df.pages;

import java.io.PrintWriter;
import java.util.Map;


// one instance serves all - don't use class variables
public class InfoPage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params)
    {
        begin(w, "Info Page");

        String code = params.get("code");

        end(w);
    }
}
