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

        String player = this.playerXTurn ? "X" : "O";
        System.out.println("Player " + player + " enter (1-9)");


    }

    public boolean isThereWinner(){
        return false;
    }

    public void validateMove(String input) {
        if (isInputNumerical(input) && isInputInRange(input) && isCellFree(input)) {
            makeMove(input);
            switchPlayers(); //TODO: switch only if there is no winner in isThereWinner
        }
    }

    private void makeMove(String input) {
        String player = this.playerXTurn ? "X" : "O";
        this.gameField.updateField(player, input);
    }

    private void switchPlayers(){
        this.playerXTurn = this.playerXTurn ? false : true;
        this.playerOTurn = this.playerOTurn ? false : true;
    }

    private boolean isInputNumerical(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid input!");
            return false;
        }
    }

    private boolean isInputInRange(String input) {
        int num = Integer.parseInt(input);

        if (num > 0 && num < 10) {
            return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }

    private boolean isCellFree(String input) {
        int num = Integer.parseInt(input);
        String cell = "";

        switch (num) {
            case 1 -> cell = this.gameField.getPlayingField()[0][1];
            case 2 -> cell = this.gameField.getPlayingField()[0][3];
            case 3 -> cell = this.gameField.getPlayingField()[0][5];
            case 4 -> cell = this.gameField.getPlayingField()[1][1];
            case 5 -> cell = this.gameField.getPlayingField()[1][3];
            case 6 -> cell = this.gameField.getPlayingField()[1][5];
            case 7 -> cell = this.gameField.getPlayingField()[2][1];
            case 8 -> cell = this.gameField.getPlayingField()[2][3];
            case 9 -> cell = this.gameField.getPlayingField()[2][5];
        }

        if (cell.equals("_")){
            return true;
        } else {
            System.out.println("Cell is already taken!");
            return false;
        }
    }

    //TODO:
//    public void checkWinnerInRow();
//    public void checkWinnerInColumn();
//    public void checkWinnerInDiagonal();

}
