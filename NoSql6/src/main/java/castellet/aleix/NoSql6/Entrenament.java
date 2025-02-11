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

    	Document doc = new Document("muscul", muscul)
    						.append("data", data)
                            .append("exercicis", exercicis);
        return doc; 
    }

    @Override
    public String toString() {
        return "Entrenament{" +
                ", muscul='" + muscul + '\'' +
                "data='" + data + '\'' +
                ", exercicis=" + exercicis +
                '}';
    }
}
