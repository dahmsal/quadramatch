import java.lang.String;
public class IO {

    public IO() {
    }

    /**
     * Parses the input and returns the corresponding command
     * @param input user input
     * @return command
     * @throws IllegalArgumentException if no viable command could be parsed
     */
    public Commands inputHandler (String input) {
        if(input.matches("^start")) {
            return Commands.START;
        }
        if(input.matches("^select")) {
            return Commands.SELECT;
        }
        if(input.matches("^place")) {
            return Commands.PLACE;
        }
        if(input.matches("^bag")) {
            return Commands.BAG;
        }
        if(input.matches("^rowprint")) {
            return Commands.ROWPRINT;
        }
        if(input.matches("^colprint")) {
            return Commands.COLPRINT;
        }
        if(input.matches("^quit")) {
            return Commands.QUIT;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Return the start commands argument
     * @param input user input
     * @return the argument of the start command
     * @throws IllegalArgumentException if the argument could not be parsed
     */
    public Arguments StartArgument(String input) {
        if (input.matches("standard$")) {
            return Arguments.STANDARD;
        }
        if (input.matches("torus$")) {
            return Arguments.TORUS;
        }
        throw new IllegalArgumentException();
    }
}

