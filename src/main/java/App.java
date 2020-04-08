public class App {
    public void Login(String username) {
        System.out.println("Hello, " + username);
    }
    public double CalcStockPrice(double price) {
        System.out.println(price = price + (price * 0.10));
        return price;
    }
    public void AuthToken() {
        System.out.println("Return AuthToken");
    }
    public void ConnectDB() {
        System.out.println("Init...");
        System.out.println("Connecting DB...");
        System.out.println("Success");
    }
    public void SetProperty1() {
        System.out.println("Init...");
        System.out.println("Success");
    }
    public int SubmitForm() {
        System.out.println("STATUS_OK");
        return 200;
    }

}
