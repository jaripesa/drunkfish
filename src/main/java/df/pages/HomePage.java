package df.pages;


import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;

// one instance serves all - don't use class variables
public class HomePage extends Page
{

    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params,
                     final Properties properties)

    {
        begin(w, "Drunk Fish");
        out(w, "<font size=\"30\">");

        out(w, "<a href=\"" +
            "moves://app/authorize" +
            "?client_id=" + encode((String)properties.get("moves.client.id")) +
            "&redirect_uri=" + encode((String)properties.get("moves.redirect.uri")) +
            "&scope=" + encode("activity location") +
            "\">Begin</a>"
        );

        out(w, "</font>");
        end(w);
    }

}
