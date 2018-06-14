import java.util.Iterator;

public class OrderListIterator implements Iterator<Order> {
    private OrderList orderList;
    private int index;
    public OrderListIterator(OrderList orderList) {
        this.orderList = orderList;
        this.index = 0;
    }

    public boolean hasNext() {
        if (this.index < orderList.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    public Order next() {
        if (this.index < orderList.getLength()) {
            Order order = orderList.getOrder(this.index);
            this.index++;
            return order;
        } else {
            return null;
        }
    }
}