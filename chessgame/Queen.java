package chessgame;

public class Queen extends Piece {
    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        int deltaX = Math.abs(endX - startX);
        int deltaY = Math.abs(endY - startY);

        // Queen combines the movement of a Rook and a Bishop
        return (startX == endX || startY == endY) || (deltaX == deltaY);
    }


    @Override
    public PieceType getType() {
        return PieceType.QUEEN;
    }
}
