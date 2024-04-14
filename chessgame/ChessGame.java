package chessgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.SwingUtilities;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ChessGame extends JFrame {
    private Board chessBoard;

    // Icons for the chess pieces (you can replace these with your own icons)
    private final ImageIcon[] pieceIcons;
    private JButton[][] buttons = new JButton[8][8];

    public ChessGame() {
        this.chessBoard = new Board();
        this.pieceIcons = loadPieceIcons();
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Chess Game");
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Spot spot = chessBoard.getSpot(i, j);
                JButton button = new JButton();
                buttons[i][j] = button; // Add this line to initialize the buttons array
                if ((i + j) % 2 == 0) {
                    button.setBackground(Color.gray);
                } else {
                    button.setBackground(Color.white);
                }
                contentPane.add(button);
                setPieceIcon(button, spot.getPiece()); // Set icon for the piece on this spot
                int finalI = i;
                int finalJ = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("Clicked on: " + finalI + ", " + finalJ);
                        Piece piece = spot.getPiece();
                        if (piece != null && piece.getType() == PieceType.PAWN) {
                            int currentX = finalI; // Current row
                            int currentY = finalJ; // Current column
                            int targetX; // Target row
                            int targetY = finalJ; // Target column

                            if (piece.isWhite()) {
                                targetX = currentX - 2; // White pawns move up
                            } else {
                                targetX = currentX + 2; // Black pawns move down
                            }

                            // Check if the target spot is within the board boundaries
                            if (targetX >= 0 && targetX < 8) {
                                Spot targetSpot = chessBoard.getSpot(targetX, targetY);
                                Spot nextSpot = chessBoard
                                        .getSpot(targetX + (piece.isWhite() ? 1 : -1), targetY);

                                if (targetSpot.isEmpty() && nextSpot.isEmpty()) {
                                    // If both the target spot and the spot in front of it are
                                    // empty, move the pawn
                                    chessBoard.movePiece(currentX, currentY, targetX, targetY);
                                    // Update the GUI to reflect the move
                                    setPieceIcon(button, null); // Clear the icon from the current
                                                                // spot
                                    setPieceIcon(getButton(targetX, targetY), piece); // Set the
                                                                                      // icon on the
                                                                                      // target spot
                                } else {
                                    // If the target spot or the spot in front of it is not empty,
                                    // the move is invalid
                                    System.out.println(
                                            "Invalid move: The target spot or the spot in front of it is not empty.");
                                }
                            } else {
                                // If the target spot is out of bounds, the move is invalid
                                System.out
                                        .println("Invalid move: The target spot is out of bounds.");
                            }
                        }
                    }
                });

            }
        }
    }

    // get corresponding button for the spot
    private JButton getButton(int x, int y) {
        return buttons[x][y];
    }

    // Load and resize the piece icons
    private ImageIcon[] loadPieceIcons() {
        ImageIcon[] icons = new ImageIcon[12];
        try {
            String[] paths = {"bishop_white.png", "king_white.png", "knight_white.png",
                    "pawn_white.png", "queen_white.png", "rook_white.png", "bishop_black.png",
                    "king_black.png", "knight_black.png", "pawn_black.png", "queen_black.png",
                    "rook_black.png"};
            for (int i = 0; i < paths.length; i++) {
                Image originalImage = ImageIO.read(new File("chessgame/icons/" + paths[i]));
                int width = 50; // Set your desired width
                int height = 50; // Set your desired height
                Image resizedImage =
                        originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                icons[i] = new ImageIcon(resizedImage);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return icons;
    }



    // Method to set icon on the button to represent the piece
    private void setPieceIcon(JButton button, Piece piece) {
        if (piece != null) {
            int index = piece.isWhite() ? piece.getType().ordinal() + 6 : piece.getType().ordinal();
            button.setIcon(pieceIcons[index]);
        } else {
            button.setIcon(null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChessGame();
            }
        });
    }
}
