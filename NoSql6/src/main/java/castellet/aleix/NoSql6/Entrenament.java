package castellet.aleix.NoSql6;

import org.bson.Document;
import java.util.List;

class Entrenament {
    private String data;       // Exemple: "2022-05-01"
    private String muscul;     // Exemple: "Pectoral"
    private List<Document> exercicis; // Llista d'exercicis (cada exercici pot ser un Document)

    // Constructor per inicialitzar l'objecte
    public Entrenament(String data, String muscul, List<Document> exercicis) {
        this.data = data;
        this.muscul = muscul;
        this.exercicis = exercicis;
    }

    // Mètode toDocument() per convertir l'objecte Entrenament en un Document MongoDB
    public Document toDocument() {
        // Crear un nou document i afegir les dades de l'objecte
        Document doc = new Document("data", data)
                            .append("muscul", muscul)
                            .append("exercicis", exercicis);
        return doc; // Retornar el document per poder inserir-lo a MongoDB
    }

    @Override
    public String toString() {
        return "Entrenament{" +
                "data='" + data + '\'' +
                ", muscul='" + muscul + '\'' +
                ", exercicis=" + exercicis +
                '}';
    }
}
