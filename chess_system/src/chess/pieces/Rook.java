package chess_system.src.chess.pieces;

import chess_system.src.boardgame.Board;
import chess_system.src.chess.ChessPiece;
import chess_system.src.chess.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "R";
	}
	
}
