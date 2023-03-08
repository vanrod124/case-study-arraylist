class Product extends User {
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        super(id, name);
        this.price = price;
        this. quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}
