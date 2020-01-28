import edu.kit.informatik.Terminal;
import java.util.ArrayList;
/**
 * The GameManager defines the Turns and checks for victory conditions
 */
public class GameManager {
    private  Board board;
    private  Pieces pieces;

    public GameManager() {
        this.board = new Board();
        this.pieces = new Pieces();
    }

    /**
     * Defines the standard turn: a stone is picked from the correct bag and placed on the board
     *
     * @param piece    the number of the selected piece
     * @param position position on the board
     * @throws IllegalArgumentException if the piece isn't available or the space on the board is used
     */
    public void turn(int piece, int[] position) {
        //check if the piece is already placed
        if (!this.pieces.getPiece(piece).isPlaced()) {
            //catch the exception when the space on the board is already in use
            try {
                this.board.placePiece(piece, position);
                this.pieces.getPiece(piece).setPlaced();
            } catch (IllegalArgumentException e) {
                Terminal.printLine("The space on the board is already in use");
                throw new IllegalArgumentException();
            }
        } else {
            Terminal.printLine("The piece chosen is already in use");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Check for the win condition
     * It looks for 4 strings of pieces with similar attributes
     * @param fourStringArray inputs the four string matrix generated by the FindFourStringMethod
     */
    public boolean checkWin(Piece[][] fourStringArray) {
        //Iterate through all four Strings
        if(fourStringArray != null) {
            for (Piece[] fourString : fourStringArray) {
                if (pieces.ComparePiece(fourString)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * Find 4 strings on the board (non wrap-around)
     * @throws IllegalArgumentException if there are no stones placed on the board
     * @return Type:Piece[][4] where the first index gives access to the four Strings in the second one
     */
    public Piece[][] FindFourStringNormal() {
        //A List of Array containing the 4 strings
        ArrayList<Piece[]> fourString = new ArrayList<>();
        Integer[][] directionsTemp;

        try {
            board.usedPositions();
        } catch (NullPointerException n){
            Terminal.printError("No Stones are placed");
            throw new IllegalArgumentException();
        }
        Integer[][] positions = board.usedPositions();
        //Iterate through every stone on the board
        for (Integer[] position : positions) {
            try {
                this.board.adjacentStonesStandard(position);
            } catch (NullPointerException n) {
                continue;
            }
            //Iterate through every direction
            for (Integer[] adjacentPosition : this.board.adjacentStonesStandard(position)) {
                Piece[] piecesTemp = new Piece[4];
                //check if there are 4 stones in the same direction
                for (int i = 1; i <= 4; i++) {
                    adjacentPosition[0] =  ( position[0] + ( position[0] - adjacentPosition[0] ) * i );
                    adjacentPosition[1] =  ( position[1] + ( position[1] - adjacentPosition[1] ) * i );
                    if(this.board.getPiece(adjacentPosition) != null) {
                        //The index has to be shifted by one to start at 0
                        piecesTemp[i - 1] = this.board.getPiece(adjacentPosition);
                    } else {
                        //break the loop if one stone os missing
                        break;
                    }
                }
                //check if the last spot has a stone
                if(piecesTemp[3] != null) {
                    fourString.add(piecesTemp);
                }
            }
        }
        //Type Cast for the toArray method
        Piece[][] returnArray = new Piece[fourString.size()][4];
        returnArray = fourString.toArray(returnArray);
        return returnArray;
    }

    public Board getBoard() {
        return board;
    }

    public Pieces getPieces() {
        return pieces;
    }
    public void updateBoard(Board newBoard) {
        this.board = newBoard;
    }
    public void updatePieces(Pieces newPieces) {
        this.pieces = newPieces;
    }
}
