package miphi.klimov;

public class Bishop extends ChessPiece {

    public Bishop(String colour) {
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

        // check movement complies with the Bishop rules
        int deltaX = Math.abs(column - toColumn);
        int deltaY = Math.abs(line - toLine);

        return deltaX == deltaY;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
