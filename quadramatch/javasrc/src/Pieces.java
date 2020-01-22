import static java.awt.Color.black;

public class Pieces {
    private Piece pieces[];
    public Pieces() {
        this.pieces = new Piece[16];
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
}
