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

    for (int action = 0; action < 2; action++) {
        double tempsAction;
        
       
        if (p.getCategorie().equals("jeune")) {
            tempsAction = 3.0; 
        } else {
            tempsAction = 6.0; 
        }
        
        tempsTotal += tempsAction;
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
        for (int i = 0; i < 10; i++) {
            executerSimulation(jeune, g);
            executerSimulation(vieux, g);
        }
    }
}
