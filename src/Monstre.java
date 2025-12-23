
public class Monstre {
    private String couleur;
    private String lettre;
    
    public Monstre(String couleur, String lettre) {
        this.couleur = couleur;
        this.lettre = lettre;
    }

    public String getCouleur() {
        return couleur;
    }
    public String getNumero() {
        return lettre;
    }

    public boolean estEgal(Monstre autre) {
        return this.couleur.equals(autre.getCouleur()) && this.lettre.equals(autre.getNumero());
    }
}
