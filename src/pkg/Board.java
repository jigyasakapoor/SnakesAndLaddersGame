package pkg;

import java.util.ArrayList;
import java.util.Random;

class Board 
{
	private int boardSize;
	private ArrayList<Tile> board;
	
	public Board(int boardSize)
	{
		this.boardSize = boardSize;
		board = new ArrayList<Tile>();
		int i = 0;
		while(i <= boardSize)
		{
			Tile t = new Tile(i);
			board.add(t);
			i++;
		}
	}

	public int getBoardSize() {
		return boardSize;
	}

	public ArrayList<Tile> getBoard() {
		return board;
	}
	
	public void addSnake(Tile head, Tile tail)
	{
		Snake s = new Snake(head, tail);
		head.setSnake(s);
		head.setHasSnakeOrLadder(true);
		tail.setHasSnakeOrLadder(true);	
	}
	
	public void addLadder(Tile bottom, Tile top)
	{
		Ladder l = new Ladder(bottom, top);
		bottom.setLadder(l);
		bottom.setHasSnakeOrLadder(true);
		top.setHasSnakeOrLadder(true);
	}
	
	public void snakeBite(Player p)
	{
		Tile newTile = p.getCurrentTile().getSnake().getTail();
		p.setCurrentTile(newTile);
	}
	
	public void climbLadder(Player p)
	{
		Tile newTile = p.getCurrentTile().getLadder().getTop();
		p.setCurrentTile(newTile);
		p.setPlayersTurn(true);
	}
	
	public int rollDice()
	{
		Random rand = new Random();
	    int randomNum = rand.nextInt(6) + 1;
	    return randomNum;
	}
	
}
