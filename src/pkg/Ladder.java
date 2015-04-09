package pkg;

class Ladder 
{
	private Tile bottom;
	private Tile top;
	
	public Ladder(Tile bottom, Tile top) 
	{		
		this.bottom = bottom;
		this.top = top;
	}

	public Tile getBottom() {
		return bottom;
	}

	public Tile getTop() {
		return top;
	}
}
