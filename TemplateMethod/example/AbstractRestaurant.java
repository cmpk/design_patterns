import java.util.List;

abstract public class AbstractRestaurant {
    /**
     * メニューを取得する。
     */
    abstract public List<Item> getMenu();

    /**
     * 注文する。
     */
    abstract public void order(String name);

    /**
     * 注文できるか確認する。
     */
    abstract public boolean canOrder();
}