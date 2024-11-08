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
        // check end position is within the chessboard
        if (!chessBoard.checkPos(toLine) || !chessBoard.checkPos(toColumn)) return false;

        // check end and start position are different
        if (line == toLine && column == toColumn) return false;

        // check end position is enemy
        if (chessBoard.board[toLine][toColumn] != null
                && chessBoard.board[toLine][toColumn].getColor().equals(this.color)) return false;

        // check movement complies with the Queen rules
        int deltaX = Math.abs(column - toColumn);
        int deltaY = Math.abs(line - toLine);

        // check way is free
        if (deltaX == deltaY || line == toLine || column == toColumn) {
            int stepX = Integer.compare(toLine, line);
            int stepY = Integer.compare(toColumn, column);

            int currentLine = line + stepX;
            int currentColumn = column + stepY;

            while (currentLine != toLine || currentColumn != toColumn) {
                if (chessBoard.board[currentLine][currentColumn] != null) {
                    return false; // if there is a piece on the way, no move is possible
                }
                currentLine += stepX;
                currentColumn += stepY;
            }
            return true;
        }

        return false;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
