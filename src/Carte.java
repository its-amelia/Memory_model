public class Carte {
    private Monstre monstre;
    private boolean estVisible = false;
    private double valeurMemorielle = 0.0;
    private int nbRetournements = 0;


    public Carte(Monstre monstre) {
        this.monstre = monstre;
    }

    public boolean estPaire(Carte autre) {
        return this.monstre.estEgal(autre.monstre);
    }

    public void retourner() {
        estVisible = !estVisible;
        if (estVisible) {
            nbRetournements++;
            double valeurAjoutee = 0.5 + (0.1 * nbRetournements); // Valeur subjective
            // plus on voit la carte, plus on s'en souvient 
            setValeurMemorielle(this.valeurMemorielle + valeurAjoutee);
        }
    }
    public boolean estVisible() {
        return estVisible;
    }
    public Monstre getMonstre() {
        return monstre;
    }
    public double getValeurMemorielle() {
        return valeurMemorielle;
    }
    public void setValeurMemorielle(double valeurMemorielle) {
        this.valeurMemorielle = valeurMemorielle;
    }



}
