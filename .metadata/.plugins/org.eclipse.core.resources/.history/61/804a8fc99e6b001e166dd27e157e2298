package boardgame;

public class Board {

	private Integer rows = 8;
	private Integer columns = 8;
	private Piece[][] pieces = new Piece[8][8];
	
	public Board() {
		
	}

	public Integer getRows() {
		return rows;
	}

	public Integer getColumns() {
		return columns;
	}

	public Piece getPiece(Integer row, Integer column) {
		if (!positionExists(row, column)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[row][column];
	}
	
	public Piece getPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	
	public void placePiece(Piece piece, Position position) {
		if (isThereAPiece(position)) {
			throw new BoardException("There is already a piece on position " + position);
		}
		
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	private boolean positionExists(Integer row, Integer column) {
		return row >= 0 && row < rows && column >= 0 && column < columns; 
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean isThereAPiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Position not on the board");
		}
		
		return getPiece(position) != null;
	}
	
}
