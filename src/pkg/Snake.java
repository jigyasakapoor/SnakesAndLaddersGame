package pkg;

class Snake
{
	private Tile head;
	private Tile tail;
	
	public Snake(Tile head, Tile tail) 
	{		
		this.head = head;
		this.tail = tail;
	}

	public Tile getHead() {
		return head;
	}

	public Tile getTail() {
		return tail;
	}	
}
