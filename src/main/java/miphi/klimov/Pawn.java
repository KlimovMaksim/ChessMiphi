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

        // check pawn moves only vertically
        if (column != toColumn) return false;

        if (color.equals("White")) {
            // first move is 2 cells forward
            if (line == 1 && toLine == line + 2) return true;

            // usual move is 1 cell forward
            if (toLine == line + 1) return true;
        }

        if (color.equals("Black")) {
            // first move is 2 cells forward
            if (line == 6 && toLine == line - 2) return true;

            // usual move is 1 cell forward
            if (toLine == line - 1) return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
