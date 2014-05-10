package df.pages;


import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Properties;

public abstract class Page
{
    public abstract void view(PrintWriter writer,
                              Map<String, String> params,
                              Properties properties);


    protected void begin(final PrintWriter w,
                        final String title)
    {
        out(w, "<html><head><title>" + title + "</title><body><center>");
        out(w, "<h1>" + title + "</h1>");

    }

    protected void out(final PrintWriter w,
                       final String message)

    {
        w.println(message);
    }


    protected void end(final PrintWriter w)
    {
        out(w, "</center></body></html>");
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
