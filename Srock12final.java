import java.util.*;
//create senario for stock mangement for shop
//stockitem
//stocklist
//basket
class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock = 0;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;  // or here (but you wouldn't normally do both).
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if(newQuantity >=0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) {
            return true;
        }

        if((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if(this == o) {
            return 0;
        }

        if(o != null) {
            return this.name.compareTo(o.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
//////////////
class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item) {
        if(item != null) {
            // check if already have quantities of this item
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // If there are already stocks on this item, adjust the quantity
            if(inStock != item) {
                item.adjustStock(inStock.quantityInStock());
            }

            list.put(item.getName(), item);
            return item.quantityInStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);

        if((inStock != null) && (inStock.quantityInStock() >= quantity) && (quantity >0)) {
            inStock.adjustStock(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem get(String key) {
        return list.get(key);
    }

    public Map<String, StockItem> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0.0;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            s = s + stockItem + ". There are " + stockItem.quantityInStock() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
        }

        return s + "Total stock value " + totalCost;
    }
}
/////////////////

 class Basket {
    private final String name;
    private final Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity) {
        if ((item != null) && (quantity > 0)) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + name + " contains " + list.size() + " items\n";
        double totalCost = 0.0;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost " + totalCost;
    }
}


 public class Srock12final {
     public static void main(String[] args) {
             StockList stockList = new StockList();
             StockItem temp = new StockItem("bread", 0.86, 100);
             stockList.addStock(temp);

             temp = new StockItem("cake", 1.10, 7);
             stockList.addStock(temp);

             temp = new StockItem("car", 12.50, 2);
             stockList.addStock(temp);

             temp = new StockItem("chair", 62.0, 10);
             stockList.addStock(temp);

             temp = new StockItem("cup", 0.50, 200);
             stockList.addStock(temp);

             temp = new StockItem("door", 72.95, 4);
             stockList.addStock(temp);

             temp = new StockItem("juice", 2.50, 36);
             stockList.addStock(temp);

             temp = new StockItem("phone", 96.99, 35);
             stockList.addStock(temp);

             temp = new StockItem("towel", 2.40, 80);
             stockList.addStock(temp);

             temp = new StockItem("vase", 8.76, 40);
             stockList.addStock(temp);

             System.out.println(stockList);

             for(String s: stockList.Items().keySet()) {
                 System.out.println(s);
             }


         }
}
//output
//Stock List
//bread : price 0.86. There are 100 in stock. Value of items: 86.00
//        cake : price 1.1. There are 7 in stock. Value of items: 7.70
//        car : price 12.5. There are 2 in stock. Value of items: 25.00
//        chair : price 62.0. There are 10 in stock. Value of items: 620.00
//        cup : price 0.5. There are 200 in stock. Value of items: 100.00
//        door : price 72.95. There are 4 in stock. Value of items: 291.80
//        juice : price 2.5. There are 36 in stock. Value of items: 90.00
//        phone : price 96.99. There are 35 in stock. Value of items: 3394.65
//        towel : price 2.4. There are 80 in stock. Value of items: 192.00
//        vase : price 8.76. There are 40 in stock. Value of items: 350.40
//        Total stock value 5157.549999999999
//        bread
//        cake
//        car
//        chair
//        cup
//        door
//        juice
//        phone
//        towel
//        vase
