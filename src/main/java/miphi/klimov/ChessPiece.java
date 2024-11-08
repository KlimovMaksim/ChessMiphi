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
}
