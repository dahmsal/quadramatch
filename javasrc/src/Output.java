import edu.kit.informatik.Terminal;

public class Output {
private Input input;
private String [] outputString;
    public Output(){}

    /**
     * print the row specified in the userInput
     * @param board the current board
     * @param userInput user input
     */
    public void rowprint(Board board,String userInput) {
        outputString = new String[6];
        int rowInt = input.selectArgument(userInput);
        Piece[][] boardMatrix = board.getBoard();
        Piece[] boardRow = boardMatrix[rowInt];
        generateOutput(boardRow);
    }
    /**
     * print the col specified in the userInput
     * @param board the current board
     * @param userInput user input
     */
    public void colprint(Board board,String userInput) {
        outputString = new String[6];
        int colInt = input.selectArgument(userInput);
        Piece[] boardCol = new Piece[6];
        Piece[][] boardMatrix = board.getBoard();
        for(int j = 0; j < 6; j++) {
            boardCol[j] = boardMatrix[j][colInt];
        }
        generateOutput(boardCol);
    }

    private void generateOutput(Piece[] boardCol) {
        for(int i = 0; i < 6; i++) {
            if(boardCol[i] == null) {
                outputString[i] = "#";
            } else {
                outputString[i] = "" + boardCol[i].getId();
            }
        }
        Terminal.printLine(outputString[0] + " "  +outputString[1] + " " + outputString[2] + " " +
                outputString[3] + " " + outputString[4] + " " + outputString[5]);
    }
}

