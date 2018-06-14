import java.util.Calendar;
import java.util.Iterator;

public class OrderList {
    private Order[] orderArray;

    public OrderList() {
        Order ary[] = {
            new Order(Calendar.getInstance(), "prod1"),
            new Order(Calendar.getInstance(), "prod2")};
        this.orderArray = ary;
    }

    public Order getOrder(int i) {
        return this.orderArray[i];
    }

    public int getLength() {
        return this.orderArray.length;
    }

    public Iterator iterator() {
        return new OrderListIterator(this);
    }
}