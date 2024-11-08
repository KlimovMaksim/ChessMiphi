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
        if (!isValidMovePosition(chessBoard, line, column, toLine, toColumn)) return false;

        // check movement complies with the Horse rules
        int deltaX = Math.abs(column - toColumn);
        int deltaY = Math.abs(line - toLine);
        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
