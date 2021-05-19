import java.util.*;

public class Personne {

  // Date de mort inconnue
  public Personne(String Nom, String Prenom, String DateNaissance, String Sexe) {
    this.nom = Nom;
    this.prenom = Prenom;
    this.dateNaissance = DateNaissance;
    this.sexe = Sexe;
  }

  // Date de mort connue
  public Personne(String Nom, String Prenom, String DateNaissance, String DateMort, String Sexe) {
    this.nom = Nom;
    this.prenom = Prenom;
    this.dateNaissance = DateNaissance;
    this.dateMort = DateMort;
    this.sexe = Sexe;
  }

  public String nom;

  public String prenom;

  public String dateNaissance;

  public String dateMort;

  public String sexe;

  public Vector<Relation> liste_relations = new Vector<>();
}
