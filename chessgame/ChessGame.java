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
    private JButton selectedButton = null;
    private boolean hasPawnMoved = false;

    public ChessGame() {
        this.chessBoard = new Board();
        this.pieceIcons = loadPieceIcons();
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Chess Game");
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        // Add restart button
        JButton restartButton = new JButton("Restart");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Span 4 columns
        contentPane.add(restartButton, gbc);

        // Add start game button
        JButton startButton = new JButton("Start Game");
        gbc.gridx = 4;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Span 4 columns
        contentPane.add(startButton, gbc);

        // Add chess board buttons
        gbc.gridwidth = 1; // Span 2 columns for chess board
        gbc.gridheight = 1; // Span 2 rows for chess board
        gbc.weightx = 1.0; // Allow chess board to fill the remaining space
        gbc.weighty = 1.0; // Allow chess board to fill the available height
        gbc.gridx = 0;
        gbc.gridy = 2;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                buttons[i][j] = button;
                contentPane.add(button, gbc);
                Spot spot = chessBoard.getSpot(i, j);
                setPieceIcon(button, spot.getPiece());
                int finalI = i;
                int finalJ = j;
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (selectedButton == null) {
                            Piece piece = spot.getPiece();
                            if (piece != null && piece.getType() == PieceType.PAWN) {
                                selectedButton = button;
                                System.out.println("Selected pawn at: " + finalI + ", " + finalJ);
                                highlightValidMoves(finalI, finalJ, piece.isWhite());
                            }
                        } else {
                            int startX = getButtonX(selectedButton);
                            int startY = getButtonY(selectedButton);
                            int endX = finalI;
                            int endY = finalJ;
                            movePiece(startX, startY, endX, endY);
                            resetButtonBackground();
                            selectedButton = null;
                        }
                    }
                });
                gbc.gridx++; // Move to the next column
            }
            gbc.gridy++; // Move to the next row
            gbc.gridx = 0; // Reset column to 0
        }
    }

    // Method to restart the game
    private void restartGame() {
        // Reset the chess board
        this.chessBoard = new Board();
        // Reset button icons
        resetButtonIcons();
    }

    // Method to reset button icons
    private void resetButtonIcons() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                setPieceIcon(buttons[i][j], chessBoard.getSpot(i, j).getPiece());
            }
        }
    }

    private int getButtonX(JButton button) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (buttons[i][j] == button) {
                    return i;
                }
            }
        }
        return -1;
    }

    private int getButtonY(JButton button) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (buttons[i][j] == button) {
                    return j;
                }
            }
        }
        return -1;
    }

    private void resetButtonBackground() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j].setBackground(null);
                // if ((i + j) % 2 == 0) {
                // buttons[i][j].setBackground(Color.GRAY);
                // } else {
                // buttons[i][j].setBackground(Color.WHITE);
                // }
            }
        }
    }

    private void highlightValidMoves(int x, int y, boolean isWhite) {
        int stepForward = isWhite ? -1 : 1;
        int targetX = x + stepForward;

        // Check if the spot one step forward is empty and highlight it
        if (targetX >= 0 && targetX < 8 && chessBoard.getSpot(targetX, y).isEmpty()) {
            buttons[targetX][y].setOpaque(true);
            buttons[targetX][y].setBackground(Color.GREEN);

            // If it's the pawn's initial position, check if the spot two steps forward is empty and
            // highlight it
            if ((isWhite && x == 1) || (!isWhite && x == 6)) { // Updated condition here
                int doubleStepTargetX = targetX + stepForward;
                if (doubleStepTargetX >= 0 && doubleStepTargetX < 8
                        && chessBoard.getSpot(doubleStepTargetX, y).isEmpty()) {
                    buttons[doubleStepTargetX][y].setBackground(Color.GREEN);
                }
            }
        }

        // Check if the spot diagonally forward left has an opponent's piece, highlight it
        if (targetX >= 0 && targetX < 8 && y > 0) {
            Spot leftDiagonalSpot = chessBoard.getSpot(targetX, y - 1);
            if (!leftDiagonalSpot.isEmpty() && leftDiagonalSpot.getPiece().isWhite() != isWhite) {
                buttons[targetX][y - 1].setBackground(Color.GREEN);
            }
        }

        // Check if the spot diagonally forward right has an opponent's piece, highlight it
        if (targetX >= 0 && targetX < 8 && y < 7) {
            Spot rightDiagonalSpot = chessBoard.getSpot(targetX, y + 1);
            if (!rightDiagonalSpot.isEmpty() && rightDiagonalSpot.getPiece().isWhite() != isWhite) {
                buttons[targetX][y + 1].setBackground(Color.GREEN);
            }
        }

        // Remove highlighting for steps beyond one step forward
        for (int i = targetX + stepForward; i >= 0 && i < 8; i += stepForward) {
            if (!chessBoard.getSpot(i, y).isEmpty()) {
                break;
            }
            buttons[i][y].setBackground(null);
        }
    }



    private void movePiece(int startX, int startY, int endX, int endY) {
        Spot startSpot = chessBoard.getSpot(startX, startY);
        Spot endSpot = chessBoard.getSpot(endX, endY);

        if (startSpot.getPiece().getType() == PieceType.PAWN) {
            int stepForward = startSpot.getPiece().isWhite() ? -1 : 1;
            if (hasPawnMoved) {
                // If the pawn has moved before, only allow it to move one step forward
                if (endX - startX != stepForward || Math.abs(endY - startY) > 1) {
                    System.out.println("Invalid move: Pawn can only move forward one step.");
                    return; // Exit the method if the move is invalid
                }
            } else {
                // If the pawn hasn't moved before, allow it to move two steps forward
                if ((endX - startX != stepForward && endX - startX != 2 * stepForward)
                        || Math.abs(endY - startY) > 1) {
                    System.out.println(
                            "Invalid move: Pawn can move forward two steps on its first move.");
                    return; // Exit the method if the move is invalid
                }
            }

            // Update the flag to indicate that the pawn has moved
            hasPawnMoved = true;
        }

        // Check if the destination spot is empty
        if (endSpot.isEmpty()) {
            // Move the piece
            endSpot.setPiece(startSpot.getPiece());
            startSpot.setPiece(null);
            setPieceIcon(buttons[startX][startY], null); // Clear the icon on the start button
            setPieceIcon(buttons[endX][endY], endSpot.getPiece()); // Set the icon on the end button
        } else {
            System.out.println("Invalid move: destination spot is occupied.");
        }
        // Set the icon on the end button
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
                int width = 15; // Set your desired width
                int height = 15; // Set your desired height
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
