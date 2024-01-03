package smart.home.model;

public class Item {
    private int amount;
    private String name;

    public Item(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
