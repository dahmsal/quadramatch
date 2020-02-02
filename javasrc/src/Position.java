/**
 * A Way of saving position vectors in their own vector
 * @author dahms
 * @version 1
 */
public class Position {
    private int x;
    private int y;

    /**
     * Initialise the object
     * @param x x coordinate
     * @param y y coordinate
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the x
     * @return x coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * get the y
     * @return y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param x set the coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @param y set the y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }
}
