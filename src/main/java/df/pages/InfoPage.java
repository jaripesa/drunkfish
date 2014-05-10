package df.pages;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Properties;


// one instance serves all - don't use class variables
public class InfoPage extends Page
{
    @Override
    public void view(final PrintWriter w,
                     final Map<String, String> params,
                     final Properties properties)
    {
        begin(w, "Info Page");

        String error = params.get("error");

        if (error != null) {
            out(w, "Error " + error);

        } else {
            final String code = params.get("code");
            final HttpClient client = HttpClientBuilder.create().build();

            final String url = "https://api.moves-app.com/oauth/v1/access_token" +
                "?grant_type=authorization_code" +
                "&code=" +
                encode(code) +
                "&client_id=" +
                encode((String)properties.get("moves.client.id")) +
                "&client_secret=" +
                encode((String)properties.get("moves.client.secret")) +
                "&redirect_uri=" +
                encode((String)properties.get("moves.redirect.uri"));

            System.err.println(url);

            final HttpPost post = new HttpPost(url);

            try {
                final HttpResponse response = client.execute(post);
                out(w, "Response Code : " + response.getStatusLine().getStatusCode());
                System.err.println(response.getStatusLine().getStatusCode());

                BufferedReader reader = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));


                String line;

                while ((line = reader.readLine()) != null) {
                    System.err.println(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        end(w);
    }
}
