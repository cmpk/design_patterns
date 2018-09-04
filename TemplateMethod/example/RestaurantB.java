import java.util.ArrayList;
import java.util.List;

public class RestaurantB extends AbstractRestaurant {
    List<Item> itemList;
    long startTime;
    public RestaurantB() {
        this.itemList = new ArrayList<Item>();

        this.itemList.add(new Item("Beef", 1500));
        this.itemList.add(new Item("Pork", 1000));
        this.itemList.add(new Item("Chicken", 1500));

        startTime = System.currentTimeMillis();
    }

    public List<Item> getMenu() {
        return this.itemList;
    }

    public void order(String name) {
    }

    public boolean canOrder() {
        if (System.currentTimeMillis() - startTime > 5 * 1000) {
            return false;
        }
        return true;
    }
}