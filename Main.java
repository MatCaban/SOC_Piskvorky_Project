import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();


        boolean isThereWinner = game.isThereWinner();

        while(!game.isThereWinner()){
            game.playRound();
            game.validateMove(scanner.nextLine());
        }


    }
}