import edu.kit.informatik.Terminal;
import java.util.ArrayList;
/**
 * The Board stores the placed pieces and their positions
 *
 */
public class Board {
    private final Piece [] [] board;
    private final Pieces pieces;
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

    /**
     * Find adjacent stones to the stone at the given index
     * @param pos the x and y coordinate in a vector
     * @throws NullPointerException if the result array is empty, ergo no stones are adjacent
     * @return Type:Integer[][], the first Index is used to access the stones, the second is used for coordinates
     */
    public Integer[][] adjacentStonesStandard(Integer[] pos) {
        ArrayList<Integer[]> result = new ArrayList<>();
        Integer[] positionTemp = new Integer[2];
        //check above, if the stone is in the first row do nothing
        if (pos[0] != 0) {
            if (board[(pos[0] - 1)][pos[1]] != null) {
                positionTemp[0] = pos[0] - 1;
                positionTemp[1] = pos[1];
                result.add(positionTemp);
            }
        }
        //check right above
        if (pos[0] != 0 && pos[1] != 5) {
            if (board[(pos[0] - 1)][(pos[1] + 1)] != null) {
                positionTemp[0] = pos[0] - 1;
                positionTemp[1] = pos[1] + 1;
                result.add(positionTemp);
            }
        }
        //check right
        if (pos[1] != 5) {
            if (board[(pos[0])][(pos[1] + 1)] != null) {
                positionTemp[0] = pos[0];
                positionTemp[1] = pos[1] + 1;
                result.add(positionTemp);
            }
        }
        //check down right
        if (pos[0] != 5 && pos[1] != 5) {
            if (board[(pos[0] + 1)][(pos[1] + 1)] != null) {
                positionTemp[0] = pos[0] + 1;
                positionTemp[1] = pos[1] + 1;
                result.add(positionTemp);
            }
        }
        //check down
        if (pos[0] != 5) {
            if (board[(pos[0] + 1)][(pos[1])] != null) {
                positionTemp[0] = pos[0] + 1;
                positionTemp[1] = pos[1];
                result.add(positionTemp);
            }
        }
        //check down left
        if (pos[0] != 5 && pos[1] != 0) {
            if (board[(pos[0] + 1)][(pos[1] - 1)] != null) {
                positionTemp[0] = pos[0] + 1;
                positionTemp[1] = pos[1] - 1;
                result.add(positionTemp);
            }
        }
        //check left
        if (pos[1] != 0) {
            if (board[(pos[0])][(pos[1] - 1)] != null) {
                positionTemp[0] = pos[0];
                positionTemp[1] = pos[1] - 1;
                result.add(positionTemp);
            }
        }
        //check left above
        if (pos[0] != 0 && pos[1] != 0) {
            if (board[(pos[0] - 1)][(pos[1] - 1)] != null) {
                positionTemp[0] = pos[0] - 1;
                positionTemp[1] = pos[1] - 1;
                result.add(positionTemp);
            }
        }
        //Type Cast for the toArray method
        Integer[][] resultArray = new Integer[result.size()][2];
        resultArray = result.toArray(resultArray);
        return resultArray;
    }
    /**
     * Returns all used positions on the board
     * @throws NullPointerException if no stones are placed on the board
     * @return Type:Integer[][], the first Index is used to access the stones, the second is used for coordinates
     */
    public Integer[][] usedPositions() {
        ArrayList<Integer[]> positions = new ArrayList<>();
        Integer [] positionTemp = new Integer[2];
        //Iterate through every field on the matrix
        for(int i = 0; i < this.board.length; i++) {
            for(int j = 0; j < this.board[1].length; j++) {
                if(this.board[i][j] != null) {
                    positionTemp[0] = i;
                    positionTemp[1] = j;
                    positions.add(positionTemp);
                }
            }
        }
        //Type Cast for the array list, the first Index is used to access the stones, the second is used for coordinates
        Integer[][] positionsArray = new Integer[positions.size()][2];
        positionsArray = positions.toArray(positionsArray);
        return positionsArray;
    }
    /**
     * Return the element at the given position
     * @param position position on the board
     */
    public Piece getPiece(Integer[] position) {
        try {
            return this.board[position[0]][position[1]];
        } catch (NullPointerException e) {
            return null;
        }
    }
}

