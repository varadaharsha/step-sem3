
import java.util.*;

public class Main {
    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove))
            return "Draw";

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper")))
            return "Player Wins";

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] player = new String[5];
        String[] computer = new String[5];
        String[] result = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter move: ");
            player[i] = sc.next();

            player[i] = player[i].substring(0, 1).toUpperCase()
                    + player[i].substring(1).toLowerCase();

            computer[i] = moves[rand.nextInt(3)];
            result[i] = playRound(player[i], computer[i]);

            if (result[i].equals("Player Wins")) wins++;
            else if (result[i].equals("Computer Wins")) losses++;
            else draws++;

            System.out.println(result[i]);
        }

        System.out.println("\nRound\tPlayer\tComputer\tResult");
        for (int i = 0; i < 5; i++)
            System.out.println((i + 1) + "\t" + player[i] + "\t"
                    + computer[i] + "\t\t" + result[i]);

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%\n", wins * 100.0 / 5);

        sc.close();
    }
}
