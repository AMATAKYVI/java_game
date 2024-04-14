package chessgame;

public class Pawn extends Piece {

    public Pawn(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        int startX = start.getX();
        int startY = start.getY();
        int endX = end.getX();
        int endY = end.getY();

        // Check if the pawn is moving one step up
        if (startX - endX == 1 && startY == endY && end.getPiece() == null) {
            return true;
        }

        // Check if the pawn is moving two steps up on its first move
        if (startX == 6 && endX == 4 && startY == endY && end.getPiece() == null) {
            // Check if there are no pieces blocking its path
            Spot spot = board.getSpot(5, startY);
            return spot.getPiece() == null;
        }
        // For other moves, pawn can only move diagonally to capture
        if (Math.abs(startX - endX) == 1 && Math.abs(startY - endY) == 1) {
            // Check if there's a piece of the opposite color to capture
            return end.getPiece() != null && end.getPiece().isWhite() != this.isWhite();
        }

        return false;
    }


    @Override
    public PieceType getType() {
        return PieceType.PAWN;
    }

    // public String toString() {
    // return PieceType.PAWN.toString();
    // }
}
