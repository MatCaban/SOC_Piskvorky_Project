/**
 * The GameField class represents the playing field for a simple two-player game.
 * It is internally represented as a 3x3 grid and facilitates game logic such as
 * constructing the initial empty board and updating the field based on player actions.
 */
public class GameField {
    private final String[][] playingField;

    public GameField() {
        this.playingField = new String[3][7];
        createEmptyPlayingField();
    }

    public String[][] getPlayingField() {
        return this.playingField;

    }

    private void createEmptyPlayingField() {
        for (int i = 0; i < this.playingField.length; i++) {
            for (int j = 0; j < this.playingField[i].length; j++) {
                if (j % 2 == 0) {
                    this.playingField[i][j] = "|";
                } else {
                    this.playingField[i][j] = "_";
                }
            }
        }
    }

    /*
     * Updates the game field with the player's symbol at the specified cell position.
     *
     * player The symbol representing the current player (e.g., "X" or "O").
     * cellNumber A number between "1" and "9" indicating the position of the cell to update.
     *                   The cells are numbered from 1 to 9 in a 3x3 grid format, starting from the top-left corner.
     */
    public void updateField(String player, String cellNumber) {
        switch (cellNumber) {
            case "1" -> this.playingField[0][1] = player;
            case "2" -> this.playingField[0][3] = player;
            case "3" -> this.playingField[0][5] = player;
            case "4" -> this.playingField[1][1] = player;
            case "5" -> this.playingField[1][3] = player;
            case "6" -> this.playingField[1][5] = player;
            case "7" -> this.playingField[2][1] = player;
            case "8" -> this.playingField[2][3] = player;
            case "9" -> this.playingField[2][5] = player;
        }
    }

    public String toString() {
        StringBuilder displayBoard = new StringBuilder();
        for (String[] row : this.playingField) {
            for (String s : row) {
                displayBoard.append(s);
            }
            displayBoard.append("\n");
        }

        return displayBoard.toString();
    }
}
