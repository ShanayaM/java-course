package main.java.space.harbour.java.chat;

import org.bson.Document;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public final class ChatHandler extends Thread {
    private final ChatServer server;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;

    private final String usrName;

    public String getUserName() {
        return usrName;
    }

    public ChatHandler(final ChatServer svr,
                       final Socket sock) throws IOException {
        this.server = svr;
        this.socket = sock;

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        usrName = in.readUTF();
        server.broadcast(usrName, "New chat member "
                + usrName + " from " + socket.getInetAddress(), false);

        for (Document doc: server.getChatDB().execGetChats()) {
            String user = doc.getString(ChatDatabaseHandler.USER_FIELD);
            String msg = doc.getString(ChatDatabaseHandler.MESSAGE_FIELD);
            out.writeUTF(user + ": " + msg);
        }
        out.flush();
    }

    public void run() {
        try (socket; in; out) {
            while (true) {
                if (in.available() > 0) {
                    server.broadcast(usrName,
                            usrName + ": " + in.readUTF(), true);
                }
            }
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
            server.chatDisconnected(this);
        }
    }

    public void sendMessage(final String user, final String message,
                            final boolean isNotTyping) {
        try {
            out.writeUTF(user + (isNotTyping ? ": " : " ") + message);
            out.flush();
        } catch (IOException e) {
            System.out.println("Connection to user is lost");
            server.chatDisconnected(this);
        }
    }
}
