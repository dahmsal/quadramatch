import edu.kit.informatik.Terminal;

public class GameLogic {
    private Board board;
    private Pieces pieces;
    private Input input;
    private GameManager gameManager;
    private Arguments gameMode;
    private int turnCount;
    private Integer stoneId;
    private int player;
    private boolean gameStatus;

    public GameLogic(){
    }

    /**
     * Clear the board, reset the turn-count and set the game-mode
     * @param userInput user generated input used to parse the game mode;
     */
    public void startCommand(String userInput) {
        try {
            gameMode = input.startArgument(userInput);
        } catch (IllegalArgumentException e) {
            Terminal.printError("Game-mode could not be selected, standard was chosen instead ");
            gameMode = Arguments.STANDARD;
        }
        this.board.clearBoard();
        this.pieces.resetPieces();
        this.turnCount = 0;
        this.player = 1;
        this.gameStatus = true;
        Terminal.printLine("OK");
    }
    /**
     * The player can select a stone, if the stone is already in use the player can pick again
     * @param userInput user input, to parse the selected stone
     * @throws IllegalArgumentException if the player switch fails
     */
    public void selectCommand(String userInput) {
        if(gameStatus) {
            if (this.stoneId == null) {
                while (true) {
                    //retry the input if it was false
                    try {
                        input.selectArgument(userInput);
                    } catch (IllegalArgumentException n) {
                        Terminal.printError("Input could not be interpreted, input again [select <id>]");
                        userInput = Terminal.readLine();
                        continue;
                    }
                    this.stoneId = input.selectArgument(userInput);
                    this.pieces = gameManager.getPieces();
                    //check if stone is placed, ask for new Id if the stone is placed
                    if (!pieces.getPiece(stoneId).isPlaced()) {
                        Terminal.printError("The stone selected is already placed, choose another [select <id>]");
                        userInput = Terminal.readLine();
                        continue;
                    }
                    //switch active player
                    switch (this.player) {
                        case 1:
                            this.player = 2;
                            break;
                        case 2:
                            this.player = 1;
                            break;
                        default:
                            throw new IllegalArgumentException();
                    }
                    Terminal.printLine("OK");
                    break;
                }
            } else {
                Terminal.printError("A piece was already selected");
            }
        } else {
            Terminal.printError("No game is running, try [start] to start a new game or [q] to quit");
        }
    }
    /**
     * The player can place stones, if the location is invalid or no stone is picked the entire turn is reset
     */
    public void placeCommand(String userInput) {
        if(gameStatus) {
            //check if a stone was picked up
            if (this.stoneId != null) {
                int[] position = new int[2];
                position = input.placeArgument(userInput);
                gameManager.updateBoard(this.board);
                gameManager.updatePieces(this.pieces);
                try {
                    gameManager.turn(stoneId, position);
                } catch (IllegalArgumentException e) {
                    Terminal.printError("The turn could not be executed, the position may be used");
                    this.stoneId = null;
                    return;
                }
                //If the command is successful update the board and bag
                this.board = gameManager.getBoard();
                this.pieces = gameManager.getPieces();
                this.stoneId = null;
                //check for win
                if (gameManager.checkWin(gameManager.findFourStringNormal())) {
                    Terminal.printLine("P" + this.player + " wins");
                    Terminal.printLine(this.turnCount);
                    this.gameStatus = false;
                    return;
                }
                //check for tie
                if (this.pieces.getBag().length == 0){
                    Terminal.printLine("draw");
                    this.gameStatus = false;
                    return;
                }
                //switch active player
                switch (this.player) {
                    case 1:
                        this.player = 2;
                        break;
                    case 2:
                        this.player = 1;
                        break;
                    default:
                        throw new IllegalArgumentException();
                }
                this.turnCount++;
                Terminal.printLine("OK");
            } else {
                Terminal.printError("No stone was picked up");
            }
        } else {
            Terminal.printError("No game is running, try [start] to start a new game or [q] to quit");
        }
    }
    /**
     * print all pieces from the bag
     */
    public void bagCommand() {
        for(Integer pieceId : this.pieces.getBag()) {
            if(!this.stoneId.equals(pieceId)) {
                Terminal.printLine(pieceId);
            }
        }
    }

    public Board getBoard() {
        return board;
    }
}
