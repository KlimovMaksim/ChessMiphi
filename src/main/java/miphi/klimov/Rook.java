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
        if (!isValidMovePosition(chessBoard, line, column, toLine, toColumn)) return false;

        // check movement complies with the Rook rules
        if (line != toLine && column != toColumn) return false;

        return isPathClear(chessBoard, line, column, toLine, toColumn);
    }

    private boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (line == toLine) { // horizontal movement
            int step = (toColumn > column) ? 1 : -1;
            for (int currentColumn = column + step; currentColumn != toColumn; currentColumn += step) {
                if (chessBoard.board[line][currentColumn] != null) {
                    return false;
                }
            }
        } else { // vertical movement
            int step = (toLine > line) ? 1 : -1;
            for (int currentLine = line + step; currentLine != toLine; currentLine += step) {
                if (chessBoard.board[currentLine][column] != null) {
                    return false;
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
