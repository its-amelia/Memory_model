import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;

public class Simulation {

    public static void executerSimulation(Participant p, Grille grille, double[] resultats) {
        int tours = 0;
        int erreurs = 0;
        int pairesTrouvees = 0;

        grille.Disposition();
        Carte[] cartes = new Carte[18];
        boolean[] estTrouvee = new boolean[18];

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                cartes[index] = grille.getCarte(i, j);
                index++;
            }
        }

        double p_rappel = p.getCategorie().equals("jeune") ? 0.95 : 0.45; // probabilité de rappel

        while (pairesTrouvees < 9) { // choix des cartes
            tours++;

            int i1 = -1; 
            int i2 = -1;
            for (int k = 0; k < 18; k++) {
                if (!estTrouvee[k]) {
                    if (i1 == -1) { i1 = k; }
                    else if (i2 == -1) { i2 = k; }
                }
            }

            cartes[i1].retourner(); 
            cartes[i2].retourner();

            for (int i = 0; i < 18; i++) { // mise à jour de la valeur mémorielle 
                if (!estTrouvee[i]) {
                    double nouvelleValeur = cartes[i].getValeurMemorielle() - p.getOubli();
                    if (nouvelleValeur < 0) { nouvelleValeur = 0; }
                    cartes[i].setValeurMemorielle(nouvelleValeur);
                }
            }

            boolean reussiteTour = false;
            if (tours == 1) { 
                reussiteTour = true;
            } else if (tours == 2 && p.getCategorie().equals("jeune")) {
                reussiteTour = true;
            } else {
                double traceMnesique = (cartes[i1].getValeurMemorielle() + cartes[i2].getValeurMemorielle()) / 2.0;
                if (Math.random() < (traceMnesique * p_rappel)) {
                    reussiteTour = true;
                }
            }

            if (reussiteTour) {
                pairesTrouvees++;
                estTrouvee[i1] = true;
                estTrouvee[i2] = true;
            } else {
                erreurs++;
                cartes[i1].retourner(); 
                cartes[i2].retourner();
            }
        }
        resultats[0] = tours;
        resultats[1] = erreurs;
    }

    public static void main(String[] args) { 
        Participant j = new Participant("jeune");
        Participant v = new Participant("âgé");
        Grille g = new Grille(new Carte[3][6]);

        int nbSujets = 1000;
        double totalToursJ = 0, totalErrJ = 0;
        double totalToursV = 0, totalErrV = 0;
        double[] res = new double[2];

        try (PrintWriter writer = new PrintWriter(new File("donnees_jamovi.csv"))) {
            // Entête du fichier CSV
            writer.println("Sujet,Groupe,Source,Tours,Erreurs");

            for (int i = 0; i < nbSujets; i++) {
                // Simulation Jeune
                executerSimulation(j, g, res);
                totalToursJ += res[0];
                totalErrJ += res[1];
                writer.println((i + 15) + ",jeune,simulation," + (int)res[0] + "," + (int)res[1]);

                // Simulation âgés
                executerSimulation(v, g, res);
                totalToursV += res[0];
                totalErrV += res[1];
                writer.println((i + 1015) + ",âgé,simulation," + (int)res[0] + "," + (int)res[1]);
            }

            System.out.println("Fichier 'donnees_jamovi.csv' cree avec succes !");
            System.out.println("======= MOYENNES DE L'EXPERIENCE =======");
            System.out.println("JEUNES : Tours = " + (totalToursJ / nbSujets) + " | Erreurs = " + (totalErrJ / nbSujets));
            System.out.println("ÂGÉS  : Tours = " + (totalToursV / nbSujets) + " | Erreurs = " + (totalErrV / nbSujets));
            System.out.println("========================================");

        } catch (IOException e) {
            System.err.println("Erreur lors de la creation du fichier : " + e.getMessage());
        }
    }
}