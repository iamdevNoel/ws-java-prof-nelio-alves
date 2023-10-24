package chess_system.src.boardgame;

public class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		position = null; //Positions are defined only after game has started
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}
	
}
