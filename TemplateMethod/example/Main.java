import java.lang.ClassNotFoundException;
import java.lang.IllegalAccessException;
import java.lang.InterruptedException;
import java.lang.InstantiationException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        //// レストラン名（クラス名）を指定します。
        if (args.length != 1) {
            System.out.println("You should choose one restaurant.");
            return;
        }
        
        AbstractRestaurant restaurant;
        try {
            Class restaurantClass = Class.forName(args[0]);
            restaurant = (AbstractRestaurant)restaurantClass.newInstance();
        } catch(ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println("The restaurant is not found.");
            return;
        }
        
        
        List<Item> items = restaurant.getMenu();

        //// レストランを開店するので、お店の外にメニューを出します。
        System.out.println("Open Restaurant");
        System.out.println("\n===== Menu =====");
        for (Item item: items) {
            System.out.println(item.getName() + " (" + item.getPrice() + " yen)");
        }
        System.out.println("================\n");

        //// 注文を受け付けます。
        Random rand = new Random();
        int itemCnt = items.size();
        try {
            while(true) {
                if (!restaurant.canOrder()) {
                    //// 注文を締め切ります。
                    break;
                }
                int orderNum = rand.nextInt(itemCnt);
                String name = items.get(orderNum).getName();
                System.out.println("Order " + name);
                restaurant.order(name);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("Something bad is happening.");
        }
        System.out.println("\n");

        //// 注文を締め切ったので閉店します。
        System.out.println("Close Restaurant");
    }
}