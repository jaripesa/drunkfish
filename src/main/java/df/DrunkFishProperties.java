package df;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DrunkFishProperties
{
    static final String PROPERTIES_PATH = "/opt/medios/drunkfish/conf/drunkfish.properties";
    final Properties properties = new Properties();

    public DrunkFishProperties()
    {
        System.err.println("Reading properties " + PROPERTIES_PATH);

        try {
            final InputStream input = new FileInputStream(PROPERTIES_PATH);
            properties.load(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Properties getProperties()
    {
        return properties;
    }
}
