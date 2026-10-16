
abstract class Transport {
    abstract double calculateFare(double distance);
}

class Bus extends Transport {
    @Override
    double calculateFare(double distance) {
        return Math.min(2 + 0.10 * distance, 10);
    }
}

class Train extends Transport {
    @Override
    double calculateFare(double distance) {
        return 3 + 0.15 * distance;
    }
}

class Metro extends Transport {
    private double peakFactor;

    Metro(double peakFactor) {
        this.peakFactor = peakFactor;
    }

    @Override
    double calculateFare(double distance) {
        return (1.50 + 0.20 * distance) * peakFactor;
    }
}

public class TransportFareDemo {
    public static void main(String[] args) {
        Transport[] transports = {
            new Bus(),
            new Train(),
            new Metro(1.5)
        };

        String[] types = {"BUS", "TRAIN", "METRO"};
        double[] distances = {15, 50, 10};

        double total = 0;

        for (int i = 0; i < transports.length; i++) {
            double fare = transports[i].calculateFare(distances[i]);

            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
