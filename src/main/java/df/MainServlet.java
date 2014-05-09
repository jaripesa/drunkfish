package df;

import df.pages.HelpPage;
import df.pages.HomePage;
import df.pages.LoginPage;
import df.pages.Page;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class MainServlet extends HttpServlet
{

    final static HashMap<String, Page> pages = new HashMap<String, Page>();

    static {
        pages.put("/", new HomePage());
        pages.put("/login", new LoginPage());
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
        final String query = request.getQueryString();

        Page page = pages.get(path);

        if (page == null) {
            page = pages.get("/");
        }

        page.view(writer, query);
    }


    public void destroy()
    {
    }

}