import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class DiceGameGUI extends JFrame {
    private JLabel diceLabel;
    private JButton rollButton;

    public DiceGameGUI() {
        setTitle("Dice Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); // Center the frame on the screen

        // Initialize components
        diceLabel = new JLabel("Roll the dice!");
        rollButton = new JButton("Roll");

        // Add action listener to the button
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDice();
            }
        });

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the content pane
        add(diceLabel, BorderLayout.CENTER);
        add(rollButton, BorderLayout.SOUTH);
    }

    private void rollDice() {
        Random random = new Random();
        int diceValue = random.nextInt(6) + 1; // Generate a random number between 1 and 6

        // Update the dice label
        diceLabel.setText("You rolled a " + diceValue);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DiceGameGUI().setVisible(true);
            }
        });
    }
}
