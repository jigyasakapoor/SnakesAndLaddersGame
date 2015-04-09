package pkg;

class Tile 
{
	private int value;
	private Snake snake;
	private Ladder ladder;
	private boolean hasSnakeOrLadder;
	
	public Tile(int value) 
	{
		this.value = value;
		this.snake = null;
		this.ladder = null;
		this.hasSnakeOrLadder = false;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public Ladder getLadder() {
		return ladder;
	}

	public void setLadder(Ladder ladder) {
		this.ladder = ladder;
	}

	public int getValue() {
		return value;
	}

	public boolean getHasSnakeOrLadder() {
		return hasSnakeOrLadder;
	}

	public void setHasSnakeOrLadder(boolean hasSnakeOrLadder) {
		this.hasSnakeOrLadder = hasSnakeOrLadder;
	}	
}
