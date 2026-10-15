
public class TypingAccuracyChecker {
    static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int firstMismatch = -1;
        int minLength = Math.min(original.length(), typed.length());

        for (int i = 0; i < minLength; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        int total = Math.max(original.length(), typed.length());
        double accuracy = total == 0 ? 100.0 :
                matched * 100.0 / total;

        System.out.println("Matched: " + matched + "/" + total);
        System.out.printf("Accuracy: %.2f%%\n", accuracy);

        if (firstMismatch == -1 && original.length() == typed.length()) {
            System.out.println("No Mismatches");
        } else if (firstMismatch != -1) {
            System.out.println("First Mismatch at position "
                    + (firstMismatch + 1) + " ('"
                    + original.charAt(firstMismatch) + "' vs '"
                    + typed.charAt(firstMismatch) + "')");
        } else {
            System.out.println("Length mismatch at position "
                    + (minLength + 1));
        }
    }

    public static void main(String[] args) {
        String original = "hello world";
        String typed = "hello worlt";

        checkTypingAccuracy(original, typed);
    }
}
