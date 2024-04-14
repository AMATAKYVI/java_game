package chessgame;

public class Bishop extends Piece {
    public Bishop(boolean white) {
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

        // Bishops move diagonally, so deltaX must equal deltaY for a valid move
        return deltaX == deltaY;
    }

    @Override
    public PieceType getType() {
        return PieceType.BISHOP;
    }
}
