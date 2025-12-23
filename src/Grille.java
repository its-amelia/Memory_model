public class Grille {
    private Carte[][] grille = new Carte[3][6];

    public Grille(Carte[][] grille) {
        this.grille = grille;
    }

    public Carte getCarte(int ligne, int colonne) {
        return grille[ligne][colonne];
    }

    public void Disposition() {
        // Ligne 1
        grille[0][0] = new Carte(new Monstre("Rouge", "i"));
        grille[0][1] = new Carte(new Monstre("Vert", "h"));
        grille[0][2] = new Carte(new Monstre("Violet", "b"));
        grille[0][3] = new Carte(new Monstre("Rouge", "f"));
        grille[0][4] = new Carte(new Monstre("Vert", "h"));
        grille[0][5] = new Carte(new Monstre("Noir", "e"));

        // Ligne 2
        grille[1][0] = new Carte(new Monstre("Bleu", "d"));
        grille[1][1] = new Carte(new Monstre("Rouge", "c"));
        grille[1][2] = new Carte(new Monstre("Violet", "g"));
        grille[1][3] = new Carte(new Monstre("Noir", "e"));
        grille[1][4] = new Carte(new Monstre("Bleu", "a"));
        grille[1][5] = new Carte(new Monstre("Violet", "i"));

        // Ligne 3
        grille[2][0] = new Carte(new Monstre("Bleu", "a"));
        grille[2][1] = new Carte(new Monstre("Bleu", "d"));
        grille[2][2] = new Carte(new Monstre("Rouge", "f"));
        grille[2][3] = new Carte(new Monstre("Rouge", "c"));
        grille[2][4] = new Carte(new Monstre("Violet", "b"));
        grille[2][5] = new Carte(new Monstre("Violet", "g"));

    }
    /*
     * public void afficherGrille (){
     * for (int i = 0; i < 3; i++) {
     * for (int j = 0; j < 6; j++) {
     * Carte carte = grille[i][j];
     * if (carte.estVisible()) {
     * System.out.print("[" + carte.getMonstre().getCouleur().charAt(0) +
     * carte.getMonstre().getLettre() + "] ");
     * } else {
     * System.out.print("[XX] ");
     * 
     * }
     * System.out.println();
     * 
     * }
     * }
     * 
     * }
     */

    void memorisation() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (!grille[i][j].estVisible()) {
                    grille[i][j].retourner();
                }
            }
        }
    }

}