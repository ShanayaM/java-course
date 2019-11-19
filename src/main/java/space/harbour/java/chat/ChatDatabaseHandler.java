package main.java.space.harbour.java.chat;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public final class ChatDatabaseHandler {
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    private final int port = 27017;
    private final String host = "localhost";

    private String collectionName = "chats";
    private String dbName = "chat-db";
    public static final String MESSAGE_FIELD = "message";
    public static final String USER_FIELD = "user";

    public ChatDatabaseHandler() {
        client = new MongoClient(host, port);
        db = client.getDatabase(dbName);
        collection  = db.getCollection(collectionName);
    }

    public void execInsertChat(final String user, final String msg) {
        Document toBeAdded = new Document();
        toBeAdded.put(USER_FIELD, user);
        toBeAdded.put(MESSAGE_FIELD, msg);
        collection.insertOne(toBeAdded);
    }

    public FindIterable<Document> execGetChats() {
        return collection.find();
    }
}
