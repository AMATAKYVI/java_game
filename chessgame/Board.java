package chessgame;

public class Board {
    private Spot[][] spots = new Spot[8][8];

    public Board() {
        super();

        // Initialize the board with empty spots
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots[i].length; j++) {
                this.spots[i][j] = new Spot(i, j, null);
            }
        }

        // Place white pieces
        placeInitialPieces(true);
        // Place black pieces
        placeInitialPieces(false);
    }

    // manually set piece
    private void placeInitialPieces(boolean isWhite) {
        // Pawns white
        spots[1][0].setPiece(new Pawn(isWhite));
        spots[1][1].setPiece(new Pawn(isWhite));
        spots[1][2].setPiece(new Pawn(isWhite));
        spots[1][3].setPiece(new Pawn(isWhite));
        spots[1][4].setPiece(new Pawn(isWhite));
        spots[1][5].setPiece(new Pawn(isWhite));
        spots[1][6].setPiece(new Pawn(isWhite));
        spots[1][7].setPiece(new Pawn(isWhite));

        // Pawns black
        spots[6][0].setPiece(new Pawn(!isWhite));
        spots[6][1].setPiece(new Pawn(!isWhite));
        spots[6][2].setPiece(new Pawn(!isWhite));
        spots[6][3].setPiece(new Pawn(!isWhite));
        spots[6][4].setPiece(new Pawn(!isWhite));
        spots[6][5].setPiece(new Pawn(!isWhite));
        spots[6][6].setPiece(new Pawn(!isWhite));
        spots[6][7].setPiece(new Pawn(!isWhite));

        // Rooks
        spots[0][0].setPiece(new Rook(isWhite));
        spots[0][7].setPiece(new Rook(isWhite));
        spots[7][0].setPiece(new Rook(!isWhite));
        spots[7][7].setPiece(new Rook(!isWhite));

        // Knights
        spots[0][1].setPiece(new Knight(isWhite));
        spots[0][6].setPiece(new Knight(isWhite));
        spots[7][1].setPiece(new Knight(!isWhite));
        spots[7][6].setPiece(new Knight(!isWhite));

        // Bishops
        spots[0][2].setPiece(new Bishop(isWhite));
        spots[0][5].setPiece(new Bishop(isWhite));
        spots[7][2].setPiece(new Bishop(!isWhite));
        spots[7][5].setPiece(new Bishop(!isWhite));
        // Queens
        spots[0][3].setPiece(new Queen(isWhite));
        spots[7][3].setPiece(new Queen(!isWhite));

        // Kings
        spots[0][4].setPiece(new King(isWhite));
        spots[7][4].setPiece(new King(!isWhite));
    }

    public Spot getSpot(int x, int y) {
        return spots[x][y];
    }

    public void movePiece(int startX, int startY, int endX, int endY) {
        Spot startSpot = spots[startX][startY];
        Spot endSpot = spots[endX][endY];
        endSpot.setPiece(startSpot.getPiece());
        startSpot.setPiece(null);
    }
}
