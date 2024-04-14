package chessgame;

public class King extends Piece {
    public King(boolean white) {
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

        // Kings can move one square in any direction
        return deltaX <= 1 && deltaY <= 1;
    }

    @Override
    public PieceType getType() {
        return PieceType.KING;
    }
}
