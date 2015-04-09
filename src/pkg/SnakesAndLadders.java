package pkg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SnakesAndLadders
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to Snakes and Ladders");
		System.out.println("------------------------------");
		Scanner sc = new Scanner(System.in);;
		
		//Initialize board
		int boardSize = 0;
		while(boardSize <= 0)
		{
			System.out.println("Enter the board size");
			try
			{
				boardSize = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				boardSize = 0;
				sc.nextLine();
			}
		    if(boardSize <= 0)
		    {
		    	System.out.println("Invalid board size. (Min: 1)");
		    }
		    System.out.println("------------------------------");
		}
	    Board board = new Board(boardSize);
	    
	    //Initialize players
	    int playerNumber = 0;
	    while(playerNumber < 2)
	    {
		    System.out.println("Enter the number of players");
		    try
			{
				playerNumber = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				playerNumber = 0;
				sc.nextLine();
			}
		    if(playerNumber < 2)
		    {
		    	System.out.println("Invalid number of players. (Min: 2)");
		    }
		    System.out.println("------------------------------");
	    }
	    ArrayList<Player> players = new ArrayList<Player>();
	    int i = 1;
	    while(i <= playerNumber)
	    {
	    	players.add(new Player("Player-"+i, board.getBoard().get(0), false));
	    	i++;
	    }

	    //Options
	    int option = 5;
	    while(option != 4)
	    {
		    System.out.println("Select one of the below options");
		    System.out.println("1 - Add Snake");
		    System.out.println("2 - Add Ladder");
		    System.out.println("3 - Display Board");
		    System.out.println("4 - Start Game");
		    System.out.println("0 - Exit");
		    System.out.println("------------------------------");
		    try
			{
				option = sc.nextInt();
			}
			catch(InputMismatchException e)
			{
				option = 5;
				sc.nextLine();
			}
		    
		    //Exit
		    if(option == 0)
		    {
		    	System.out.println("Bye");
		    	System.out.println("------------------------------");
		    	sc.close();
		    	System.exit(0);
		    }
		    
		    //Add Snake
		    if(option == 1)
		    {
		    	System.out.println("------------------------------");
		    	System.out.println("Enter the tile number with the head of the snake");
		    	int head;
		    	try
				{
					head = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					head = 0;
					sc.nextLine();
				}
			    if(head >= boardSize || head <= 1 || board.getBoard().get(head).getHasSnakeOrLadder())
			    {
			    	System.out.println("Invalid tile");
			    	System.out.println("------------------------------");
			    }
			    else
			    {
			    	System.out.println("------------------------------");
			    	System.out.println("Enter the tile number with the tail of the snake");
			    	int tail;
			    	try
					{
						tail = sc.nextInt();
					}
					catch(InputMismatchException e)
					{
						tail = 0;
						sc.nextLine();
					}
				    if(tail >= boardSize || tail < 1 || tail >= head || board.getBoard().get(tail).getHasSnakeOrLadder())
				    {
				    	System.out.println("Invalid tile");
				    	System.out.println("------------------------------");
				    }
				    else
				    {
				    	board.addSnake(board.getBoard().get(head), board.getBoard().get(tail));
				    	System.out.println("Snake added");
				    	System.out.println("------------------------------");
				    }
			    }
		    }
		    
		    //Add Ladder
		    else if(option == 2)
		    {
		    	System.out.println("------------------------------");
		    	System.out.println("Enter the tile number with the bottom of the ladder");
		    	int bottom;
		    	try
				{
					bottom = sc.nextInt();
				}
				catch(InputMismatchException e)
				{
					bottom = 0;
					sc.nextLine();
				}
			    if(bottom >= boardSize || bottom < 1 || board.getBoard().get(bottom).getHasSnakeOrLadder())
			    {
			    	System.out.println("Invalid tile");
			    	System.out.println("------------------------------");
			    }
			    else
			    {
			    	System.out.println("------------------------------");
			    	System.out.println("Enter the tile number with the top of the ladder");
			    	int top;
			    	try
					{
						top = sc.nextInt();
					}
					catch(InputMismatchException e)
					{
						top = 0;
						sc.nextLine();
					}
				    if(top > boardSize || top <= 1 || top <= bottom || board.getBoard().get(top).getHasSnakeOrLadder())
				    {
				    	System.out.println("Invalid tile");
				    	System.out.println("------------------------------");
				    }
				    else
				    {
				    	board.addLadder(board.getBoard().get(bottom), board.getBoard().get(top));
				    	System.out.println("Ladder added");
				    	System.out.println("------------------------------");
				    }
			    }
		    }
		    
		    //Display Board
		    else if(option == 3)
		    {
		    	System.out.println("------------------------------");
		    	System.out.println("Board size: " + boardSize);
		    	System.out.println("Number of players: " + playerNumber);
		    	ArrayList<Snake> snakes = new ArrayList<Snake>();
	    		ArrayList<Ladder> ladders = new ArrayList<Ladder>();
		    	for(i = 1; i <= boardSize; i++)
		    	{
		    		Tile t = board.getBoard().get(i);
		    		if(t.getSnake() != null)
		    		{
		    			snakes.add(t.getSnake());		    			
		    		}
		    		else if(t.getLadder() != null)
		    		{
		    			ladders.add(t.getLadder());
		    		}
		    	}
		    	System.out.println("Snakes (Head, Tail)");
		    	i = 1;
		    	for(Snake s : snakes)
		    	{
		    		System.out.println(i + ": (" + s.getHead().getValue() + ", " + s.getTail().getValue() + ")");
		    		i++;
		    	}
		    	System.out.println("Ladders (Bottom, Top)");
		    	i = 1;
		    	for(Ladder l : ladders)
		    	{
		    		System.out.println(i + ": (" + l.getBottom().getValue() + ", " + l.getTop().getValue() + ")");
		    		i++;
		    	}
		    	System.out.println("------------------------------");
		    }
		    
		    //Start Game
		    else if(option == 4)
		    {
		    	boolean gameEnded = false;
		    	String winner = "Nobody";
		    	int continueGame = 1;
		    	while(!gameEnded && continueGame == 1)
		    	{
		    		for(i = 0; i < playerNumber; i++)
		    		{
		    			Player currentPlayer = players.get(i);
		    			currentPlayer.setPlayersTurn(true);
		    			int sixCounter = 0;
		    			int prevDiceValue = 0;
		    			boolean encounteredSnakeOrLadder = false;
		    			int currentTile = currentPlayer.getCurrentTile().getValue();
		    			boolean enteredBoard = true;
		    			if(currentTile == 0)
		    			{
		    				enteredBoard = false;
		    			}
		    			while(currentPlayer.isPlayersTurn())
		    			{
			    			int diceValue = board.rollDice();
			    			System.out.println(currentPlayer.getPlayerName() + " rolled " + diceValue);
			    			if(!enteredBoard)
			    			{
			    				if(diceValue == 6)
			    				{
			    					System.out.println(currentPlayer.getPlayerName() + " enters the board");
			    				}
			    				else
			    				{
			    					System.out.println(currentPlayer.getPlayerName() + " loses turn");
			    					break;
			    				}
			    			}
			    			if(diceValue == 6 && prevDiceValue == 6)
			    			{
			    				sixCounter++;
			    				currentPlayer.setPlayersTurn(true);
			    			}
			    			if(sixCounter == 2)
			    			{
			    				currentTile = currentPlayer.getCurrentTile().getValue();
			    				currentPlayer.setPlayersTurn(false);
			    				System.out.println("Three 6's in a row. " + currentPlayer.getPlayerName() + " loses turn");
			    				break;
			    			}
			    			if(currentTile + diceValue <= boardSize || !enteredBoard)
			    			{
			    				if((currentTile + diceValue == boardSize) && diceValue == 6)
			    				{
			    					System.out.println("Invalid move. " + currentPlayer.getPlayerName() + " loses turn");
				    				currentPlayer.setPlayersTurn(false);
				    				break;
			    				}
			    				if(currentTile == 0 && !enteredBoard)
			    				{
			    					currentTile = 0;
			    					enteredBoard = true;
			    				}
			    				else
			    				{
			    					currentTile = currentTile + diceValue;
			    				}
			    				encounteredSnakeOrLadder = false;
			    				if(diceValue != 6)
			    				{
			    					currentPlayer.setPlayersTurn(false);
			    				}
			    				else
			    				{
			    					System.out.println(currentPlayer.getPlayerName() + " gets an extra turn");
			    				}
			    			}
			    			else
			    			{
			    				System.out.println("Invalid move. " + currentPlayer.getPlayerName() + " loses turn");
			    				currentPlayer.setPlayersTurn(false);
			    				encounteredSnakeOrLadder = false;
			    				break;
			    			}
			    			if(board.getBoard().get(currentTile).getSnake() != null)
			    			{
			    				currentPlayer.setCurrentTile(board.getBoard().get(currentTile));
			    				System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getCurrentTile().getValue());
			    				System.out.println(currentPlayer.getPlayerName() + " was bitten by a snake");
			    				board.snakeBite(currentPlayer);
			    				System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getCurrentTile().getValue());
			    				currentPlayer.setPlayersTurn(false);
			    				currentTile = currentPlayer.getCurrentTile().getValue();
			    				encounteredSnakeOrLadder = true;
			    			}
			    			else if(board.getBoard().get(currentTile).getLadder() != null)
			    			{
			    				currentPlayer.setCurrentTile(board.getBoard().get(currentTile));
			    				System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getCurrentTile().getValue());
			    				System.out.println(currentPlayer.getPlayerName() + " climbed a ladder");
			    				board.climbLadder(currentPlayer);
			    				System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getCurrentTile().getValue());
			    				System.out.println(currentPlayer.getPlayerName() + " gets an extra turn");
			    				currentPlayer.setPlayersTurn(true);
			    				currentTile = currentPlayer.getCurrentTile().getValue();
			    				encounteredSnakeOrLadder = true;
			    			}
			    			prevDiceValue = diceValue;
		    			}
		    			if(!encounteredSnakeOrLadder)
		    			{
		    				currentPlayer.setCurrentTile(board.getBoard().get(currentTile));
		    				System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getCurrentTile().getValue());
		    			}
		    			if(currentTile == boardSize)
		    			{
		    				gameEnded = true;
		    				winner = currentPlayer.getPlayerName();
		    				System.out.println("------------------------------");
		    				break;
		    			}
		    		}
		    		if(!gameEnded)
		    		{
			    		boolean invalidOption = true;
		    			while(invalidOption)
			    		{
			    			System.out.println("Press 1 to continue, 0 to exit");
			    			try
			    			{
			    				continueGame = sc.nextInt();
			    			}
			    			catch(InputMismatchException e)
			    			{
			    				continueGame = 2;
			    				sc.nextLine();
			    			}
				    		if(continueGame == 0 || continueGame == 1)
				    		{
				    			invalidOption = false;
				    		}
				    		else
				    		{
				    			System.out.println("Invalid option");
				    		}
				    		System.out.println("------------------------------");
			    		}
		    		}
		    	}
		    	if(continueGame == 1)
		    	{
		    		System.out.println("Game Over - Winner is " + winner);
		    	}
		    	else
		    	{
		    		System.out.println("Game Over - Aborted by user");
		    	}
		    	for(Player p : players)
		    	{
		    		System.out.println(p.getPlayerName() + " Tile: " + p.getCurrentTile().getValue());
		    	}
		    	System.out.println("Thanks for playing. Bye.");
		    	System.out.println("------------------------------");
		    	sc.close();
		    	System.exit(0);
		    }
		    
		    //Invalid Option
		    else
		    {
		    	System.out.println("Invalid option");
		    	System.out.println("------------------------------");
		    }
	    }
	}
}