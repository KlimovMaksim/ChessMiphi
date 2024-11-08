package miphi.klimov;

public abstract class ChessPiece {

    String color;
    boolean check;

    {
        check = true;
    }

    public ChessPiece(String colour) {
        this.color = colour;
    }

    public String getColor() {
        return color;
    }

    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);

    public abstract String getSymbol();

    protected boolean isValidMovePosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // check end position is within the chessboard
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        // check end and start position are different
        if (line == toLine && column == toColumn) return false;

        // check end position is enemy
        if (chessBoard.board[toLine][toColumn] != null
                && chessBoard.board[toLine][toColumn].getColor().equals(this.color)) return false;

        return true;
    }
}
