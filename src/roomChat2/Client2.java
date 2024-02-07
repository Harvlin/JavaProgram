package roomChat2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client2 {
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private boolean done;
    private JTextArea chatTextArea;
    private JTextField inputField;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Client2 client = new Client2();
            client.createAndShowGUI();
        });
    }
    private void createAndShowGUI() {
        JFrame frame = new JFrame("Chat Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chatTextArea = new JTextArea(10, 40);
        chatTextArea.setEditable(false);
        inputField = new JTextField(40);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(chatTextArea));
        panel.add(inputField);
        panel.add(sendButton);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
        connectToServer();
    }
    private void connectToServer() {
        try {
            client = new Socket("127.0.0.1", 9999);
            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Thread inHandlerThread = new Thread(this::handleIncomingMessages);
            inHandlerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            shutdown();
        }
    }
    private void handleIncomingMessages() {
        try {
            String inMessage;
            while (!done && (inMessage = in.readLine()) != null) {
                chatTextArea.append(inMessage + "\n");
            }
        } catch (IOException e) {
            shutdown();
        }
    }
    private void sendMessage() {
        String message = inputField.getText();
        if (!message.isEmpty()) {
            out.println(message);
            inputField.setText("");
        }
    }
    private void shutdown() {
        done = true;
        try {
            if (in != null) in.close();
            if (out != null) out.close();
            if (client != null && !client.isClosed()) client.close();
        } catch (IOException ignored) {
        }
        System.exit(0);
    }
}