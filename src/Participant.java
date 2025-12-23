public class Participant {
    private String categorie ; // jeune vs vieux
    private double oubli; //valeur correpondant au pourcentage d'oubli d'une carte par tour


    public Participant(String categorie ) {
        this.categorie = categorie;
        if (categorie.equals("jeune")) {
            this.oubli = 0.1; //subjectif
        } else if (categorie.equals("vieux")) {
            this.oubli = 0.3; //subjectif
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
