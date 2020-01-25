import edu.kit.informatik.Terminal;

public class Piece {
    private Attributes color;
    private Attributes shape;
    private Attributes size;
    private Attributes density;
    private boolean placed;

    public Piece (Attributes color,Attributes shape,Attributes size,Attributes density ) {
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
    }

    public Attributes getColor() {
        return color;
    }

    public Attributes getDensity() {
        return density;
    }

    public Attributes getShape() {
        return shape;
    }

    public Attributes getSize() {
        return size;
    }

    public boolean isPlaced() {
        return placed;
    }
    public void setPlaced() {
        this.placed = true;
    }
    @Override
    public String toString() {
        return this.color + ";"+ this.shape + ";" + this.size + ";" + this.density;
    }
}
