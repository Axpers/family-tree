import java.util.*;

public class Arbre {

  private static final Scanner lecteur = new Scanner(System.in);
  public static Vector<Personne> tableauPersonnes = new Vector<>();

  public static void main(String[] args) {
    Choix();
  }

  private static void Choix() {
    System.out.println();
    System.out.println("Que voulez vous faire ?");
    System.out.println();
    System.out.println("Choix 1 : Créer une personne");
    System.out.println("Choix 2 : Afficher les informations d'une personne");
    System.out.println("Choix 3 : Sortir du programme");
    System.out.println("Choix 4 : Marier deux personnes");
    System.out.println("Choix 5 : Etablir un lien de parenté");
    String choixUtilisateur = lecteur.next();

    switch (choixUtilisateur) {
      // CREER UNE PERSONNE
      case "1" -> {
        tableauPersonnes.add(instancierPersonne());
        Choix();
      }

      // INFORMATION D'UNE PERSONNE
      case "2" -> {
        System.out.println("Quel est le nom de la personne concerncée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne PersonneAChercher = trouverParPrenom(nomPersonne);
        afficherInfoPersonne(PersonneAChercher);
        Choix();
      }

      // QUITTER LE PROGRAMME
      case "3" -> {
        System.out.println("Vous quittez le programme");
        System.exit(0);
      }


      // MARIAGE
      case "4" -> {
        saisirRelation(Relation.TypeRelation.Mariage);
        System.out.println();
        System.out.println("Les personnes ont bien été mariés");
        Choix();
      }

      // LIEN DE PARENTE
      case "5" -> {
        saisirRelation(Relation.TypeRelation.Parent);
        System.out.println();
        System.out.println("Les personnes ont bien été parentés");
        Choix();
      }

      //CHOIX PAR DEFAUT
      default -> {
        System.out.println("Veuillez entrer une chaine de caractère correcte.");
        Choix();
      }
    }
  }

  private static Personne instancierPersonne() {
    System.out.println("Voulez-vous créer une personne ?");
    System.out.println("Répondez par oui ou non");
    String ajoutNouvellePersonne = lecteur.next().toLowerCase();
    if (ajoutNouvellePersonne.equals("oui")) {

      // PRENOM
      System.out.println("Quel est son prénom ?");
      String Prenom = lecteur.next().toLowerCase();

      // NOM
      System.out.println("Quel est son nom de famille ?");
      String Nom = lecteur.next().toLowerCase();

      // DATE NAISSANCE
      System.out.println("Quel est sa date de naissance ?");
      String DateNaissance = lecteur.next();

      // SEXE
      System.out.println("Quel est son sexe ?");
      String Sexe = lecteur.next().toLowerCase();
      return new Personne(Nom, Prenom, DateNaissance, Sexe);

    } else if (ajoutNouvellePersonne.equals("non")) {
      System.out.println("Retour au choix des options");
      System.out.println();
      Choix();
      return instancierPersonne();

    } else {
      System.out.println("Veuillez entrer une chaine de caractère correcte");
      System.out.println();
      return instancierPersonne();
    }
  }

  private static Personne trouverParPrenom(String prenom) {
    for (Personne personne : tableauPersonnes) {
      if (personne.prenom.equals(prenom)) {
        return personne;
      }
    }
    System.out.println(prenom + " n'existe pas, voulez-vous l'instancier ?");
    return instancierPersonne();
  }

  private static void saisirRelation(Relation.TypeRelation type) {
    if (type == (Relation.TypeRelation.Mariage)) {
      System.out.println("Quel est le prénom de l'époux ?");
      String prenomPersonne1 = lecteur.next().toLowerCase();
      Personne personne1 = trouverParPrenom(prenomPersonne1);

      System.out.println("Quel est le prénom de l'épouse ?");
      String prenomPersonne2 = lecteur.next().toLowerCase();
      Personne personne2 = trouverParPrenom(prenomPersonne2);

      tableauPersonnes.add(personne1);
      tableauPersonnes.add(personne2);

      instancierRelation(type, personne1, personne2);
    }
    else if (type == (Relation.TypeRelation.Parent)) {
      System.out.println("Quel est le prénom du père ?");
      String prenomPere = lecteur.next().toLowerCase();
      Personne pere = trouverParPrenom(prenomPere);

      System.out.println("Quel est le prénom de la mère ?");
      String prenomMere = lecteur.next().toLowerCase();
      Personne mere = trouverParPrenom(prenomMere);

      System.out.println("Quel est le prénom de l'enfant ?");
      String prenomEnfant = lecteur.next().toLowerCase();
      Personne enfant = trouverParPrenom(prenomEnfant);
      tableauPersonnes.add(enfant);

      instancierRelation(type, pere, enfant);
      instancierRelation(type, mere, enfant);
      instancierRelation(Relation.TypeRelation.Enfant, enfant, pere);
      instancierRelation(Relation.TypeRelation.Enfant, enfant, mere);
    }
  }

  private static void instancierRelation(
      Relation.TypeRelation type, Personne personne1, Personne personne2) {
     new Relation(type, personne1, personne2);
  }

  private static void afficherInfoPersonne(Personne personne1) {
    // AFFICHER LES ATTRIBUTS
    System.out.println("Le nom de la personne est : " + personne1.nom);
    System.out.println("Le prenom de la personne est : " + personne1.prenom);
    System.out.println("Le date de naissance de la personne est : " + personne1.dateNaissance);
    System.out.println("Le date de mort de la personne est : " + personne1.dateMort);
    System.out.println("Le sexe de la personne est : " + personne1.sexe);
    System.out.println();

    // AFFICHER LA LISTE DES RELATIONS
    System.out.println("Les Relations de " + personne1.prenom + " sont :");
    System.out.println();
    for (Relation relation : personne1.liste_relations) {
      afficherRelation(relation);
    }
  }

  private static void afficherRelation(Relation relation) {
    if(relation.type == Relation.TypeRelation.Mariage){
      System.out.println(relation.personne1.prenom + " est dans une relation de type mariage avec " + relation.personne2.prenom);
    }
    else if(relation.type == Relation.TypeRelation.Parent){
      System.out.println(relation.personne1.prenom + " est le parent de " + relation.personne2.prenom);
    }
    else if(relation.type == Relation.TypeRelation.Enfant){
      System.out.println(relation.personne1.prenom + " est l'enfant de " + relation.personne2.prenom);
    }
}
}
