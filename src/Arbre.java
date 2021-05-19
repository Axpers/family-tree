import java.util.*;

public class Arbre {

  public static Vector<Personne> tableauPersonnes = new Vector<Personne>();

  public static void main(String[] args) {
    Choix();
  }

  private static void Choix() {
    Scanner lecteur = new Scanner(System.in);
    System.out.println("");
    System.out.println("Que voulez vous faire ?");
    System.out.println("Choix 1 : Créer une personne");
    System.out.println("Choix 2 : Size du tableau de personnes");
    System.out.println("Choix 3 : Je veux sortir désolé..");
    System.out.println("Choix 4 : Marier deux personnes");

    int choixUtilisateur = lecteur.nextInt();

    // CREER UNE PERSONNE
    if (choixUtilisateur == 1) {

      tableauPersonnes.add(instancierPersonne());
      Choix();

      // TAILLE DU TABLEAU
    } else if (choixUtilisateur == 2) {

      Personne toto = new Personne("Toto", "Toto", "Toto", "Toto");
      tableauPersonnes.add(toto);

      System.out.println("Taille du tableau : " + tableauPersonnes.size());
      Choix();

      // QUITTER LE PROGRAMME
    } else if (choixUtilisateur == 3) {
      System.out.println("Vous quittez le programme");
      System.exit(0);

      // MARIAGE
    } else if (choixUtilisateur == 4) {
      System.out.println("Quel est la première personne ?");
      String personne1 = lecteur.nextLine();

      System.out.println("Quel est la deuxième personne ?");
      String personne2 = lecteur.nextLine();

      // APPELER LA METHODE TrouverParPrenom
    } else {
      System.out.println("Obligé de choisir un choix.");
      Choix();
    }
  }

  private static Personne instancierPersonne() {
    Scanner lecteur = new Scanner(System.in);
    System.out.println("Voulez-vous créer une personne ?");
    System.out.println("Répondez par oui ou non");
    String ajoutNouvellePersonne = lecteur.nextLine().toLowerCase();
    if (ajoutNouvellePersonne.equals("oui")) {

      // PRENOM
      System.out.println("Quel est son prénom ?");
      String Prenom = lecteur.nextLine();

      // NOM
      System.out.println("Quel est son nom de famille ?");
      String Nom = lecteur.nextLine();

      // DATE NAISSANCE
      System.out.println("Quel est sa date de naissance ?");
      String DateNaissance = lecteur.nextLine();

      // SEXE
      System.out.println("Quel est son sexe ?");
      String Sexe = lecteur.nextLine();

      return new Personne(Nom, Prenom, DateNaissance, Sexe);

    } else if (ajoutNouvellePersonne.equals("non")) {
      System.out.println("Tu veux quoi du coup?");
      System.out.println("Retour au choix des options");
      System.out.println("");
      Choix();
      return instancierPersonne();

    } else {
      System.out.println("Veuillez entrer une chaine de caractère correcte");
      System.out.println("");
      return instancierPersonne();
    }
  }

  private static Personne trouverParPrenom(String prenom) {
    for (int i = 0; i < tableauPersonnes.size(); i++) {
      if (tableauPersonnes.get(i).prenom.equals(prenom)) {
        return tableauPersonnes.get(i);
      }
    }
    return instancierPersonne();
  }

  private static void instancierMariage(Personne Personne1, Personne Personne2) {
    Relation mariage = new Relation("Mariage", Personne1, Personne2);
    Personne1.liste_mariage.add(mariage);
    Personne2.liste_mariage.add(mariage);
  }

  private static Relation instancierParente(Personne Personne1, Personne Personne2) {
    return new Relation("Parenté", Personne1, Personne2);
  }
}
