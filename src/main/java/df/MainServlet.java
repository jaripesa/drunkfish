package df;

import df.pages.HelpPage;
import df.pages.HomePage;
import df.pages.InfoPage;
import df.pages.Page;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainServlet extends HttpServlet
{

    final static HashMap<String, Page> pages = new HashMap<String, Page>();
    final DrunkFishProperties properties = new DrunkFishProperties();

    static {
        pages.put("/",     new HomePage());
        pages.put("/info", new InfoPage());
        pages.put("/help", new HelpPage());

    }


    public void init() throws ServletException
    {
    }


    public void doGet(final HttpServletRequest request,
                      final HttpServletResponse response)
        throws ServletException, IOException
    {
        response.setContentType("text/html");

        final PrintWriter writer = response.getWriter();
        final String path = request.getPathInfo();
        final String queryString = request.getQueryString();
        final List<NameValuePair> pairs = URLEncodedUtils.parse(queryString, Charset.forName("UTF-8"));
        final Map<String,String> params = new HashMap<String, String>();

        for (final NameValuePair pair : pairs) {
            params.put(pair.getName(), pair.getValue());
        }

        Page page = pages.get(path);

        if (page == null) {
            page = pages.get("/");
        }

        try {
            page.view(writer, params, properties.getProperties());

        } catch (Throwable t) {
            t.printStackTrace();
            writer.println("Oops, something went wrong.");
        }
    }


    public void destroy()
    {
    }

}