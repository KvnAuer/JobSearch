import java.net.HttpURLConnection;
import java.net.URL;

public class Program {

    private static HttpURLConnection connection;

    public static void main(String[] args)
    {



        String myUrl = "https://api.indeed.com/ads/apisearch?"
        + "publisher=123412341234123&"
        + "q=java+developer&l=austin%2C+tx&sort=&"
        + "radius=&st=&jt=&start=&limit=&"
        + "fromage=&filter=&latlong=1&co=us&chnl=&"
        + "userip=1.2.3.4&"
        + "useragent=Mozilla/%2F4.0%28Firefox%29&v=2";
        URL url = new URL(myUrl);
        System.out.println("Hello World");
    }
}
