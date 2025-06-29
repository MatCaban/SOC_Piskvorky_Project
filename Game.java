/**
 * The Game class represents a simple two-player game where players take turns
 * making moves on a 3x3 game board. The class manages game logic, player turns,
 * move validation, and determines the game outcome based on the board state.
 */
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

    /*
     * Determines whether the game should continue based on the current state of the playing field.
     * Checks for a winner in rows, columns, and diagonals and ends the game if a winner is found.
     * If no winner is found, the players are switched and the game continues.
     */
    public boolean shouldGameContinue(){
        if (checkWinnerInRow() || checkWinnerInColumn() || checkWinnerInDiagonal()){
            System.out.println(this.gameField);
            return false;
        }
        switchPlayers();
        return true;
    }

    /*
     * Validates if the given move input is valid and executes the move if all conditions are met.
     * The input is first checked to ensure it is numerical, within the expected range, and that the
     * targeted cell is not already occupied. If all validations pass, the move is executed.
     */
    public void validateMove(String input) {
        if (isInputNumerical(input) && isInputInRange(input) && isCellFree(input)) {
            makeMove(input);
        }
    }

    /*
     * Makes a move by updating the game field based on the provided input
     * and the current player's turn.
     */
    private void makeMove(String input) {
        String player = this.playerXTurn ? "X" : "O";
        this.gameField.updateField(player, input);
    }

    /*
     * Switches the turn between the two players in the game.
     * If it is currently player X's turn, it becomes player O's turn,
     * and vice versa. This method toggles the state of the
     * playerXTurn and playerOTurn flags accordingly.
     */
    private void switchPlayers(){
        this.playerXTurn = !this.playerXTurn;
        this.playerOTurn = !this.playerOTurn;
    }

    /*
     * Determines whether the provided input string represents a valid numerical value.
     * It attempts to parse the input as an integer and returns true if successful,
     * otherwise returns false.
     */
    private boolean isInputNumerical(String input){
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            System.out.println("Invalid input!");
            return false;
        }
    }

    /*
     * Checks if the input string represents a number within the defined range (1 to 9).
     * If the input is out of range, an error message is printed to the console.
     */
    private boolean isInputInRange(String input) {
        int num = Integer.parseInt(input);

        if (num > 0 && num < 10) {
            return true;
        } else {
            System.out.println("Invalid move!");
            return false;
        }
    }

    /*
     * Determines whether a specific cell on the game field is free (available for a move).
     * Based on the input number, the corresponding cell on the game field is checked for availability.
     */
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


    /*
     * Checks whether there is a winner in any of the rows of the game field.
     * The method constructs string representations of all rows by extracting
     * specific cell positions from the game field and then evaluates if any
     * of the rows contain a winning pattern using the isThereWinner method.
     */
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
    /*
     * Checks if there is a winner in any of the three columns of the game field.
     * This method evaluates the current state of all columns in the playing field
     * by concatenating their respective cells and verifies if any column contains
     * a winning combination for 'X' or 'O'.
     */
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
    /*
     * Checks for a winner in the diagonals of the game field. This method evaluates
     * both primary and secondary diagonals by constructing their respective strings
     * based on the current state of the playing field. The constructed strings are
     * then passed to another method to determine if a winner is present.
     */
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

    /*
     * Checks if there is a winner based on the given rows or columns.
     *
     * The method evaluates if any of the input strings represent a winning combination
     * for either player X or player O. If a winner is found, the respective player's win
     * message is printed, and the method returns true. Otherwise, it returns false.
     */
    private boolean isThereWinner(String firstRowOrColumn, String secondRowOrColumn, String thirdRowOrColumn) {
        if (isXWinner(firstRowOrColumn) || isXWinner(secondRowOrColumn) || isXWinner(thirdRowOrColumn)){
            System.out.println("Player X wins!");
            return true;
        } else if (isOWinner(firstRowOrColumn) || isOWinner(secondRowOrColumn) || isOWinner(thirdRowOrColumn)) {
            System.out.println("Player O wins!");
            return true;
        }else {
            return false;
        }
    }

    private boolean isThereWinner(String firstDiagonal, String secondDiagonal) {
        if (isXWinner(firstDiagonal) || isXWinner(secondDiagonal)){
            System.out.println("Player X wins!");
            return true;
        } else if (isOWinner(firstDiagonal) || isOWinner(secondDiagonal)) {
            System.out.println("Player O wins!");
            return true;
        }else {
            return false;
        }
    }
}
