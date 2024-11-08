package miphi.klimov;

public class Pawn extends ChessPiece {

    public Pawn(String colour) {
        super(colour);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMovePosition(chessBoard, line, column, toLine, toColumn)) return false;

        int direction = color.equals("White") ? 1 : -1;
        int startLine = color.equals("White") ? 1 : 6;

        // check first move
        if (line == startLine && toLine == line + 2 * direction && column == toColumn) {
            return chessBoard.board[toLine][toColumn] == null && chessBoard.board[line + direction][column] == null;
        }

        // check usual move
        if (toLine == line + direction && column == toColumn) {
            return chessBoard.board[toLine][toColumn] == null;
        }

        // eat
        if (toLine == line + direction && (toColumn == column + 1 || toColumn == column - 1)) {
            ChessPiece targetPiece = chessBoard.board[toLine][toColumn];
            return targetPiece != null && !targetPiece.getColor().equals(this.color);
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
