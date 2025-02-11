package castellet.aleix.NoSql6;

import org.bson.Document;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class View {
    private Scanner scanner = new Scanner(System.in);
    private Model model = new Model();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void mostrarMenu() {
        while (true) {
            System.out.println("\n1. Mostrar tots els entrenaments");
            System.out.println("2. Afegir un entrenament");
            System.out.println("3. Cercar entrenaments per data");
            System.out.println("4. Sortir");
            System.out.print("Escull una opció: ");

            int opcio = scanner.nextInt();
            scanner.nextLine();

            switch (opcio) {
                case 1:
                    mostrarEntrenaments();
                    break;
                case 2:
                    inserirEntrenament();
                    break;
                case 3:
                    mostrarEntrenamentsPerData();
                    break;
                case 4:
                    System.out.println("Sortint...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opció no vàlida!");
            }
        }
    }

    private void mostrarEntrenaments() {
        List<Document> entrenaments = model.obtenirTots();
        if (entrenaments.isEmpty()) {
            System.out.println("No hi ha entrenaments disponibles.");
        } else {
            for (Document doc : entrenaments) {
                System.out.println(doc.toJson());
            }
        }
    }

    private void inserirEntrenament() {
        System.out.print("Introdueix la data (YYYY-MM-DD): ");
        String data = scanner.nextLine();

        System.out.print("Introdueix el grup muscular: ");
        String muscul = scanner.nextLine();

        List<Document> exercicis = new ArrayList<>();
        System.out.print("Quants exercicis vols afegir? ");
        int numExercicis = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numExercicis; i++) {
            System.out.print("Nom de l'exercici " + (i + 1) + ": ");
            String nom = scanner.nextLine();
            Document exercici = new Document("nom", nom);
            exercicis.add(exercici);
        }

        Entrenament entrenament = new Entrenament(data, muscul, exercicis);
        model.inserir(entrenament);
    }

    private void mostrarEntrenamentsPerData() {
        try {
            System.out.print("Introdueix la data d'inici (YYYY-MM-DD): ");
            String inici = scanner.nextLine();
            Date dataInici = dateFormat.parse(inici);

            System.out.print("Introdueix la data de fi (YYYY-MM-DD): ");
            String fi = scanner.nextLine();
            Date dataFi = dateFormat.parse(fi);

            List<Document> entrenaments = model.obtenirPerData(dataInici, dataFi);
            if (entrenaments.isEmpty()) {
                System.out.println("No hi ha entrenaments en aquest període.");
            } else {
                for (Document doc : entrenaments) {
                    System.out.println(doc.toJson());
                }
            }
        } catch (Exception e) {
            System.out.println("Error en el format de data. Torna-ho a intentar.");
        }
    }
}
