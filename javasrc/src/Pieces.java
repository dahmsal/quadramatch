import static java.awt.Color.black;

public class Pieces {
    private final Piece[] pieces = new Piece[16];

    public Pieces() {
        pieces[0] = new Piece(Attributes.black, Attributes.square, Attributes.small, Attributes.hollow);
        pieces[1] = new Piece(Attributes.black, Attributes.square, Attributes.small, Attributes.massive);
        pieces[2] = new Piece(Attributes.black, Attributes.square, Attributes.big, Attributes.hollow);
        pieces[3] = new Piece(Attributes.black, Attributes.square, Attributes.big, Attributes.massive);
        pieces[4] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.small, Attributes.hollow);
        pieces[5] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.small, Attributes.massive);
        pieces[6] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.big, Attributes.hollow);
        pieces[7] = new Piece(Attributes.black, Attributes.cylindrical, Attributes.big, Attributes.massive);
        pieces[8] = new Piece(Attributes.white, Attributes.square, Attributes.small, Attributes.hollow);
        pieces[9] = new Piece(Attributes.white, Attributes.square, Attributes.small, Attributes.massive);
        pieces[10] = new Piece(Attributes.white, Attributes.square, Attributes.big, Attributes.hollow);
        pieces[11] = new Piece(Attributes.white, Attributes.square, Attributes.big, Attributes.massive);
        pieces[12] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.small, Attributes.hollow);
        pieces[13] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.small, Attributes.massive);
        pieces[14] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.big, Attributes.hollow);
        pieces[15] = new Piece(Attributes.white, Attributes.cylindrical, Attributes.big, Attributes.massive);
    }

    public Piece getPiece(int i) {
        return this.pieces[i];
    }
    /**
     * Compare four Pieces
     * @param pieces The Pieces that are to be compared
     * @return a boolean, which is true if one attribute is matching for all Pieces
     */
    public boolean ComparePiece(Piece[] pieces) {
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
}