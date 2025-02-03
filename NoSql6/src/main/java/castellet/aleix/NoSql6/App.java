package castellet.aleix.NoSql6;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class App {

    private static final String URI = "mongodb+srv://Aleix:Aleix@hikaruryu0.9hefn.mongodb.net/?retryWrites=true&w=majority&appName=HikaruRyu0";
    private static final String DATABASE_NAME = "EntrenamentDB";
    private static final String COLLECTION_NAME = "Entrenament";

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            // Retrieve and print all documents
            retrieveAndPrintDocuments(collection);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void retrieveAndPrintDocuments(MongoCollection<Document> collection) {
        FindIterable<Document> documents = collection.find();
        for (Document doc : documents) {
            System.out.println(doc.toJson());
        }
    }
}