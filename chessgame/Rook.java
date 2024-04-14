package chessgame;

public class Rook extends Piece {
    public Rook(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Rooks can move either horizontally or vertically
        return startX == endX || startY == endY;
    }

    @Override
    public PieceType getType() {
        return PieceType.ROOK;
    }


}
