import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * このプログラムは注文情報がどこにあるか管理する必要はありません。
 * 注文量も知る必要はありません。
 * 注文内容の概要を出力するだけです。
 */
public class Main {
    public static void main(String[] args) {
        OrderList orderList = new OrderList();
        Iterator it = orderList.iterator();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        while (it.hasNext()) {
            Order order = (Order)it.next();
            System.out.println(
                "prod-no:" + order.getProductNo() +
                ",order-date:" + sdf.format(order.getOrderCalendar().getTime()));
        }
    }
}