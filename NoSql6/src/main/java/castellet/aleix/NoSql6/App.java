package castellet.aleix.NoSql6;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class App {
    public static void main(String[] args) {
        // URI de conexión a MongoDB
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


/*
{"_id": {"$oid": "67ab7033a765b8b95046ae86"}, "id": 1, "muscul": "Pectoral", "data": "2021-05-01", "exercicis": [{"excercici": 1, "nom": "Press Pit", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/pectoral/pressPit.jpg", "altImg": "fotoPressPit", "descripcio": "Estira't en un banc pla amb una barra, baixa-la fins al pit i torna a pujar-la completament."}]}, {"excercici": 2, "nom": "Press Inclinat", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/pectoral/pressInclinat.jpg", "altImg": "fotoPressInclinat", "descripcio": "Col·loca't en un banc inclinat i empenta la barra cap amunt des del pit superior."}]}, {"excercici": 3, "nom": "Press Declinat", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/pectoral/pressDeclinat.jpg", "altImg": "fotoPressDeclinat", "descripcio": "Utilitza un banc declinat i mou la barra cap amunt des del pit inferior."}]}]}
{"_id": {"$oid": "67ab7033a765b8b95046ae87"}, "id": 2, "muscul": "Biceps", "data": "2022-06-01", "exercicis": [{"excercici": 1, "nom": "Curl Barra", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/biceps/curlBarra.jpg", "altImg": "fotoCurlBarra", "descripcio": "Agafa la barra amb les mans a l'amplada de les espatlles i flexiona els colzes per aixecar-la."}]}, {"excercici": 2, "nom": "Curl Martell", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/biceps/curlMartell.jpg", "altImg": "fotoCurlMartell", "descripcio": "Mantén els palmells paral·lels mentre flexiones els colzes amb les manuelles."}]}, {"excercici": 3, "nom": "Curl Concentrat", "informacio": [{"numSeries": 4, "repeticioMin": "8", "repeticioMax": "12", "tempsRepeticio": "30", "tempsDescans": "180", "foto": "/assets/biceps/curlConcentrat.jpg", "altImg": "fotoCurlConcentrat", "descripcio": "Asseu-te i recolza el colze a la cuixa per a un control total del moviment."}]}]}
*/