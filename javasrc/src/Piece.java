import edu.kit.informatik.Terminal;

/**
 * The playing piece of the game
 * @author dahms
 * @version 1
 */
public class Piece {
    private Attributes color;
    private Attributes shape;
    private Attributes size;
    private Attributes density;
    private boolean placed;
    private int id;

    /**
     * A piece is initialised with all attributes
     * @param color attribute
     * @param shape attribute
     * @param size attribute
     * @param density attribute
     * @param id int
     */
    public Piece( Attributes color, Attributes shape, Attributes size, Attributes density, int id ) {
        if ( color == Attributes.black || color == Attributes.white) {
            this.color = color;
        }
        else {
            Terminal.printError("Invalid Color");
            throw new IllegalArgumentException();
        }
        if ( shape == Attributes.square || shape == Attributes.cylindrical) {
            this.shape = shape;
        }
        else {
            Terminal.printError("Invalid Shape");
            throw new IllegalArgumentException();
        }
        if ( size == Attributes.small || size == Attributes.big) {
            this.size = size;
        }
        else {
            Terminal.printError("Invalid Size");
            throw new IllegalArgumentException();
        }
        if ( density == Attributes.massive || density == Attributes.hollow) {
            this.density = density;
        }
        else {
            Terminal.printError("Invalid Density");
            throw new IllegalArgumentException();
        }
        this.placed = false;
        this.id = id;
    }

    /**
     *
     * @return the color of the piece
     */
    public Attributes getColor() {
        return color;
    }

    /**
     *
     * @return the density of the piece
     */
    public Attributes getDensity() {
        return density;
    }

    /**
     *
     * @return the shape of the piece
     */
    public Attributes getShape() {
        return shape;
    }

    /**
     *
     * @return the size of the piece
     */
    public Attributes getSize() {
        return size;
    }

    /**
     * Is the piece placed ?
     * @return true if placed
     */
    public boolean isPlaced() {
        return placed;
    }

    /**
     * Set the placed attribute
     */
    public void setPlaced() {
        this.placed = true;
    }

    /**
     * reset the placed attribute
     */
    public void resetPlaced() { this.placed = false; }

    /**
     * get the Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * ToString method for a piece
     * @return output string
     */
    @Override
    public String toString() {
        return this.color + ";" +  this.shape + ";" + this.size + ";" + this.density;
    }
}
