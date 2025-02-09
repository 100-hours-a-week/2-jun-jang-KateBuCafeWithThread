package Model.Food;

public abstract class Food {
    private int price;
    private int amount;
    private String name;
    public Food(int price, int amount,String name) {
        this.price = price;
        this.amount = amount;
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public int getAmount() {
        return amount;
    }
    public String getName() {
        return name;
    }

    public abstract String getDescription();

}
