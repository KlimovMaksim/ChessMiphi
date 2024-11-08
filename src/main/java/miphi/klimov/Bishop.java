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
        if (!isValidMovePosition(chessBoard, line, column, toLine, toColumn)) return false;

        // check movement complies with the Bishop rules
        int deltaX = Math.abs(column - toColumn);
        int deltaY = Math.abs(line - toLine);
        if (deltaX != deltaY) return false;

        return isPathClear(chessBoard, line, column, toLine, toColumn);
    }

    private boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepX = (toLine > line) ? 1 : -1;
        int stepY = (toColumn > column) ? 1 : -1;

        int currentLine = line + stepX;
        int currentColumn = column + stepY;

        while (currentLine != toLine && currentColumn != toColumn) {
            if (chessBoard.board[currentLine][currentColumn] != null) {
                return false;
            }
            currentLine += stepX;
            currentColumn += stepY;
        }

        return true;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
