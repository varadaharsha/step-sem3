
abstract class Delivery {
    abstract double calculateFee(double weight, double distance);
}

class StandardDelivery extends Delivery {
    @Override
    double calculateFee(double weight, double distance) {
        return 5 + 0.50 * weight + 0.10 * distance;
    }
}

class ExpressDelivery extends Delivery {
    @Override
    double calculateFee(double weight, double distance) {
        return 15 + 1.00 * weight + 0.20 * distance;
    }
}

class InternationalDelivery extends Delivery {
    double customsFee;

    InternationalDelivery(double customsFee) {
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee(double weight, double distance) {
        return 25 + 2.00 * weight + 0.50 * distance + customsFee;
    }
}

public class DeliveryFeeDemo {
    public static void main(String[] args) {
        Delivery[] deliveries = {
            new StandardDelivery(),
            new ExpressDelivery(),
            new InternationalDelivery(30)
        };

        String[] types = {"STANDARD", "EXPRESS", "INTERNATIONAL"};
        double[] weights = {10, 5, 20};
        double[] distances = {50, 20, 100};

        double total = 0;

        for (int i = 0; i < deliveries.length; i++) {
            double fee = deliveries[i].calculateFee(
                weights[i], distances[i]
            );

            System.out.printf("%s: %.2f%n", types[i], fee);
            total += fee;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
