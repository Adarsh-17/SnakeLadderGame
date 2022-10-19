package SnakeLadder;
import java.util.Deque;
import java.util.LinkedList;

public class Game {
	    Board board;
	    Dice dice;
	    Deque<Player> playersList = new LinkedList<>();
	    Player winner;
	    

	    public Game(int boardSize,int numberOfLadders,int numberOfSnakes, int numberOfPlayers){

	        initializeGame(boardSize, numberOfLadders, numberOfSnakes, numberOfPlayers);
	    }

	    private void initializeGame(int boardSize,int numberOfLadders,int numberOfSnakes, int numberOfPlayers) {

	        board = new Board(boardSize, numberOfLadders, numberOfSnakes);
	        dice = new Dice(1);
	        winner = null;
            addPlayers(numberOfPlayers);
	    }

	    public void addPlayers(int numberOfPlayers) {
	    	for(int i=0;i<numberOfPlayers;i++) {
	    		String name = "p" + (i+1);
	    		playersList.add(new Player(name , 0));
	    	}
	    }

	    public void startGame(){

	        while(winner == null) {

	            //check whose turn now
	            Player playerTurn = findPlayerTurn();
	            System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

	            //roll the dice
	            int diceNumbers = dice.rollDice();

	            //get the new position
	            int playerNewPosition = playerTurn.currentPosition + diceNumbers;
	            playerNewPosition = jumpCheck(playerNewPosition);
	            playerTurn.currentPosition = playerNewPosition;

	            System.out.println("player turn is:" + playerTurn.id + " new Position is: " + playerNewPosition);
	            //check for winning condition
	            if(playerNewPosition >= board.cells.length * board.cells.length-1){

	                winner = playerTurn;
	            }

	        }

	        System.out.println("WINNER IS:" + winner.id);
	    }


	    private Player findPlayerTurn() {
            
	        Player playerTurns = playersList.removeFirst();
	        playersList.addLast(playerTurns);
	        return playerTurns;
	    }

	    private int jumpCheck (int playerNewPosition) {

	        if(playerNewPosition > board.cells.length * board.cells.length-1 ){
	            return playerNewPosition;
	        }

	        Cell cell = board.getCell(playerNewPosition);
	        if(cell.jump != null && cell.jump.start == playerNewPosition) {
	            String jumpBy = (cell.jump.start < cell.jump.end)? "ladder" : "snake";
	            System.out.println("jump done by: " + jumpBy);
	            return cell.jump.end;
	        }
	        return playerNewPosition;
	    }

}
