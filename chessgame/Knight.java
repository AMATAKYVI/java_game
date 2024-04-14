package chessgame;

public class Knight extends Piece {
    public Knight(boolean white) {
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

        // Knights move in an L-shape pattern: 2 squares in one direction, 1 square in another
        return (deltaX == 1 && deltaY == 2) || (deltaX == 2 && deltaY == 1);
    }

    @Override
    public PieceType getType() {
        return PieceType.KNIGHT;
    }

}
