
import java.util.ArrayList;
/**
 * The Board stores the placed pieces and their positions
 * @author dahms
 * @version 1
 */
public class Board {
    private  Piece [] [] board;
    private final Pieces pieces;

    /**
     * The board is initialised as a piece matrix
     */
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
        if ( this.board[position[0]][position[1]] == null ) {
            this.board[position[0]][position[1]] = pieces.getPiece(i);
        }
        else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Find adjacent stones to the stone at the given index
     * @param position the x and y coordinate in a vector
     * @param gameMode the game mode of the current game
     * @throws NullPointerException if the result array is empty, ergo no stones are adjacent
     * @return Type:Integer[][], the first Index is used to access the stones, the second is used for coordinates
     */
    public Position[] adjacentStonesStandard(Position position, Arguments gameMode) {
        ArrayList<Position> result = new ArrayList<>();
        if (position.getX() != 0) { //check above, if the stone is in the first row do nothing
            if (board[(position.getX() - 1)][position.getY()] != null) {
                result.add(new Position(position.getX() - 1, position.getY())); }
        } else if (position.getX() == 0 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() - 1) % 6][torusConvert(position.getY()) % 6] != null) {
                result.add(new Position((position.getX() - 1) % 6 , (position.getY()) % 6)); }
        }
        if (position.getX() != 0 && position.getY() != 5) {  //check right above
            if (board[(position.getX() - 1)][(position.getY() + 1)] != null) {
                result.add(new Position(position.getX() - 1, position.getY() + 1)); }
        } else if (position.getX() == 0 && position.getY() == 5 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() - 1) % 6]
                    [torusConvert(position.getY() + 1) % 6] != null) {
                result.add(new Position((position.getX() - 1) % 6, (position.getY() + 1) % 6)); }
        }
        if (position.getY() != 5) { //check right
            if (board[(position.getX())][(position.getY() + 1)] != null) {
                result.add(new Position(position.getX(), position.getY() + 1)); }
        } else if (position.getY() == 5 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX()) % 6][torusConvert(position.getY() + 1) % 6] != null) {
                result.add(new Position((position.getX()) % 6, (position.getY() + 1) % 6)); }
        }
        if (position.getX() != 5 && position.getY() != 5) { //check down right
            if (board[(position.getX() + 1)][(position.getY() + 1)] != null) {
                result.add(new Position(position.getX() + 1, position.getY() + 1)); }
        } else if (position.getX() == 5 && position.getY() == 5 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() + 1) % 6]
                    [torusConvert(position.getY() + 1) % 6] != null) {
                result.add(new Position((position.getX() + 1) % 6, (position.getY() + 1) % 6)); }
        }
        if (position.getX() != 5) { //check down
            if (board[(position.getX() + 1)][(position.getY())] != null) {
                result.add(new Position(position.getX() + 1, position.getY())); }
        } else if (position.getX() == 5 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() + 1) % 6][torusConvert(position.getY()) % 6] != null) {
                result.add(new Position((position.getX() + 1) % 6, (position.getY()) % 6)); }
        }
        if (position.getX() != 5 && position.getY() != 0) { //check down left
            if (board[(position.getX() + 1)][(position.getY() - 1)] != null) {
                result.add(new Position(position.getX() + 1, position.getY() - 1)); }
        } else if (position.getX() == 5 && position.getY() == 0 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() + 1) % 6]
                    [torusConvert(position.getY() - 1) % 6] != null) {
                result.add(new Position((position.getX() + 1) % 6, (position.getY() - 1) % 6)); }
        }
        if (position.getY() != 0) { //check left
            if (board[(position.getX())][(position.getY() - 1)] != null) {
                result.add(new Position(position.getX(), position.getY() - 1)); }
        } else if (position.getY() == 0 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX()) % 6][torusConvert(position.getY() - 1) % 6] != null) {
                result.add(new Position((position.getX()) % 6, (position.getY() - 1) % 6)); }
        }
        if (position.getX() != 0 && position.getY() != 0) { //check left above
            if (board[(position.getX() - 1)][(position.getY() - 1)] != null) {
                result.add(new Position(position.getX() - 1, position.getY() - 1)); }
        } else if (position.getX() == 0 && position.getY() == 0 && gameMode == Arguments.TORUS) {
            if (board[torusConvert(position.getX() + 1) % 6]
                    [torusConvert(position.getY() + 1) % 6] != null) {
                result.add(new Position((position.getX() - 1) % 6, (position.getY() - 1) % 6)); }
        }
        Position[] resultArray = new Position[result.size()]; //Type Cast for the toArray method
        resultArray = result.toArray(resultArray);
        return resultArray;
    }
    /**
     * Returns all used positions on the board
     * @throws NullPointerException if no stones are placed on the board
     * @return Type:Integer[][], the first Index is used to access the stones, the second is used for coordinates
     */
    public Position[] usedPositions() {
        ArrayList<Position> positions = new ArrayList<>();
        //Iterate through every field on the matrix
        for (int i = 0; i < this.board.length; i++) {
            for (int j = 0; j < this.board[1].length; j++) {
                if (this.board[i][j] != null) {
                    positions.add(new Position(i, j));
                }
            }
        }
        //Type Cast for the array list, the first Index is used to access the stones, the second is used for coordinates
        Position[] positionsArray = new Position[positions.size()];
        positionsArray = positions.toArray(positionsArray);
        return positionsArray;
    }
    /**
     * Return the element at the given position
     * @param position position on the board
     * @param gameMode current game mode
     * @return the piece at the position
     */
    public Piece getPiece(Position position, Arguments gameMode) {
        switch (gameMode) {
            case STANDARD:
                try {
                    return this.board[position.getX()][position.getY()];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
            case TORUS:
                try {
                    return this.board[torusConvert(position.getX())][torusConvert(position.getY())];
                } catch (ArrayIndexOutOfBoundsException e) {
                    return this.board[torusConvert(position.getX()) % 6][torusConvert(position.getY()) % 6];
                }
            default:
                return null;
        }
    }

    /**
     * clear the board
     */
    public void clearBoard() {
        this.board = new Piece[6][6];
    }

    /**
     * simple get
     * @return the current board
     */
    public Piece[][] getBoard() {
        return board;
    }

    /**
     * convert negative numbers to the correct position on the torus board
     * @param posVal position value
     * @return the actual value
     */
    private int torusConvert(int posVal) {
        if (posVal < 0) {
            return 6 + posVal % 6;
        } else {
            return posVal;
        }
    }
}

