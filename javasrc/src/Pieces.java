import static java.awt.Color.black;

import java.util.ArrayList;
import java.util.List;
public class Pieces {
    private final Piece[] pieces = new Piece[16];

    public Pieces() {
        pieces[0] = new Piece(Attributes.black, Attributes.square, Attributes.small, Attributes.hollow, 0);
        pieces[1] = new Piece(Attributes.black, Attributes.square, Attributes.small, Attributes.massive, 1);
        pieces[2] = new Piece(Attributes.black, Attributes.square, Attributes.big, Attributes.hollow, 2);
        pieces[3] = new Piece(Attributes.black, Attributes.square, Attributes.big, Attributes.massive, 3);
        pieces[4] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.small, Attributes.hollow, 4);
        pieces[5] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.small, Attributes.massive, 5);
        pieces[6] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.big, Attributes.hollow, 6);
        pieces[7] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.big, Attributes.massive, 7);
        pieces[8] = new Piece(Attributes.white, Attributes.square, Attributes.small, Attributes.hollow, 8);
        pieces[9] = new Piece(Attributes.white, Attributes.square, Attributes.small, Attributes.massive, 9);
        pieces[10] = new Piece(Attributes.white, Attributes.square, Attributes.big, Attributes.hollow, 10);
        pieces[11] = new Piece(Attributes.white, Attributes.square, Attributes.big, Attributes.massive, 11);
        pieces[12] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.small, Attributes.hollow, 12);
        pieces[13] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.small, Attributes.massive, 13);
        pieces[14] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.big, Attributes.hollow, 14);
        pieces[15] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.big, Attributes.massive, 15);
    }

    public Piece getPiece(int i) {
        return this.pieces[i];
    }
    /**
     * Compare four Pieces
     * @param pieces The Pieces that are to be compared
     * @return a boolean, which is true if one attribute is matching for all Pieces
     */
    public boolean comparePiece(Piece[] pieces) {
        boolean result = false;
        //Compare all 4 pieces at one attribute
        if (pieces[0].getDensity() == pieces[1].getDensity() && pieces[0].getDensity() == pieces[2].getDensity()
                && pieces[0].getDensity() == pieces[3].getDensity()) {
            result = true;
        }
        if (pieces[0].getSize() == pieces[1].getSize() && pieces[0].getSize() == pieces[2].getSize()
                && pieces[0].getSize() == pieces[3].getSize()) {
            result = true;
        }
        if (pieces[0].getShape() == pieces[1].getShape() && pieces[0].getShape() == pieces[2].getShape()
                && pieces[0].getShape() == pieces[3].getShape()) {
            result = true;
        }
        if (pieces[0].getColor() == pieces[1].getColor() && pieces[0].getColor() == pieces[2].getColor()
                && pieces[0].getColor() == pieces[3].getColor()) {
            result = true;
        }
        return result;
    }
    /**
     * reset the placed flag
     */
    public void resetPieces() {
        for(Piece piece: this.pieces) {
            piece.resetPlaced();
        }
    }
    /**
     * return all unplaced pieces
     * @throws NullPointerException if no stones are left in the bag
     */
    public Integer[] getBag() {
        List<Integer> pieceId = new ArrayList<>();
        for(int i = 0; i < this.pieces.length; i++) {
            if(!this.pieces[i].isPlaced()) {
                pieceId.add(i);
            }
        }
        //Type Cast for the array list
        Integer[] bagArray = new Integer[pieceId.size()];
        bagArray = pieceId.toArray(bagArray);
        return bagArray;
    }

}