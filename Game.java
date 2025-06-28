public class Game {
    private boolean playerXTurn;
    private boolean playerOTurn;
    private final GameField gameField;

    public Game(){
        this.playerXTurn = true;
        this.playerOTurn = false;
        this.gameField = new GameField();
    }



    public void playRound() {
        System.out.println(this.gameField.toString());

        String player = this.playerXTurn ? "X" : "Y";
        System.out.println("Player " + player + " enter (1-9)");

        switchPlayers();
    }

    public boolean isWinner(){
        return false;
    }

    private void switchPlayers(){
        this.playerXTurn = this.playerXTurn ? false : true;
        this.playerOTurn = this.playerOTurn ? false : true;
    }


}
