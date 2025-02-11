package castellet.aleix.NoSql6;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {
    public static void main(String[] args) {
        String uri = "mongodb+srv://Aleix:Aleix@hikaruryu0.9hefn.mongodb.net/?retryWrites=true&w=majority&appName=HikaruRyu0";
        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("EntrenametDB");
            MongoCollection<Document> collection = database.getCollection("Entrenamet");
            FindIterable<Document> documents = collection.find();
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }
        }
    }
}

