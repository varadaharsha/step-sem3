
public class ReviewProfMovieiler {
    static void classifyWordLengths(String review) {
        String[] words = review.trim().split("\\s+");

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            if (word.isEmpty())
                continue;

            // Remove basic punctuation from word boundaries
            String cleanWord = word.replaceAll(
                    "^[^a-zA-Z0-9]+|[^a-zA-Z0-9]+$", "");

            int length = cleanWord.length();

            if (length == 0)
                continue;
            else if (length <= 4)
                shortCount++;
            else if (length <= 8)
                mediumCount++;
            else
                longCount++;
        }

        System.out.println("Short: " + shortCount);
        System.out.println("Medium: " + mediumCount);
        System.out.println("Long: " + longCount);
    }

    public static void main(String[] args) {
        String review =
                "This movie was absolutely fantastic and thrilling";

        classifyWordLengths(review);
    }
}
