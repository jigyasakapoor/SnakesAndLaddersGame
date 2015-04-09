package pkg;

class Player
{
	private String playerName;
	private Tile currentTile;
	private boolean isPlayersTurn;
	
	public Player(String playerName, Tile currentTile, boolean isPlayersTurn)
	{
		this.playerName = playerName;
		this.currentTile = currentTile;
		this.isPlayersTurn = isPlayersTurn;
	}
	
	public String getPlayerName() {
		return playerName;
	}	
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public Tile getCurrentTile() {
		return currentTile;
	}
	public void setCurrentTile(Tile currentTile) {
		this.currentTile = currentTile;
	}
	public boolean isPlayersTurn() {
		return isPlayersTurn;
	}
	public void setPlayersTurn(boolean isPlayersTurn) {
		this.isPlayersTurn = isPlayersTurn;
	}		
}
