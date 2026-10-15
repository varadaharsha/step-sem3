
public class TrafficSignalAnalyzer {
    static void findLongestStreak(String signalLog) {
        if (signalLog.length() == 0) {
            System.out.println("No Signal Data");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longest = 1;
        int count = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                count++;
            } else {
                count = 1;
            }

            if (count > longest) {
                longest = count;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longest + " times");
    }

    public static void main(String[] args) {
        String signalLog = "RRGGGYRR";
        findLongestStreak(signalLog);
    }
}
