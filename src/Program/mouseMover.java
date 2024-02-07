package Program;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class mouseMover extends JFrame {

    private Timer timer;

    public mouseMover() {
        timer = new Timer(60000, new ActionListener() { // 60000 milliseconds = 1 minute
            @Override
            public void actionPerformed(ActionEvent e) {
                moveMouse();
            }
        });
        timer.start();
    }

    private void moveMouse() {
        try {
            Robot robot = new Robot();
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) (Math.random() * screenSize.width);
            int y = (int) (Math.random() * screenSize.height);
            robot.mouseMove(x, y);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mouseMover mouseMover = new mouseMover();
            mouseMover.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mouseMover.setVisible(true);
        });
    }
}
