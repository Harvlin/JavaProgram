package roomChat2;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Server2 implements Runnable {
    private ArrayList<ConnectionHandler> connections;
    private ServerSocket server;
    private boolean done;
    private ExecutorService pool;
    public Server2() {
        connections = new ArrayList<>();
        done = false;
    }
    @Override
    public void run() {
        try {
            server = new ServerSocket(9999);
            pool = Executors.newCachedThreadPool();
            while (!done) {
                Socket client = server.accept();
                ConnectionHandler handler = new ConnectionHandler(client);
                connections.add(handler);
                pool.execute(handler);
            }
        } catch (IOException e) {
            shutdown();
        }
    }
    public void broadcast(String message) {
        for (Iterator<ConnectionHandler> iterator = connections.iterator(); iterator.hasNext();) {
            ConnectionHandler ch = iterator.next();
            if (ch != null) {
                try {
                    ch.sendMessage(message);
                } catch (Exception e) {
                    iterator.remove();
                }
            } else {
                iterator.remove();
            }
        }
    }
    public void shutdown() {
        done = true;
        pool.shutdown();
        try {
            if (!server.isClosed()) {
                server.close();
            }
            for (ConnectionHandler ch : connections) {
                ch.shutdown();
            }
        } catch (IOException e) {
            // ignore
        }
    }
    class ConnectionHandler implements Runnable {
        private Socket client;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;
        public ConnectionHandler(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                this.out = out;
                this.in = in;
                nickname = in.readLine();
                System.out.println(nickname + " connected to server");
                broadcast(nickname + " joined the chat!");
                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/nick")) {
                        String[] messageSplit = message.split(" ", 2);
                        if (messageSplit.length == 2) {
                            broadcast(nickname + " renamed themselves to " + messageSplit[1]);
                            System.out.println(nickname + " renamed themselves to " + messageSplit[1]);
                            nickname = messageSplit[1];
                            out.println("Successfully changed nickname to " + nickname);
                        } else {
                            out.println("Invalid");
                        }
                    } else if (message.startsWith("/quit")) {
                        System.out.println(nickname + "left the chat");
                        broadcast(nickname + " left the chat");
                        shutdown();
                    } else {
                        broadcast(nickname + ": " + message);
                    }
                }
            } catch (IOException e) {
                shutdown();
            }
        }
        public void sendMessage(String message) {
            out.println(message);
        }
        public boolean isClosed() {
            return client.isClosed();
        }
        public void shutdown() {
            try {
                in.close();
                out.close();
                if (!client.isClosed()) {
                    client.close();
                }
            } catch (IOException e) {
                // ignore
            }
        }
    }
    public static void main(String[] args) {
        Server2 server = new Server2();
        Thread thread = new Thread(server);
        thread.start();
    }
}
