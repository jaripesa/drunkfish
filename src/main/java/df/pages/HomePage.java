package df.pages;


import java.io.PrintWriter;
import java.util.Map;

// one instance serves all - don't use class variables
public class HomePage extends Page
{

    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params)

    {
        begin(w, "Drunk Fish");
        out(w, "<font size=\"20\">");

        out(w, "<a href=\"" +
            "moves://app/authorize" +
            "?client_id=" + encode(CLIENT_ID) +
            "&redirect_uri=" + encode(INFO_PAGE_URL) +
            "&scope=" + encode(SCOPE) +
            "\">Begin</a>"
        );

        out(w, "</font>");
        end(w);
    }

}
