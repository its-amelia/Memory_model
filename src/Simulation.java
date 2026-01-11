import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Simulation {
    public static void executerSimulation(Participant p, Grille grille) {
        int tours = 0;
        int erreurs = 0;
        double tempsTotal = 0;
        int pairesTrouvees = 0;


        grille.Disposition();

        while (pairesTrouvees < 9) { 
            tours++;
            
            // Calcul du temps selon la catégorie 
            double tempsAction = (p.getCategorie().equals("jeune")) ? 3.0 : 6.0;
            tempsTotal += tempsAction;

        
            if (Math.random() > p.getOubli()) {
                pairesTrouvees++;
            } else {
                erreurs++;
            }
        }

        System.out.println("Resultats pour " + p.getCategorie() + ":");
        System.out.println("- Tours: " + tours);
        System.out.println("- Erreurs: " + erreurs);
        System.out.println("- Temps: " + tempsTotal + "s\n");
    }

    public static void main(String[] args) {
        Participant jeune = new Participant("jeune");
        Participant vieux = new Participant("vieux");
        Grille g = new Grille(new Carte[3][6]);

        System.out.println("Lancement de l'etude (N=20)...\n");
        for(int i=0; i<10; i++) {
            executerSimulation(jeune, g);
            executerSimulation(vieux, g);
        }
    }
}
    

