public class Arbre {

  public static void main(String[] args) {
    Personne titi = instancierPersonne("Titi", "Titi", "1 avril", "Male");
    Personne toto = instancierPersonne("Toto", "Toto", "1 avril", "Femelle");

    Relation mariage = instancierMariage(titi.prenom, toto.prenom);
    System.out.println(mariage.type);

    Relation parente = instancierParente(titi.prenom, toto.prenom);
    System.out.println(parente.type);
  }

  public static Personne instancierPersonne(
      String Nom, String Prenom, String DateNaissance, String Sexe) {
    return new Personne(Nom, Prenom, DateNaissance, Sexe);
  }

  public static Relation instancierMariage(String Prenom1, String Prenom2) {
    return new Relation("Mariage", Prenom1, Prenom2);
  }

  public static Relation instancierParente(String Prenom1, String Prenom2) {
    return new Relation("Parenté", Prenom1, Prenom2);
  }
}
