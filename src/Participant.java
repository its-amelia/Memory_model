public class Participant {
    private String categorie ; // jeune vs vieux
    private double oubli; //valeur correpondant au pourcentage d'oubli d'une carte par tour
    private double renforcement; //si une carte est vue plusieurs fois elle est renfoée en mémoire , donc le taux d'oubli diminue 


    public Participant(String categorie ) {
        this.categorie = categorie;
        if (categorie.equals("jeune")) {
            this.oubli = 0.1; //subjectif
            this.renforcement = 0.05; //subjectif
        } else if (categorie.equals("vieux")) {
            this.oubli = 0.3; //subjectif
            this.renforcement = 0.02; //subjectif
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

    public double getRenforcement() {
        return renforcement;
    }
    




}
