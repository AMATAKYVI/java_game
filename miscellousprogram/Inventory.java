package miscellousprogram;

public class Inventory {
    private String name;
    private int itemNum;
    private double price;
    private int unitsInStock;

    public Inventory() {
        name = "";
        itemNum = 0;
        price = 0.0;
        unitsInStock = 0;
    }

    public Inventory(String n) {
        name = n;
        itemNum = 0;
        price = 0.0;
        unitsInStock = 0;
    }

    public Inventory(String n, int iNum, double cost, int inStock) {
        name = n;
        itemNum = iNum;
        price = cost;
        unitsInStock = inStock;
    }

    public static void main(String[] args) {
        Inventory item1 = new Inventory();
        Inventory item2 = new Inventory("Item 2");
        Inventory item3 = new Inventory("Item 3", 100, 29.95, 20);
        Inventory item4 = new Inventory("Item 4", 101, 39.95, 10);

        System.out.println("Item 1: " + item1.name + " " + item1.itemNum + " " + item1.price + " "
                + item1.unitsInStock);
        System.out.println("Item 2: " + item2.name + " " + item2.itemNum + " " + item2.price + " "

                + item2.unitsInStock);
        System.out.println("Item 3: " + item3.name + " " + item3.itemNum + " " + item3.price + " "

                + item3.unitsInStock);
        System.out.println("Item 4: " + item4.name + " " + item4.itemNum + " " + item4.price + " "

                + item4.unitsInStock);


    }

}
