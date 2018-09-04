import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantA extends AbstractRestaurant {
    Map<String, ItemContainer> itemContainerMap;
    public RestaurantA() {
        this.itemContainerMap = new HashMap<String, ItemContainer>();

        String name = "Edamame";
        ItemContainer itemContainer = new ItemContainer(new Item(name, 290), 10);
        this.itemContainerMap.put(name, itemContainer);

        name ="Tofu";
        itemContainer = new ItemContainer(new Item(name, 390), 5);
        this.itemContainerMap.put(name, itemContainer);

        name ="Sashimi";
        itemContainer = new ItemContainer(new Item(name, 590), 3);
        this.itemContainerMap.put(name, itemContainer);

        name ="Beer";
        itemContainer = new ItemContainer(new Item(name, 490), 20);
        this.itemContainerMap.put(name, itemContainer);
    }

    public List<Item> getMenu() {
        List<Item> menu = new ArrayList<Item>();
        for (ItemContainer itemContainer: this.itemContainerMap.values()) {
            menu.add(itemContainer.item);
        }

        return menu;
    }

    public void order(String name) {
        ItemContainer itemContainer = this.itemContainerMap.get(name);
        itemContainer.restCnt--;
    }

    public boolean canOrder() {
        for (ItemContainer itemContainer: this.itemContainerMap.values()) {
            if (itemContainer.restCnt < 1) {
                return false;
            }
        }
        return true;
    }

    private class ItemContainer {
        public Item item;
        public int restCnt;
        public ItemContainer(Item item, int initialCnt) {
            this.item = item;
            this.restCnt = initialCnt;
        }
    }
}