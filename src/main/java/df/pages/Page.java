package df.pages;


import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public abstract class Page
{
    static final String CLIENT_ID = "e1Wy2Hc_o0k18d7ry1f4qrJefT2jQU9Q";
    static final String CLIENT_SECRET = "u8U8_C_0nw69E35gP2S2Z4x6sh1ceNcJgk5hBLCItXuQdGHS6IVKOMWBpmHLLw1b";
    static final String INFO_PAGE_URL = "http://medios.fi/df/info";
    static final String HELP_PAGE_URL = "http://medios.fi/df/help";
    static final String SCOPE = "activity location";


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


    protected String encode(final String string)
    {
        try {
            return URLEncoder.encode(string, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return string;
        }
    }

}
