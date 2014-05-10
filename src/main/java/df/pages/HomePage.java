package df.pages;


import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

// one instance serves all - don't use class variables
public class HomePage extends Page
{
    static final String CLIENT_ID = "e1Wy2Hc_o0k18d7ry1f4qrJefT2jQU9Q";
    static final String REDIRECT_URI = "http://medios.fi/df/info";
    static final String SCOPE = "activity location";

    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params)
    {
        try {
            doView(w, params);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


    private void doView(final PrintWriter w,
                        final Map<String, String> params)
        throws UnsupportedEncodingException
    {
        begin(w, "Drunk Fish");

        out(w, "<font size=\"40\">");

        out(w, "<a href=\"" +
            "moves://app/authorize" +
            "?client_id=" + URLEncoder.encode(CLIENT_ID, "UTF-8") +
            "&redirect_uri=" + URLEncoder.encode(REDIRECT_URI, "UTF-8") +
            "&scope=" +URLEncoder.encode(SCOPE, "UTF-8") +
            "\">Login</a>"
        );

        out(w, "</font>");


        end(w);

    }

}
