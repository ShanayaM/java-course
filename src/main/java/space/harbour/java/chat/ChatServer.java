package main.java.space.harbour.java.chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class ChatServer {
    private Set<ChatHandler> chats = ConcurrentHashMap.newKeySet();
    private final int port = 8008;
    private ChatDatabaseHandler chatDB;

    public ChatDatabaseHandler getChatDB() {
        return chatDB;
    }

    public ChatServer() {
        chatDB = new ChatDatabaseHandler();
        try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);
            while (true) {
                ChatHandler chat = new ChatHandler(this, s.accept());
                chats.add(chat);
                chat.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed on port " + port);
        }
    }

    public synchronized void broadcast(final String user,
            final String message, final boolean isNotTyping) {
        if (isNotTyping) {
            chatDB.execInsertChat(user, message);
        }
        System.out.println("New message -> " + message);
        for (ChatHandler chat: chats) {
            chat.sendMessage(user, message, isNotTyping);
        }
    }

    public void chatDisconnected(final ChatHandler chat) {
        chats.remove(chat);
        broadcast(chat.getUserName(), "Chat member "
                + chat.getUserName() + " left", false);
    }

    public static void main(String[] args) {
        new ChatServer();
    }
}
