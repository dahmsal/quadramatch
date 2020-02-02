import edu.kit.informatik.Terminal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Input manager
 * @author dahms
 * @version 1
 */
public class Input {
    /**
     * empty constructor
     */
    public Input() {
    }

    /**
     * Parses the input and returns the corresponding command
     * @param userInput user input
     * @return command
     * @throws IllegalArgumentException if no viable command could be parsed
     */
    public Commands inputHandler(String userInput) {
        //change syntax from inputs to ensure correct regex for [n n] and [n;n]
        String input = userInput.replace(";", " ");
        if (input.matches("^(start)\\s(standard|torus)$")) {
            return Commands.START;
        }
        if (input.matches("^(select)\\s\\d+")) {
            return Commands.SELECT;
        }
        if (input.matches("^(place)\\s\\d+\\s\\d+")) {
            return Commands.PLACE;
        }
        if (input.matches("^(bag)")) {
            return Commands.BAG;
        }
        if (input.matches("^(rowprint)\\s\\d+")) {
            return Commands.ROWPRINT;
        }
        if (input.matches("^(colprint)\\s\\d+")) {
            return Commands.COLPRINT;
        }
        if (input.matches("^(quit)") || input.matches("q")) {
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
        if (input.matches("^(start)\\s(standard)$")) {
            return Arguments.STANDARD;
        }
        if (input.matches("^(start)\\s(torus)$")) {
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
            if (match.find()) {
                return Integer.parseInt(match.group().trim());
            }
            throw new NullPointerException();
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
            int i = 0;
            while (match.find()) {
                returnInt[i] = Integer.parseInt(match.group().trim());
                i++;
            }
        } catch (NumberFormatException e) {
            Terminal.printError("Problems while parsing the int[]");
            throw new IllegalArgumentException();
        }
        return returnInt;
    }
}

