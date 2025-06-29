public class Game {
    private boolean playerXTurn;
    private boolean playerOTurn;
    private final GameField gameField;

    public Game(){
        this.playerXTurn = false;
        this.playerOTurn = true;
        this.gameField = new GameField();
    }



    public void playRound() {
        System.out.println(this.gameField);

        String player = this.playerXTurn ? "X" : "O";
        System.out.println("Player " + player + " enter (1-9)");


    }

    public boolean shouldGameContinue(){
        if (checkWinnerInRow() || checkWinnerInColumn() || checkWinnerInDiagonal()){
            System.out.println(this.gameField);
            return false;
        }
        switchPlayers();
        return true;
    }

    public void validateMove(String input) {
        if (isInputNumerical(input) && isInputInRange(input) && isCellFree(input)) {
            makeMove(input);
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


    private boolean checkWinnerInRow(){
        String firstRow = this.gameField.getPlayingField()[0][1] +
                this.gameField.getPlayingField()[0][3] +
                this.gameField.getPlayingField()[0][5];
        String secondRow = this.gameField.getPlayingField()[1][1] +
                this.gameField.getPlayingField()[1][3] +
                this.gameField.getPlayingField()[1][5];
        String thirdRow = this.gameField.getPlayingField()[2][1] +
                this.gameField.getPlayingField()[2][3] +
                this.gameField.getPlayingField()[2][5];

        return isThereWinner(firstRow,secondRow,thirdRow);
    }
    private boolean checkWinnerInColumn() {
        String firstColumn = this.gameField.getPlayingField()[0][1] +
                this.gameField.getPlayingField()[1][1] +
                this.gameField.getPlayingField()[2][1];
        String secondColumn = this.gameField.getPlayingField()[0][3] +
                this.gameField.getPlayingField()[1][3] +
                this.gameField.getPlayingField()[2][3];
        String thirdColumn = this.gameField.getPlayingField()[0][5] +
                this.gameField.getPlayingField()[1][5] +
                this.gameField.getPlayingField()[2][5];

        return isThereWinner(firstColumn, secondColumn, thirdColumn);
    }
    private boolean checkWinnerInDiagonal(){
        String firstDiagonal = this.gameField.getPlayingField()[0][1] +
                this.gameField.getPlayingField()[1][3] +
                this.gameField.getPlayingField()[2][5];
        String secondDiagonal = this.gameField.getPlayingField()[0][5] +
                this.gameField.getPlayingField()[1][3] +
                this.gameField.getPlayingField()[2][1];

        return isThereWinner(firstDiagonal, secondDiagonal);
    }

    private boolean isXWinner(String toCheck) {
        return toCheck.equals("XXX");
    }

    private boolean isOWinner(String toCheck){
        return toCheck.equals("OOO");
    }

    private boolean isThereWinner(String firstRowOrColumn, String secondRowOrColumn, String thirdRowOrColumn) {
        if (isXWinner(firstRowOrColumn) || isXWinner(secondRowOrColumn) || isXWinner(thirdRowOrColumn)){
            System.out.println("X wins!");
            return true;
        } else if (isOWinner(firstRowOrColumn) || isOWinner(secondRowOrColumn) || isOWinner(thirdRowOrColumn)) {
            System.out.println("O wind!");
            return true;
        }else {
            return false;
        }
    }

    private boolean isThereWinner(String firstDiagonal, String secondDiagonal) {
        if (isXWinner(firstDiagonal) || isXWinner(secondDiagonal)){
            System.out.println("X wins!");
            return true;
        } else if (isOWinner(firstDiagonal) || isOWinner(secondDiagonal)) {
            System.out.println("O wind!");
            return true;
        }else {
            return false;
        }
    }
}
