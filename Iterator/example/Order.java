import java.util.Calendar;

public class Order {
    private Calendar orderCalendar;
    private String productNo;

    public Order(Calendar orderCalendar, String productNo) {
        this.orderCalendar = orderCalendar;
        this.productNo = productNo;
    }

    public Calendar getOrderCalendar() {
        return this.orderCalendar;
    }

    public String getProductNo() {
        return this.productNo;
    }
}