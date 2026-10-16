
import java.util.Scanner;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double calculateBaseFare();

    double calculateFare(boolean night) {
        double fare = Math.max(100, calculateBaseFare());

        if (night) {
            fare *= 1.20;
        }

        return fare;
    }
}

interface NightService {
    boolean supportsNightService();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 10;
    }
}

class Sedan extends Cab implements NightService {
    Sedan(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 14;
    }

    public boolean supportsNightService() {
        return true;
    }
}

class SUV extends Cab implements NightService {
    SUV(double km) {
        super(km);
    }

    double calculateBaseFare() {
        return km * 18;
    }

    public boolean supportsNightService() {
        return true;
    }
}

public class CityCabFare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            boolean night = time.equals("NIGHT");
            Cab c;

            switch (type) {
                case "MINI":
                    c = new Mini(km);
                    break;
                case "SEDAN":
                    c = new Sedan(km);
                    break;
                default:
                    c = new SUV(km);
            }

            if (night && !(c instanceof NightService)) {
                System.out.println(type + ": night service not available");
                continue;
            }

            double fare = c.calculateFare(night);
            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}
