import edu.kit.informatik.Terminal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;
public class Input {

    public Input() {
    }

    /**
     * Parses the input and returns the corresponding command
     * @param input user input
     * @return command
     * @throws IllegalArgumentException if no viable command could be parsed
     */
    public Commands inputHandler (String input) {
        if(input.matches("^(start)\\s(standard|torus)$")) {
            return Commands.START;
        }
        if(input.matches("^(select)")) {
            return Commands.SELECT;
        }
        if(input.matches("^(place)")) {
            return Commands.PLACE;
        }
        if(input.matches("^(bag)")) {
            return Commands.BAG;
        }
        if(input.matches("^(rowprint)")) {
            return Commands.ROWPRINT;
        }
        if(input.matches("^(colprint)")) {
            return Commands.COLPRINT;
        }
        if(input.matches("^(quit)")) {
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
    public Arguments startArgument(String input) {
        if (input.matches("(standard)$")) {
            return Arguments.STANDARD;
        }
        if (input.matches("(torus)$")) {
            return Arguments.TORUS;
        }
        throw new IllegalArgumentException();
    }

    /**
     * Extract the int-arg of the select command, synatx:select <int>
     * Also used for rowprint and colprint
     * @param input user input
     * @return the input argument as integer
     * @throws IllegalArgumentException if the int could not be parsed
     */
    public int selectArgument(String input) {
        //regex all numbers from the input
        Pattern number = Pattern.compile("\\d+");
        Matcher match = number.matcher(input);
        try {
            return Integer.parseInt(match.group());
        } catch (NumberFormatException e) {
            Terminal.printError("Problems while parsing the input");
            throw new IllegalArgumentException();
        }
    }

    /**
     * Extract the int[] for the position
     * @param input user input
     * @return the position as int[]
     * @throws IllegalArgumentException if the int[] could not be parsed
     */
    public int[] placeArgument(String input) {
        //regex all numbers from the input
        Pattern number = Pattern.compile("\\d+");
        Matcher match = number.matcher(input);
        int[] returnInt = new int[2];
        try {
            returnInt[0] = Integer.parseInt(match.group(0));
            returnInt[1] = Integer.parseInt(match.group(1));
        } catch (NumberFormatException e) {
            Terminal.printError("Problems while parsing the int[]");
            throw new IllegalArgumentException();
        }
        return returnInt;
    }
}

