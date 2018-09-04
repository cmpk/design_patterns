# TemplateMethod パターンの課題

レストランの開店・営業・閉店を表すクラスがあるとします。  

このクラスは、レストランの1日を以下のように表現します。  
1. レストランを開店するので、お店の外にメニューを出します。
1. 注文を受け付けます。
1. 品切れになったり閉店時間になったら注文を締め切ります。
1. 注文を締め切ったので閉店します。

レストランのメニューの内容と注文を締め切るタイミングはオーナー（実装者）に任されています。  

## 課題1
レストランの開店・営業・閉店が後述する3つのクラスで表される場合に、「開店から一定時間経過したら注文を締め切る」レストランを作成してください。

## 課題2
レストランの開店・営業・閉店が後述する3つのクラスで表される場合に、「1つでも品切れになったメニューがあれば注文を締め切る」レストランを作成してください。

## クラス
パッケージ名やimport文を付加しても構いませんが、それ以外の変更は付け加えないでください。  

*Mainクラス*
```
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
```

*レストランの抽象クラス*
```
import java.util.List;

abstract public class AbstractRestaurant {
    abstract public List<Item> getMenu();
    abstract public void order(String name);
    abstract public boolean canOrder();
}
```

*品物クラス*
```
public class Item {
    private String name;
    private int price;

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
```