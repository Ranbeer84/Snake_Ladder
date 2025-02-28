//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final int BOARD_SIZE = 100;
    private static final int[] SNAKES = {16, 47, 49, 56, 62, 64, 87, 93, 95, 98};
    private static final int[] SNAKE_ENDS = {6, 26, 11, 53, 19, 60, 24, 73, 75, 78};
    private static final int[] LADDERS = {1, 4, 9, 21, 28, 36, 51, 71, 80};
    private static final int[] LADDER_TOPS = {38, 14, 31, 42, 84, 44, 67, 91, 100};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[] pPositions = {0, 0};
        String[] pNames = {"Your", "Opponent"};
        int currentPlayer = 0;

        while (true) {
            System.out.println("\n" + pNames[currentPlayer] + "'s turn");
            System.out.println("Press Enter");
            scanner.nextLine();

            int diceRoll = random.nextInt(6) + 1;
            System.out.println("Your number " + diceRoll);

            int newPosition = pPositions[currentPlayer] + diceRoll;

            for (int i = 0; i < SNAKES.length; i++) {
                if (newPosition == SNAKES[i]) {
                    System.out.println("Moving down, you get Snake bite.  " + SNAKE_ENDS[i]);
                    newPosition = SNAKE_ENDS[i];
                    break;
                }
            }

            for (int i = 0; i < LADDERS.length; i++) {
                if (newPosition == LADDERS[i]) {
                    System.out.println("Moving up to " + LADDER_TOPS[i]);
                    newPosition = LADDER_TOPS[i];
                    break;
                }
            }

            if (newPosition > BOARD_SIZE) {
                newPosition = pPositions[currentPlayer];
            }

            pPositions[currentPlayer] = newPosition;
            System.out.println(pNames[currentPlayer] + " playing piece is at position " + newPosition + " now");

            if (newPosition == BOARD_SIZE) {
                System.out.println(pNames[currentPlayer] + " wins!");
                break;
            }

            currentPlayer = 1 - currentPlayer;
        }

        scanner.close();
    }
}