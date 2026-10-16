
abstract class Payment {
    abstract double calculateAmount(double amount);
}

class CardPayment extends Payment {
    @Override
    double calculateAmount(double amount) {
        return amount * 1.02;
    }
}

class WalletPayment extends Payment {
    @Override
    double calculateAmount(double amount) {
        return amount * 1.01;
    }
}

class BankTransferPayment extends Payment {
    @Override
    double calculateAmount(double amount) {
        return amount;
    }
}

public class PaymentSystemDemo {
    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new WalletPayment(),
            new BankTransferPayment()
        };

        String[] types = {"CARD", "WALLET", "BANKTRANSFER"};
        double[] amounts = {1000, 500, 2000};
        double total = 0;

        for (int i = 0; i < payments.length; i++) {
            double adjusted = payments[i].calculateAmount(amounts[i]);
            System.out.printf("%s: %.2f%n", types[i], adjusted);
            total += adjusted;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}
