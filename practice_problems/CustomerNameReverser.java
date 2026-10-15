
import java.util.*;

public class{
    static String reverseCustomerName(String customerName) {
        String reversed = "" CustomerNameReverser ;

        for (int i = customerName.length() - 1; i >= 0; i--)
            reversed += customerName.charAt(i);

        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " +
                reverseCustomerName(customerName));

        sc.close();
    }
}
