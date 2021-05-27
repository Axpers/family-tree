import java.util.*;

public class Arbre {

  private static final Scanner lecteur = new Scanner(System.in);
  public static Vector<Personne> tableauPersonnes = new Vector<>();

  public static void main(String[] args) {
    Personne toto = new Personne("toto", "toto", "toto", "homme");
    Personne tata = new Personne("tata", "tata", "tata", "femme");
    Personne enfant = new Personne("enfant", "enfant", "enfant", "homme");
    Personne titi = new Personne("titi", "titi", "titi", "homme");
    Personne frereToto = new Personne("frereToto", "frereToto", "frereToto", "homme");
    Personne pereToto = new Personne("pereToto", "pereToto", "pereToto", "homme");
    Personne filsOncle = new Personne("filsOncle", "filsOncle", "filsOncle", "homme");

    instancierRelation(Relation.TypeRelation.Parent, toto, titi);
    instancierRelation(Relation.TypeRelation.Parent, toto, enfant);
    instancierRelation(Relation.TypeRelation.Parent, tata, titi);
    instancierRelation(Relation.TypeRelation.Parent, tata, enfant);
    instancierRelation(Relation.TypeRelation.Parent, pereToto, toto);
    instancierRelation(Relation.TypeRelation.Parent, pereToto, frereToto);
    instancierRelation(Relation.TypeRelation.Parent, frereToto, filsOncle);

    instancierRelation(Relation.TypeRelation.Enfant, titi, toto);
    instancierRelation(Relation.TypeRelation.Enfant, titi, tata);
    instancierRelation(Relation.TypeRelation.Enfant, enfant, toto);
    instancierRelation(Relation.TypeRelation.Enfant, enfant, tata);
    instancierRelation(Relation.TypeRelation.Enfant, toto, pereToto);
    instancierRelation(Relation.TypeRelation.Enfant, frereToto, pereToto);
    instancierRelation(Relation.TypeRelation.Enfant, filsOncle, frereToto);

    instancierRelation(Relation.TypeRelation.Mariage, toto, tata);

    tableauPersonnes.add(toto);
    tableauPersonnes.add(tata);
    tableauPersonnes.add(titi);
    tableauPersonnes.add(enfant);
    tableauPersonnes.add(frereToto);
    tableauPersonnes.add(pereToto);
    tableauPersonnes.add(filsOncle);

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
    System.out.println("Choix 6 : Obtenir le père d'une personne");
    System.out.println("Choix 7 : Obtenir la mère d'une personne");
    System.out.println("Choix 8 : Afficher les enfants d'une personne");
    System.out.println("Choix 9 : Afficher les frères d'une personne");
    System.out.println("Choix 10 : Afficher les parents d'une personne");
    System.out.println("Choix 11 : Afficher les cousins d'une personne");
    System.out.println("Choix 12 : Afficher les informations de toutes les personnes enregistrées");

    String choixUtilisateur = lecteur.next();

    switch (choixUtilisateur) {
      // CREER UNE PERSONNE
      case "1" -> {
        tableauPersonnes.add(instancierPersonne());
        Choix();
      }

      // INFORMATION D'UNE PERSONNE
      case "2" -> {
        System.out.println("Quel est le nom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne PersonneConcernee = trouverParPrenom(nomPersonne);
        afficherInfoPersonne(PersonneConcernee);
        System.out.println();
        System.out.println("----------------------------------");

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

      // OBTENIR LE PERE D'UNE PERSONNE
      case "6" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne PersonneConcernee = trouverParPrenom(nomPersonne);
        Personne pere = obtenirPere(PersonneConcernee);

        if(pere == null){
          System.out.println(nomPersonne + " n'a pas de père");
        }
        else {
          System.out.println("Le père de " + nomPersonne + " est " + pere.prenom);
        }
        Choix();


      }

      // OBTENIR LA MERE D'UNE PERSONNE
      case "7" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne PersonneConcernee = trouverParPrenom(nomPersonne);
        obtenirMere(PersonneConcernee);
        Personne mere = obtenirMere(PersonneConcernee);

        if(mere == null){
          System.out.println(nomPersonne + " n'a pas de mère");
        }
        else {
          System.out.println("La mère de " + nomPersonne + " est " + mere.prenom);
        }
        Choix();
      }

      // OBTENIR LES ENFANTS D'UNE PERSONNE
      case "8" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne personneConcernee = trouverParPrenom(nomPersonne);
        ArrayList<Personne> listeEnfants = obtenirEnfants(personneConcernee);

        for(Personne enfant : listeEnfants){
          if(personneConcernee.sexe.equals("homme")){
            System.out.println(personneConcernee.prenom + " est le père de " + enfant.prenom);
          }
          else {
            System.out.println(personneConcernee.prenom + " est la mère de " + enfant.prenom);
          }
        }



        Choix();
      }

      // OBTENIR LES FRERES D'UNE PERSONNE
      case "9" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne personneConcernee = trouverParPrenom(nomPersonne);
        ArrayList<Personne> listeFreres = obtenirFreres(personneConcernee);

        for(Personne frere : listeFreres){
          String phrase;
          if(frere.sexe.equals("homme")){
            phrase = " est le frère de ";
          }
          else {
            phrase = " est la soeur de ";
          }
          System.out.println(frere.prenom + phrase + personneConcernee.prenom);
        }


        Choix();
      }

      // OBTENIR LES PARENTS D'UNE PERSONNE
      case "10" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne personneConcernee = trouverParPrenom(nomPersonne);
        ArrayList<Personne> listeParent = obtenirParents(personneConcernee);

        if(listeParent.size() == 0){
          System.out.println(personneConcernee.prenom + " n'a pas de parents");
        }

        else {
          for(Personne parent : listeParent){
            if(parent.sexe.equals("homme")){
              System.out.println(parent.prenom + " est le père de " + personneConcernee.prenom);
            }
            else {
              System.out.println(parent.prenom + " est la mère de " + personneConcernee.prenom);
            }
          }
        }

        Choix();
      }

      // OBTENIR LES COUSINS D'UNE PERSONNE
      case "11" -> {
        System.out.println("Quel est le prénom de la personne concernée ?");
        String nomPersonne = lecteur.next().toLowerCase();
        Personne personneConcernee = trouverParPrenom(nomPersonne);
        afficherCousins(personneConcernee);
        Choix();
      }

      // AFFICHER LES INFORMATIONS DE TOUTES LES PERSONNES
      case "12" -> {
        for(Personne personne : tableauPersonnes){
          afficherInfoPersonne(personne);
          System.out.println();
          System.out.println("----------------------------------");
        }
        Choix();
      }

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
      System.out.println("Quel est son sexe ? Hommme ou Femme");
      String Sexe = lecteur.next().toLowerCase();
      if(!Sexe.equals("homme") && (!Sexe.equals("femme"))){
        System.out.println("Veuillez entrer une valeur de sexe correcte.");
        System.out.println("Retour à la création d'une personne");
        return instancierPersonne();
      }


      // DATE DE MORT
      System.out.println("La personne possède-t-elle une date de mort ?");
      System.out.println("Répondez par oui ou non.");
      String ReponseDateMort = lecteur.next();
      if(ReponseDateMort.equals("non")){
        return new Personne(Prenom, Nom, DateNaissance, Sexe);
      }
      else if(ReponseDateMort.equals("oui")){
        System.out.println("Quel est la date de mort de la personne ?");
        String DatedeMort = lecteur.next();
        return new Personne(Prenom, Nom, DateNaissance, DatedeMort, Sexe);
      }
      else{
        System.out.println("Veuillez répondre par oui ou non");
        System.out.println("Retour à la création d'une personne");
        return instancierPersonne();
      }

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
    System.out.println(prenom + " n'existe pas, voulez-vous définir cette personne ?");
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
    System.out.println();
    System.out.println("Le nom de la personne est : " + personne1.nom);
    System.out.println("Le prenom de la personne est : " + personne1.prenom);
    System.out.println("Le date de naissance de la personne est : " + personne1.dateNaissance);
    System.out.println("Le date de mort de la personne est : " + personne1.dateMort);
    System.out.println("Le sexe de la personne est : " + personne1.sexe);
    System.out.println();

    // AFFICHER LA LISTE DES RELATIONS
    if(personne1.liste_relations.size() == 0){
      System.out.println("La personne " + personne1.prenom + " n'a aucune relation");
    }
    else{
      System.out.println("Les relations de " + personne1.prenom + " sont :");
      System.out.println();
      for (Relation relation : personne1.liste_relations) {
        afficherRelation(relation);
      }
      ArrayList<Personne> listeFrere = obtenirFreres(personne1);
      for(Personne frere : listeFrere){
        if(frere.sexe.equals("homme")){
          System.out.println(frere.prenom + " est le frère de " + personne1.prenom);
        }
        else {
          System.out.println(frere.prenom + " est la soeur de " + personne1.prenom);
        }
      }

      afficherCousins(personne1);

    }
  }

  private static void afficherRelation(Relation relation) {
    if(relation.type == Relation.TypeRelation.Mariage){
      if(relation.personne1.sexe.equals("homme")){
        System.out.println(relation.personne1.prenom + " est l'époux de " + relation.personne2.prenom);
      }
      else if(relation.personne1.sexe.equals("femme")){
        System.out.println(relation.personne1.prenom + " est l'épouse de " + relation.personne2.prenom);
      }
    }
    else if(relation.type == Relation.TypeRelation.Parent){
      if(relation.personne1.sexe.equals("homme")){
        System.out.println(relation.personne1.prenom + " est le père de " + relation.personne2.prenom);
      }
      else if(relation.personne1.sexe.equals("femme")){
        System.out.println(relation.personne1.prenom + " est la mère de " + relation.personne2.prenom);
      }
    }

}

  private static Personne obtenirPere(Personne personne1){
    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " ne possède pas de père");
    }
    else{
      for (Relation relation : personne1.liste_relations){
        if(relation.type == Relation.TypeRelation.Enfant && relation.personne1.equals(personne1)){
          if(relation.personne2.sexe.equals("homme")){
            return relation.personne2;
          }
        }
      }
    }
    return null;
  }

  private static Personne obtenirMere(Personne personne1){
    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " ne possède pas de mère");
    }
    else{
      for (Relation relation : personne1.liste_relations){
        if(relation.type == Relation.TypeRelation.Enfant && relation.personne1.equals(personne1)){
          if(relation.personne2.sexe.equals("femme")){
            return relation.personne2;
          }
        }
      }
    }
    return null;
  }

  private static ArrayList<Personne> obtenirEnfants(Personne personne1){
    if(personne1 == null){
      return new ArrayList<>();
    }

    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " ne possède pas d'enfant");
      return new ArrayList<>();
    }
    else{
      ArrayList<Personne> listeEnfant = new ArrayList<>();
      for (Relation relation : personne1.liste_relations){
        if(relation.type == Relation.TypeRelation.Parent && relation.personne1.equals(personne1)){

          listeEnfant.add(relation.personne2);
        }
      }
      return listeEnfant;
    }
  }

  private static ArrayList<Personne> obtenirFreres(Personne personne1){
    if(personne1 == null){
      return new ArrayList<>();
    }

    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " n'a pas de frère");
      return new ArrayList<>();
    }
    else {
      Personne pere = obtenirPere(personne1);
      ArrayList <Personne> listeEnfant = obtenirEnfants(pere);
      listeEnfant.remove(personne1);
      return listeEnfant;
    }

  }

  private static ArrayList<Personne> obtenirParents(Personne personne1){
    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " n'a pas de parents");
      return new ArrayList<>();
    }
    else{
      ArrayList<Personne> listeParents = new ArrayList<>();
      listeParents.add(obtenirMere(personne1));
      listeParents.add(obtenirPere(personne1));
      if(listeParents.size() == 0){
        return new ArrayList<>();
      }
      else {
        return listeParents;
      }
    }
  }

  private static ArrayList<Personne> obtenirCousins(Personne personne1){
    if(personne1.liste_relations.size() == 0){
      System.out.println(personne1.prenom + " n'a pas de cousins");
      return new ArrayList<>();
    }
    else {
      ArrayList<Personne> listeCousins = new ArrayList<>();
      ArrayList<Personne> listeFreresDesParents = new ArrayList<>();

      ArrayList<Personne> listeParents = obtenirParents(personne1);
      for (Personne parent : listeParents){
        ArrayList<Personne> freresDuParent = obtenirFreres(parent);
        freresDuParent.remove(parent);
        listeFreresDesParents.addAll(freresDuParent);
      }

      for(Personne frereDuParent : listeFreresDesParents){
        ArrayList<Personne> listeEnfantsDuFrereDuParent = obtenirEnfants(frereDuParent);
        listeCousins.addAll(listeEnfantsDuFrereDuParent);
      }
      return listeCousins;
    }
  }

  private static void afficherCousins(Personne personne){
    ArrayList<Personne> listeCousins = obtenirCousins(personne);
    for(Personne cousin : listeCousins){
      if(cousin.sexe.equals("homme")){
        System.out.println(cousin.prenom + " est le cousin de " + personne.prenom);
      }
      else {
        System.out.println(cousin.prenom + " est la cousine de " + personne.prenom);
      }
    }
  }

}
