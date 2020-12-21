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

            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please enter your job title you are wanting"
                + " to appply for.");
            String myJob = reader.readLine();
            myJob = myJob.replace(" ", "+");
            System.out.println("Please enter your city: ");
            String myCity = reader.readLine();
            System.out.println("Please enter your state: ");
            String myState = reader.readLine();
            
            
            String myUrl = "https://api.indeed.com/ads/apisearch?"
        + "publisher=123412341234123&"
        + "q=" + myJob + "&l=" + myCity 
        + "%2C+" + myState + "&sort=&"
        + "radius=&st=&jt=&start=&limit=&"
        + "fromage=&filter=&latlong=1&co=us&chnl=&"
        + "userip=" + Config.myIp 
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
        
    
    }
}
