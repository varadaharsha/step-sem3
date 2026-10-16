
class Cart {
    private final String cartId;
    private final double[] prices;
    private int count = 0;

    Cart(String cartId, int capacity) {
        this.cartId = cartId;
        prices = new double[capacity];
    }

    void addItem(double price) {
        if (price >= 0 && count < prices.length) {
            prices[count] = price;
            count++;
        } else {
            System.out.println("Invalid price or cart is full");
        }
    }

    double getTotal() {
        double total = 0;

        for (int i = 0; i < count; i++) {
            total += prices[i];
        }

        return total;
    }

    int getItemCount() {
        return count;
    }
}

public class CartDemo {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
