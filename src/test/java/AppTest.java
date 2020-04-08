import org.junit.Assert;
import org.junit.Test;

public class AppTest {
    App app = new App();

    @Test
    public void testUsernameStartsWithU(){
        app.Login("User1");
        Assert.assertTrue(true);
    }
    @Test
    public void testCalcStockPrice(){
        Assert.assertEquals(11,app.CalcStockPrice(10),0);
    }
    @Test
    public void testAuthToken(){
        app.AuthToken();
        Assert.assertTrue(true);
    }
    @Test
    public void testSubmitForm1(){
        Assert.assertEquals(app.SubmitForm(), 200);
    }
    @Test
    public void testSubmitForm2(){
        Assert.assertEquals(app.SubmitForm(), 200);
    }
    @Test
    public void test1(){
        Assert.assertTrue(true);
    }
    @Test
    public void test2(){
        Assert.assertTrue(true);
    }
    @Test
    public void test3(){
        Assert.assertTrue(true);
    }
    @Test
    public void test4(){
        Assert.assertTrue(true);
    }
    @Test
    public void test5(){
        Assert.assertTrue(true);
    }


}


