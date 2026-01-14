public class Participant {
    private String categorie ; // jeune vs agé
    private double oubli; //valeur correpondant au pourcentage d'oubli d'une carte par tour



    public Participant(String categorie ) {
        this.categorie = categorie;
        if (categorie.equals("jeune")) {
            this.oubli = 0.1; // oubli faible
            
        } else if (categorie.equals("âgé")) {
            this.oubli = 0.3; //oubli fort
           
        } else {
            throw new IllegalArgumentException();
        }
    
    }
    public String getCategorie() {
        return categorie;
    }
    public double getOubli() {
        return oubli;
    }

   





}
