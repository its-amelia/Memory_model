public class Carte {
    private Monstre monstre;
    private boolean estVisible = false;
    private double valeurMemorielle = 0.0;


    public Carte(Monstre monstre) {
        this.monstre = monstre;
    }

    public boolean estPaire(Carte autre) {
        return this.monstre.estEgal(autre.monstre);
    }

    public void retourner() {
        estVisible = !estVisible;
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
