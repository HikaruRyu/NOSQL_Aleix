package castellet.aleix.NoSql6;

import org.bson.Document;
import java.util.List;

class Entrenament {
    private String data;       
    private String muscul;     
    private List<Document> exercicis; 

    
    public Entrenament(String data, String muscul, List<Document> exercicis) {
        this.data = data;
        this.muscul = muscul;
        this.exercicis = exercicis;
    }

    
    public Document toDocument() {

    	Document doc = new Document("data", data)
                            .append("muscul", muscul)
                            .append("exercicis", exercicis);
        return doc; 
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
