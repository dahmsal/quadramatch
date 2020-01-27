import edu.kit.informatik.Terminal;

/**
 * The GameManager defines the Turns and checks for victory conditions
 */
public class GameManager {
    private Board board;
    private Pieces p1pieces;
    private Pieces p2pieces;
    public GameManager() {
        this.board = new Board();
        this.p1pieces = new Pieces();
        this.p2pieces = new Pieces();
    }

    /**
     * Defines the standard turn: a stone is picked from the correct bag and placed on the board
     * @param piece the number of the selected piece
     * @param position position on the board
     * @param player the player that places the piece (1 or 2)
     * @throws IllegalArgumentException if the piece isn't available or the space on the board is used
     */
    public void turn(int piece, int[] position, int player){
        switch (player){
            case 1:
                if(!this.p1pieces.getPiece(piece).isPlaced()) {
                    try {
                        board.placePiece(piece,position);
                        p1pieces.getPiece(piece).setPlaced();
                    } catch (IllegalArgumentException e) {
                        Terminal.printLine("The space on the board is already in use");
                        throw new IllegalArgumentException();
                    }
                } else {
                    Terminal.printLine("The piece chosen is already in use");
                    throw new IllegalArgumentException();
                }
                break;
            case 2:
                if(!this.p2pieces.getPiece(piece).isPlaced()) {
                    try {
                        board.placePiece(piece,position);
                        p2pieces.getPiece(piece).setPlaced();
                    } catch (IllegalArgumentException e) {
                        Terminal.printLine("The space on the board is already in use");
                        throw new IllegalArgumentException();
                    }
                } else {
                    Terminal.printLine("The piece chosen is already in use");
                    throw new IllegalArgumentException();
                }
                break;
            default:
                //This case should not be called in regular use
                Terminal.printError("Wrong player-number");
                throw new IllegalArgumentException();
        }
    }

    public void checkWinNormal() {
        //Normal field doesnt wrap around
    }

}
