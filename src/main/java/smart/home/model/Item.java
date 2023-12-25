package smart.home.model;

public class Item {
    private int amount;

    public String getType() {
        return type;
    }

    private String type;
    public Item(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
