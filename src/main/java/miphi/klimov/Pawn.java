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
        // check end position is within the chessboard
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        // check end and start position are different
        if (line == toLine && column == toColumn) return false;

        // check end position is enemy
        if (chessBoard.board[toLine][toColumn] != null
                && chessBoard.board[toLine][toColumn].getColor().equals(this.color)) return false;

        // check movement complies with the White Pawn rules
        if (color.equals("White")) {
            // first move is 2 cells forward
            if (line == 1 && toLine == line + 2 && column == toColumn) return chessBoard.board[toLine][toColumn] == null;

            // usual move is 1 cell forward
            if (toLine == line + 1 && column == toColumn) return chessBoard.board[toLine][toColumn] == null;

            // eat
            if (toLine == line + 1 && (toColumn == column + 1 || toColumn == column - 1)) {
                return true;
            }
        }

        // check movement complies with the Black Pawn rules
        if (color.equals("Black")) {
            // first move is 2 cells forward
            if (line == 6 && toLine == line - 2 && column == toColumn) return chessBoard.board[toLine][toColumn] == null;

            // usual move is 1 cell forward
            if (toLine == line - 1 && column == toColumn) return chessBoard.board[toLine][toColumn] == null;

            // eat
            if (toLine == line - 1 && (toColumn == column + 1 || toColumn == column - 1)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
