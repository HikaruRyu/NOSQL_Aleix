package castellet.aleix.NoSql6;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


class ConnectionManager {
    private static final String URI = "mongodb+srv://Aleix:Aleix@hikaruryu0.9hefn.mongodb.net/?retryWrites=true&w=majority&appName=HikaruRyu0";
    private static final String DB_NAME = "EntrenametDB"; // Asegúrate de que es el correcto

    public static MongoDatabase getConnection() {
        MongoClient mongoClient = MongoClients.create(URI);
        return mongoClient.getDatabase(DB_NAME);
    }
}
