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
		System.out.println("Choix 1 : Créer une personne");
		System.out.println("Choix 2 : Size du tableau de personnes");
		System.out.println("Choix 3 : Je veux sortir désolé..");
		System.out.println("Choix 4 : Marier deux personnes");
		System.out.println("Choix 5 : Etablir un lien de parenté");
		int choixUtilisateur = lecteur.nextInt();

		// CREER UNE PERSONNE
		if (choixUtilisateur == 1) {

			tableauPersonnes.add(instancierPersonne());
			Choix();

		}
		// TAILLE DU TABLEAU
		else if (choixUtilisateur == 2) {

			Personne toto = new Personne("Toto", "Toto", "Toto", "Toto");
			tableauPersonnes.add(toto);

			System.out.println("Taille du tableau : " + tableauPersonnes.size());
			Choix();

		}
		// QUITTER LE PROGRAMME
		else if (choixUtilisateur == 3) {
			System.out.println("Vous quittez le programme");
			System.exit(0);

		}
		// MARIAGE
		else if (choixUtilisateur == 4) {
			saisirRelation("Mariage");
		}
		// LIEN DE PARENTE
		else if (choixUtilisateur == 5) {
			saisirRelation("Parenté");
		}
		/**
		 * trouverCousins(prenomPersonne);
		 * private static Vector<Relation> trouverCousins(String prenomPersonne) {
		 *   Personne personne = trouverParPrenom(prenom);
		 *   Vector<Personne> cousins = Vector<>;
		 * 	 Vector<Personne> parents = personne.liste_relations.find(relation => relation.type == "Parenté" && relation.personne2 == personne);
		 * 	 for(Personne parent: parents) {
		 * 	 	Vector<Personne> grandsParents = parent.liste_relations.find(relation => relation.type == "Parenté" && relation.personne2 == parent);
		 * 	 	for(Personne grandParent: grandsParents) {
		 * 	 		Vector<Personne> onclesEtTantes = grandParent.liste_relations.find(relation => relation.type == "Parenté" && relation.personne1 == grandParent);
		 * 	 		for(Vector<Personne> oncleOuTante: onclesEtTantes) {
		 *				for(Personne cousin: oncleOuTante.liste_relations.find(relation => relation.type == "Parenté" && relation.personne1 == oncleOuTante) {
		 *					cousins.add(cousin);
		 *				}
		 * 	 		}
		 * 	 	}
		 * 	 }
		 * 	 for(Personne cousin: cousins) {
		 * 		 println(cousin.prenom + " est le cousin de " + personne.prenom);
		 * 	 }
		 * }
		 */
		else {
			System.out.println("Obligé de choisir un choix.");
			Choix();
		}
	}

	private static Personne instancierPersonne() {
		Scanner lecteur = new Scanner(System.in);
		System.out.println("Voulez-vous créer une personne ?");
		System.out.println("Répondez par oui ou non");
		String ajoutNouvellePersonne = lecteur.next().toLowerCase();
		if (ajoutNouvellePersonne.equals("oui")) {

			// PRENOM
			System.out.println("Quel est son prénom ?");
			String Prenom = lecteur.next();

			// NOM
			System.out.println("Quel est son nom de famille ?");
			String Nom = lecteur.next();

			// DATE NAISSANCE
			System.out.println("Quel est sa date de naissance ?");
			String DateNaissance = lecteur.next();

			// SEXE
			System.out.println("Quel est son sexe ?");
			String Sexe = lecteur.next();
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

	private static void saisirRelation(String type) {
		String premiereSortie = "Qui est la première personne ?";
		String deuxiemeSortie = "Qui est la deuxième personne ?";
		if(type.equals("Parenté")) {
			premiereSortie = "Qui est le parent ?";
			deuxiemeSortie = "Qui est l'enfant ?";
		}
		System.out.println(premiereSortie);
		String prenomPersonne1 = lecteur.next();
		Personne personne1 = trouverParPrenom(prenomPersonne1);
		System.out.println(deuxiemeSortie);
		String prenomPersonne2 = lecteur.next();
		Personne personne2 = trouverParPrenom(prenomPersonne2);
		tableauPersonnes.add(personne1);
		tableauPersonnes.add(personne2);

		instancierRelation(type, personne1, personne2);
		// test

		System.out.println("Pers 1: " + personne1.liste_relations.size() + ", pers 2:" +  personne2.liste_relations.get(0).personne1.prenom);
	}

	private static void instancierRelation(String type, Personne Personne1, Personne Personne2) {
		Relation relation = new Relation(type, Personne1, Personne2);
		Personne1.liste_relations.add(relation);
		Personne2.liste_relations.add(relation);
	}

}
