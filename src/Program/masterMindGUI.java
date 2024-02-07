package Program;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class masterMindGUI extends JFrame {
    private static final String[] COLORS = {"R", "G", "B", "Y", "W", "O"};
    private static final int TRIES = 10;
    private static final int CODE_LENGTH = 4;

    private String[] code;
    private int attemptsLeft;
    private JLabel feedbackLabel;
    private JTextField guessField;

    public masterMindGUI() {
        setTitle("Mastermind Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        feedbackLabel = new JLabel(" ");
        guessField = new JTextField(20);
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessButtonListener());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(new JLabel("Enter your guess: "));
        panel.add(guessField);
        panel.add(guessButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(feedbackLabel, BorderLayout.CENTER);
        mainPanel.add(panel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        initializeGame();
    }

    private void initializeGame() {
        code = generateCode();
        attemptsLeft = TRIES;
        feedbackLabel.setText("You have " + attemptsLeft + " tries remaining.");
    }

    private String[] generateCode() {
        String[] generatedCode = new String[CODE_LENGTH];
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            generatedCode[i] = COLORS[random.nextInt(COLORS.length)];
        }
        return generatedCode;
    }

    private class GuessButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guess = guessField.getText().toUpperCase();
            if (guess.length() != CODE_LENGTH || !isValidGuess(guess)) {
                feedbackLabel.setText("Invalid guess. Please enter " + CODE_LENGTH + " valid colors.");
                return;
            }

            int correctPos = countCorrectPositions(guess);
            if (correctPos == CODE_LENGTH) {
                feedbackLabel.setText("Congratulations! You guessed the code!");
                initializeGame();
            } else {
                attemptsLeft--;
                if (attemptsLeft == 0) {
                    feedbackLabel.setText("You ran out of tries. The code was: " + String.join(" ", code));
                    initializeGame();
                } else {
                    feedbackLabel.setText("Correct position: " + correctPos + " | Incorrect position: " + (CODE_LENGTH - correctPos) +
                            ". You have " + attemptsLeft + " tries remaining.");
                }
            }
            guessField.setText("");
        }

        private int countCorrectPositions(String guess) {
            int count = 0;
            for (int i = 0; i < CODE_LENGTH; i++) {
                if (guess.charAt(i) == code[i].charAt(0)) {
                    count++;
                }
            }
            return count;
        }

        private boolean isValidGuess(String guess) {
            for (char color : guess.toCharArray()) {
                if (!isValidColor(Character.toString(color))) {
                    return false;
                }
            }
            return true;
        }

        private boolean isValidColor(String color) {
            for (String validColor : COLORS) {
                if (color.equals(validColor)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new masterMindGUI().setVisible(true);
        });
    }
}
