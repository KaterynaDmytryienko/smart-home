package smart.home.model;

public abstract class Item {
    private int amount;

    public Item(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


}
