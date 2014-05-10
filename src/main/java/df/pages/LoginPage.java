package df.pages;


import java.io.PrintWriter;

// one instance serves all - don't use class variables
public class LoginPage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final String query)
    {
        out(w, "Login Page");
    }

}
