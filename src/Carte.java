public class Carte {
    private Monstre monstre;
    private boolean estVisible = false;

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



}
