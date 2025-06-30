import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();




        while(game.shouldGameContinue()){
            game.displayGameField();

            String userInput = scanner.nextLine();

            if (game.validateMove(userInput)) {
                game.finishMove(userInput);
            }

        }


    }
}