package castellet.aleix.NoSql6;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import com.mongodb.client.model.Filters;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Model {
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    // Inicialització de SimpleDateFormat
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Model() {
        this.database = ConnectionManager.getConnection();
        this.collection = database.getCollection("Entrenamet");
    }

    public List<Document> obtenirTots() {
        List<Document> entrenaments = new ArrayList<>();
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            entrenaments.add(doc);
        }
        return entrenaments;
    }

    // 🔹 Mètode per inserir un entrenament
    public void inserir(Entrenament entrenament) {
        Document doc = entrenament.toDocument();
        collection.insertOne(doc);
        System.out.println("Entrenament inserit correctament!");
    }
    
    // 🔹 Mètode per obtenir entrenaments en un rang de dates
    public List<Document> obtenirPerData(Date dataInici, Date dataFi) {
        List<Document> entrenaments = new ArrayList<>();

        // Filtrant per dates
        FindIterable<Document> documents = collection.find(
            Filters.and(
                Filters.gte("data", dateFormat.format(dataInici)), // data >= dataInici
                Filters.lte("data", dateFormat.format(dataFi)) // data <= dataFi
            )
        );

        for (Document doc : documents) {
            entrenaments.add(doc);
        }

        return entrenaments;
    }
}
