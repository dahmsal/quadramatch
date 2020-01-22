import edu.kit.informatik.Terminal;

/**
 * The Board stores the placed pieces and their positions
 *
 */
public class Board {
    private Piece [] [] board;
    private Pieces pieces;
    public Board() {
        this.board = new Piece[6][6];
        this.pieces = new Pieces();
    }

    /**
     * place a piece on the given location, if the location is free and the piece is unused
     * @param i the piece to be placed
     * @param position the position on the board
     * @throws IllegalArgumentException if the piece could not be placed
     */
    public void placePiece(int i, int[] position) {
        //is the spot empty
        if(this.board[position[0]][position[1]] == null){
            this.board[position[0]][position[1]] = pieces.getPiece(i);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

}
