package chess_system.src.chess.pieces;

import chess_system.src.boardgame.Board;
import chess_system.src.chess.ChessPiece;
import chess_system.src.chess.Color;

public class King extends ChessPiece {

	public King(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "K";
	}
	
}
