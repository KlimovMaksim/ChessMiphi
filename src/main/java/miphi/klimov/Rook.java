package miphi.klimov;

public class Rook extends ChessPiece {

    public Rook(String colour) {
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

        // check movement complies with the Rook rules
        if (line != toLine && column != toColumn) return false;

        // check way is free
        if (line == toLine) { // horizontal movement
            int step = (toColumn > column) ? 1 : -1;
            for (int currentColumn = column + step; currentColumn != toColumn; currentColumn += step) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false; // if there is a piece on the way, no move is possible
                }
            }
        } else { // vertical movement
            int step = (toLine > line) ? 1 : -1;
            for (int currentLine = line + step; currentLine != toLine; currentLine += step) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false; // if there is a piece on the way, no move is possible
                }
            }
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
