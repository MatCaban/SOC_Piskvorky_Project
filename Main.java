import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();




        while(game.shouldGameContinue()){
            game.playRound();
            game.validateMove(scanner.nextLine());

        }


    }
}