
package Model;
import java.util.Calendar;

public class Order{
    private String nameClient;

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }
    private Calendar c;

    public Calendar getC() {
        return c;
    }

    public void setC(Calendar c) {
        this.c = c;
    }

    public Order(String nameClient, Calendar c, Product product, double totalPrice){
    this.nameClient=nameClient;

    }
}
