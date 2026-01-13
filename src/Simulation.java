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

        while (pairesTrouvees < 9) {
            tours++;

            
            int i1 = -1;
            int i2 = -1;
            for (int k = 0; k < 18; k++) {
                if (estTrouvee[k] == false) {
                    if (i1 == -1) { i1 = k; }
                    else if (i2 == -1) { i2 = k; }
                }
            }

     
            cartes[i1].retourner(); 
            cartes[i2].retourner();

        
            for (int i = 0; i < 18; i++) {
                if (estTrouvee[i] == false) {
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
                double forceSouvenir = (cartes[i1].getValeurMemorielle() + cartes[i2].getValeurMemorielle()) / 2.0;
                if (Math.random() < forceSouvenir) {
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
        Participant v = new Participant("vieux");
        Grille g = new Grille(new Carte[3][6]);

        int nbSujets = 1000;
        double totalToursJ = 0, totalErrJ = 0;
        double totalToursV = 0, totalErrV = 0;
        double[] res = new double[2];

        for (int i = 0; i < nbSujets; i++) {
            executerSimulation(j, g, res);
            totalToursJ += res[0];
            totalErrJ += res[1];

            executerSimulation(v, g, res);
            totalToursV += res[0];
            totalErrV += res[1];
        }

        System.out.println("======= MOYENNES DE L'EXPÉRIENCE =======");
        System.out.println("JEUNES : Tours = " + (totalToursJ / nbSujets) + " | Erreurs = " + (totalErrJ / nbSujets));
        System.out.println("VIEUX  : Tours = " + (totalToursV / nbSujets) + " | Erreurs = " + (totalErrV / nbSujets));
        System.out.println("========================================");
    }
}