public class GameField {
    private String[][] playingField;

    public GameField(){
        this.playingField = new String[3][7];
        createEmptyPlayingField();
    }

    public String[][] getPlayingField(){
        return this.playingField;

    }

    private void createEmptyPlayingField(){
        for (int i = 0; i < this.playingField.length; i++){
            for (int j = 0; j < this.playingField[i].length; j++){
                if (j % 2 == 0) {
                    this.playingField[i][j] = "|";
                } else {
                    this.playingField[i][j] = "_";
                }
            }
        }
    }

    public String toString(){
        StringBuilder displayBoard = new StringBuilder();
        for (String[] row : this.playingField){
            for (String s : row){
                displayBoard.append(s);
            }
            displayBoard.append("\n");
        }

        return displayBoard.toString();
    }
}
