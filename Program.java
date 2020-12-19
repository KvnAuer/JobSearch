import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Program {

    private static HttpURLConnection connection;

    public static void main(String[] args)
    {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();


        try {
            
            String myUrl = "https://api.indeed.com/ads/apisearch?"
        + "publisher=123412341234123&"
        + "q=java+developer&l=austin%2C+tx&sort=&"
        + "radius=&st=&jt=&start=&limit=&"
        + "fromage=&filter=&latlong=1&co=us&chnl=&"
        + "userip=1.2.3.4&"
        + "useragent=Mozilla/%2F4.0%28Firefox%29&v=2";
        URL url = new URL(myUrl);
        connection = (HttpURLConnection) url.openConnection();

        //Request setup
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);


        int status = connection.getResponseCode();
        //System.out.println(status);


        if (status > 299)
        {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while ((line = reader.readLine()) != null)
            {
                responseContent.append(line);
            }
            reader.close();
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null)
            {
                responseContent.append(line);
            }
            reader.close();
        }

        System.out.println(responseContent.toString());

        } catch (MalformedURLException e) {
            //TODO: handle exception;
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println("Hello World");
    }
}
