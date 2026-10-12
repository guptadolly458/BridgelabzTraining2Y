import java.util.Scanner;

public class RockPaperScissors {

    public static String computerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    public static String findWinner(String player, String computer) {
        if (player.equals(computer)) {
            return "Draw";
        }

        if (player.equals("Rock") && computer.equals("Scissors") ||
            player.equals("Paper") && computer.equals("Rock") ||
            player.equals("Scissors") && computer.equals("Paper")) {
            return "Player";
        }

        return "Computer";
    }

    public static String[][] calculateStats(int playerWins,
                                            int computerWins,
                                            int draws,
                                            int games) {
        String[][] stats = new String[2][3];

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(
                Math.round(playerWins * 10000.0 / games) / 100.0);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(
                Math.round(computerWins * 10000.0 / games) / 100.0);

        return stats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int games = sc.nextInt();

        if (games <= 0) {
            System.out.println("Enter a positive number of games.");
            sc.close();
            return;
        }

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 1; i <= games; i++) {
            System.out.println("\nGame " + i);
            System.out.print("Choose Rock, Paper, or Scissors: ");

            String player = sc.next().toLowerCase();

            if (player.equals("rock")) {
                player = "Rock";
            } else if (player.equals("paper")) {
                player = "Paper";
            } else if (player.equals("scissors")) {
                player = "Scissors";
            } else {
                System.out.println("Invalid choice. Game repeated.");
                i--;
                continue;
            }

            String computer = computerChoice();
            String winner = findWinner(player, computer);

            System.out.println("Player: " + player);
            System.out.println("Computer: " + computer);
            System.out.println("Result: " + winner);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }
        }

        String[][] stats = calculateStats(
                playerWins, computerWins, draws, games);

        System.out.println("\nFinal Statistics");
        System.out.println("Player Type\tWins\tWin Percentage");

        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t\t" +
                    stats[i][1] + "\t" + stats[i][2] + "%");
        }

        System.out.println("Draws: " + draws);

        sc.close();
    }
}