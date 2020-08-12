package integrationtesting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class integrationTest {

    @Test
    public void integrationtest1(){
    System.out.println("This is a integration test...");
    Assert.assertTrue(true);
    }
    
    @Test
    public void integrationtest2(){
    System.out.println("This is a integration test...");
    Assert.assertTrue(true);
    }
    
    @Test
    public void integrationtest3(){
    System.out.println("This is a integration test...");
    Assert.assertTrue(true);
    }
    
    @Test
    public void integrationtest4(){
    System.out.println("This is a integration test...");
    Assert.assertTrue(true);
    }

    @Test
    public void integrationapitest() throws IOException {
        System.out.println("This is a integration api test ...");
        URL url;
        HttpURLConnection connection;
        String service = "https://www.googleapis.com/books/v1/volumes/s1gVAAAAYAAJ";
        url = new URL(service);
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        Assert.assertEquals(200, connection.getResponseCode());
        connection.disconnect();
    }

    @Test
    public void integrationapitest2() throws IOException {
        System.out.println("This is a integration api test ...");
        HttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("https://www.googleapis.com/books/v1/volumes/s1gVAAAAYAAJ");
        HttpResponse response = httpclient.execute(httpget);
        StatusLine status = response.getStatusLine();
        Assert.assertEquals(HttpStatus.SC_OK, status.getStatusCode());
        HttpEntity entity = response.getEntity();
        String content = EntityUtils.toString(entity);
        System.out.println(content);

        JsonObject volume = new JsonParser().parse(content).getAsJsonObject();
        Assert.assertTrue(volume.isJsonObject());
        String expectedTitle = "Pride and Prejudice";
        String actualTitle = volume.getAsJsonObject("volumeInfo").get("title").getAsString();
        Assert.assertEquals(expectedTitle, actualTitle);


        httpget.releaseConnection();


    }
}
