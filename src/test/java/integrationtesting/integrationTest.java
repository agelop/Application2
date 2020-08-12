package integrationtesting;

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
}
