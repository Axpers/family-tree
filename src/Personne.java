public class Personne {

  // Date de mort inconnue
  public Personne(String Nom, String Prenom, String DateNaissance, String Sexe) {
    nom = Nom;
    prenom = Prenom;
    dateNaissance = DateNaissance;
    sexe = Sexe;
  }

  // Date de mort connue
  public Personne(String Nom, String Prenom, String DateNaissance, String DateMort, String Sexe) {
    nom = Nom;
    prenom = Prenom;
    dateNaissance = DateNaissance;
    dateMort = DateMort;
    sexe = Sexe;
  }

  public String nom;

  public String prenom;

  public String dateNaissance;

  public String dateMort;

  public String sexe;
}
