import edu.kit.informatik.Terminal;



public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        GameLogic gameLogic = new GameLogic();
        Input input = new Input();
        Output output = new Output();
        String userInput;
       while (true) {
           userInput = Terminal.readLine();
           /*try {
               input.inputHandler(userInput);
           } catch (IllegalArgumentException e) {
               Terminal.printError("INVALID INPUT");
               continue;
           }*/
           switch (input.inputHandler(userInput)) {
               case START:
                   gameLogic.startCommand(userInput);
                   break;
               case BAG:
                    gameLogic.bagCommand();
                    break;
               case PLACE:
                   gameLogic.placeCommand(userInput);
                   break;
               case SELECT:
                   gameLogic.selectCommand(userInput);
                   break;
               case COLPRINT:
                   output.colprint(gameLogic.getBoard(), userInput);
                   break;
               case ROWPRINT:
                   output.rowprint(gameLogic.getBoard(), userInput);
                   break;
               case QUIT:
                   break;
               default:
                   Terminal.printError("Something went wrong in the input handling");
           }
           if(input.inputHandler(userInput) == Commands.QUIT) {
               break;
           }
       }
    }
}
