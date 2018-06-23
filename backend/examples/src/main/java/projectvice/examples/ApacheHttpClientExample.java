package projectvice.examples;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Hello world!
 *
 */
public class ApacheHttpClientExample 
{
    public static void main( String[] args )
    {
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet("http://localhost:8080/api/greeter");
        try {
          HttpResponse response = client.execute(request);
          InputStream in = response.getEntity().getContent();
          BufferedReader r = new BufferedReader(new InputStreamReader(in));
          String line;
          while ((line = r.readLine()) != null) {
            System.out.println(line);
          }
        } catch (ClientProtocolException e) {
          e.printStackTrace();
        } catch (IOException e) {
          e.printStackTrace();
        }
        
    }
}
