package miphi.klimov;

public class Horse extends ChessPiece {

    public Horse(String colour) {
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

        // check movement complies with the Horse rules
        int deltaX = Math.abs(line - toLine);
        int deltaY = Math.abs(column - toColumn);

        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
