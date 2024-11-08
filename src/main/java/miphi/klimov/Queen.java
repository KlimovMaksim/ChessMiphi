package miphi.klimov;

public class Queen extends ChessPiece {

    public Queen(String colour) {
        super(colour);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (!isValidMovePosition(chessBoard, line, column, toLine, toColumn)) return false;

        int deltaX = Math.abs(column - toColumn);
        int deltaY = Math.abs(line - toLine);

        // check movement complies with the Queen rules
        if (deltaX == deltaY || line == toLine || column == toColumn) {
            return isPathClear(chessBoard, line, column, toLine, toColumn);
        }

        return false;
    }

    private boolean isPathClear(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepX = Integer.compare(toLine, line);
        int stepY = Integer.compare(toColumn, column);

        int currentLine = line + stepX;
        int currentColumn = column + stepY;

        while (currentLine != toLine || currentColumn != toColumn) {
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
        return "Q";
    }
}
