package chess_system.src.chess;

import chess_system.src.boardgame.ChessException;
import chess_system.src.boardgame.Position;

public class ChessPosition {

	private Character column;
	private Integer row;
	
	public ChessPosition(Character column, Integer row) {
		if (column < 'a' || column > 'h' || row < 0 || row > 8) {
			throw new ChessException("Error instantiating ChessPosition. Try values from a1 to h8.");
		}
		
		this.column = column;
		this.row = row;
	}

	public Character getColumn() {
		return column;
	}

	public Integer getRow() {
		return row;
	}

	protected Position toPosition() {
		return new Position(8 - row, column - 'a'); 
	}
	
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getColumn()), 8 - position.getRow());
	}
	
}
